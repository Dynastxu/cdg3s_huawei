package dynastxu.cdg3s_huawei.repository;

import dynastxu.cdg3s_huawei.entity.GoodsSpecification;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoodsSpecificationRepository extends BaseRepository<GoodsSpecification, Integer> {
    Optional<GoodsSpecification> findByNameAndValue(String name, String value);
}
