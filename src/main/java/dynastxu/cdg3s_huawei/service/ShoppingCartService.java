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

    /**
     * 向购物车添加商品
     * <p>
     * 逻辑说明：
     * 1. 查询当前用户和商品的所有购物车记录
     * 2. 在内存中匹配规格组合完全相同的购物车项
     * 3. 如果不存在相同规格组合，则创建新的购物车记录
     * 4. 如果存在相同规格组合，则增加数量；数量小于等于0时删除该记录
     *
     * @param user           用户
     * @param goods          商品
     * @param specifications 规格组合
     * @return 更新后的购物车记录，如果数量小于等于0则返回null
     */
    public ShoppingCart addGoods(User user, Goods goods, Set<GoodsSpecification> specifications) {
        // 查询同一用户和商品的所有购物车项
        List<ShoppingCart> existingCarts = repository.findByUserAndGoods(user, goods);
        // 匹配规格组合完全相同的购物车项
        ShoppingCart existing = existingCarts.stream()
                .filter(cart -> cart.getSpecifications().equals(specifications))
                .findFirst()
                .orElse(null);
        if (existing == null) {
            // 不存在相同规格组合，创建新记录
            return repository.save(
                    ShoppingCart.builder()
                            .user(user)
                            .goods(goods)
                            .specifications(specifications)
                            .build()
            );
        } else {
            // 存在相同规格组合，增加数量
            Integer nowNum = existing.addQuantity();
            if (nowNum <= 0) {
                // 数量小于等于0，删除该记录
                repository.delete(existing);
                return null;
            } else {
                // 更新数量
                return repository.save(existing);
            }
        }
    }

    public List<ShoppingCart> findByUsername(String username) {
        return repository.findByUser_Username(username);
    }
}
