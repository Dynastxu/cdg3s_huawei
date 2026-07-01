package dynastxu.cdg3s_huawei.repository;

import dynastxu.cdg3s_huawei.entity.GoodsSpecification;
import dynastxu.cdg3s_huawei.entity.GoodsSpecificationImage;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface GoodsSpecificationImageRepository extends BaseRepository<GoodsSpecificationImage, Integer> {
    Optional<GoodsSpecificationImage> findByGoods_IdAndSpecifications(Long goodsId, Set<GoodsSpecification> specifications);

    List<GoodsSpecificationImage> findByGoods_Id(Long goodsId);
}
