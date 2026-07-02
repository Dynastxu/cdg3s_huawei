package dynastxu.cdg3s_huawei.controller;

import dynastxu.cdg3s_huawei.entity.ShoppingCart;
import dynastxu.cdg3s_huawei.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController extends BaseController<ShoppingCartService> {
    ShoppingCartController(ShoppingCartService shoppingCartService) {
        super(shoppingCartService);
    }

    @RequestMapping
    @ResponseBody
    public List<ShoppingCart> getShoppingCart(String username) {
        return service.findByUsername(username);
    }
}
