package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.User;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(@Lazy UserService userService) {
        this.userService = userService;
    }

    @Override
    public @NonNull UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        // 1. 从数据库查询用户
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在：" + username);
        }
        // 2. 构建用户详情（用户名、加密后的密码、权限列表）
        String password = user.getPassword();
        // 根据 permissionLevel 判断角色
        String role = (user.getPermissionLevel() != null && user.getPermissionLevel() >= 1)
                ? "ROLE_ADMIN" : "ROLE_USER";
        return org.springframework.security.core.userdetails.User.builder()
                .username(username)
                .password(password)
                .authorities(Collections.singletonList(new SimpleGrantedAuthority(role)))
                .accountExpired(false)
                .accountLocked(user.getLocked())
                .credentialsExpired(false)
                .disabled(!user.getEnabled())
                .build();
    }
}
