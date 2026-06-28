package dynastxu.cdg3s_huawei.controller;

import dynastxu.cdg3s_huawei.dto.LoginRequest;
import dynastxu.cdg3s_huawei.dto.RegisterRequest;
import dynastxu.cdg3s_huawei.entity.User;
import dynastxu.cdg3s_huawei.jwt.JwtTokenUtil;
import dynastxu.cdg3s_huawei.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController<UserService> {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    AuthController(UserService userService, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        super(userService);
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            if (userDetails == null) throw new UsernameNotFoundException("Invalid username or password");
            String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "登录成功",
                    "token", token
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "用户名或密码错误"
            ));
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> register(@Valid @RequestBody RegisterRequest request) {
        try {
            User user = service.register(request.getUsername(), request.getPassword());

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "注册成功"
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", e.getMessage()
            ));
        }
    }
}
