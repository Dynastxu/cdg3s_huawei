package dynastxu.cdg3s_huawei.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.InvalidClaimException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. 提取令牌（从 Authorization 请求头）
        final String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        // 校验请求头格式：必须是 "Bearer <token>"
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7); // 截取 "Bearer " 后的令牌
            try {
                // 从令牌中提取⽤户名
                username = jwtTokenUtil.extractUsername(jwtToken);
            } catch (ExpiredJwtException e) {
                log.error("JWT 令牌已过期：{}", e.getMessage());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "令牌已过期");
                return;
            } catch (SignatureException e) {
                log.error("JWT 签名无效：{}", e.getMessage());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "令牌签名无效");
                return;
            } catch (MalformedJwtException e) {
                log.error("JWT 格式错误：{}", e.getMessage());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "令牌格式错误");
                return;
            } catch (UnsupportedJwtException e) {
                log.error("JWT 令牌不⽀持：{}", e.getMessage());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "不⽀持的令牌类型");
                return;
            } catch (InvalidClaimException e) {
                log.error("JWT 载荷⽆效：{}", e.getMessage());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "令牌信息⽆效");
                return;
            } catch (IllegalArgumentException e) {
                log.error("JWT 令牌为空或载荷为空：{}", e.getMessage());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "令牌为空或⽆效");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
