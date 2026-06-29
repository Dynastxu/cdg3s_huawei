package dynastxu.cdg3s_huawei.controller;

import dynastxu.cdg3s_huawei.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<UserService> {
    UserController(UserService userService) {
        super(userService);
    }

    @RequestMapping("/nickname")
    @ResponseBody
    public Map<String, String> nickname(String username) {
        String nickname = service.getNickname(username);
        Map<String, String> response = new HashMap<>();
        response.put("nickname", nickname);
        return response;
    }
}
