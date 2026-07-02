package dynastxu.cdg3s_huawei.repository;

import dynastxu.cdg3s_huawei.entity.Goods;
import dynastxu.cdg3s_huawei.entity.ShoppingCart;
import dynastxu.cdg3s_huawei.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends BaseRepository<ShoppingCart, Integer> {
    List<ShoppingCart> findByUser_Username(String userUsername);

    List<ShoppingCart> findByUserAndGoods(User user, Goods goods);
}
