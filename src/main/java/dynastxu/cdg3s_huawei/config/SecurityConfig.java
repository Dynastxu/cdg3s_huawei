package dynastxu.cdg3s_huawei.config;

import dynastxu.cdg3s_huawei.jwt.JwtAccessDeniedHandler;
import dynastxu.cdg3s_huawei.jwt.JwtAuthenticationEntryPoint;
import dynastxu.cdg3s_huawei.jwt.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * 认证提供者：指定⽤户详情服务和密码加密器
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


    /**
     * 配置 Spring Security 过滤器链。
     *
     * @param http HttpSecurity 配置对象
     * @return 构建好的 SecurityFilterChain
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http
                // 配置URL访问权限
                .authorizeHttpRequests(auth -> auth
                        // 允许匿名访问的接口
                        .requestMatchers(
                                "/auth/register",
                                "/auth/login",
                                "/category/**",
                                "/goods/**",
                                "/images/goods/**"
                        ).permitAll()
                        // 管理员接⼝：仅 ADMIN ⻆⾊可访问（也可通过 @PreAuthorize 注解控制）
                        .requestMatchers("/api/admin").hasRole("ADMIN")
                        // 其他所有请求都需要认证
                        .anyRequest().authenticated()
                )
                // 关闭 CSRF（前后端分离场景，⽆ Session，CSRF ⽆意义）
                .csrf(AbstractHttpConfigurer::disable)
                // 关闭 Session（JWT 是⽆状态认证）
                .sessionManagement((session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)))
                // 配置异常处理器
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint) // 401 异常
                        .accessDeniedHandler(jwtAccessDeniedHandler) // 403 异常
                )
                // 注册 JWT 过滤器（在 UsernamePasswordAuthenticationFilter 之前执⾏）
                .addFilterBefore(jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class)
                // 配置认证提供者
                .authenticationProvider(authenticationProvider());

        return http.build();
    }
}
