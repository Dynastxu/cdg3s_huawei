package dynastxu.cdg3s_huawei.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class TestController {
    /**
     * 公开接⼝：⽆需认证（放⾏）
     */
    @GetMapping("/public")
    public String publicApi() {
        return "这是公开接⼝，⽆需登录即可访问";
    }

    /**
     * 受保护接⼝：需登录认证（任意⻆⾊均可访问）
     */
    @GetMapping("/protected")
    public String protectedApi() {
        return "这是受保护接⼝，登录后即可访问";
    }

    /**
     * 管理员接⼝：需 ADMIN ⻆⾊（仅 admin ⽤户可访问）
     */
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')") // 注解式权限控制
    public String adminApi() {
        return "这是管理员接⼝，仅 ROLE_ADMIN ⻆⾊可访问";
    }

    /**
     * 普通⽤户接⼝：需 USER ⻆⾊（仅 user ⽤户可访问）
     */
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userApi() {
        return "这是普通⽤户接⼝，仅 ROLE_USER ⻆⾊可访问";
    }
}
