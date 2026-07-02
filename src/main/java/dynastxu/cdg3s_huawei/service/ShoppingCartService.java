package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.Goods;
import dynastxu.cdg3s_huawei.entity.GoodsSpecification;
import dynastxu.cdg3s_huawei.entity.ShoppingCart;
import dynastxu.cdg3s_huawei.entity.User;
import dynastxu.cdg3s_huawei.repository.ShoppingCartRepository;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class ShoppingCartService extends BaseService<ShoppingCartRepository, ShoppingCart> {

    @Override
    public ShoppingCart save(@NonNull ShoppingCart shoppingCart) {
        User user = shoppingCart.getUser();
        Goods goods = shoppingCart.getGoods();
        Set<GoodsSpecification> specifications = shoppingCart.getSpecifications();
        return addGoods(user, goods, specifications);
    }

    public ShoppingCartService(ShoppingCartRepository repository) {
        super(repository);
    }

    public ShoppingCart addGoods(User user, Goods goods, Set<GoodsSpecification> specifications) {
        List<ShoppingCart> existingCarts = repository.findByUserAndGoods(user, goods);
        ShoppingCart existing = existingCarts.stream()
                .filter(cart -> cart.getSpecifications().equals(specifications))
                .findFirst()
                .orElse(null);
        if (existing == null) {
            return repository.save(
                    ShoppingCart.builder()
                            .user(user)
                            .goods(goods)
                            .specifications(specifications)
                            .build()
            );
        } else {
            Integer nowNum = existing.addQuantity();
            if (nowNum <= 0) {
                repository.delete(existing);
                return null;
            } else {
                return repository.save(existing);
            }
        }
    }
}
