package dynastxu.cdg3s_huawei.repository;

import dynastxu.cdg3s_huawei.entity.GoodsSpecification;

import java.util.Optional;

public interface GoodsSpecificationRepository extends BaseRepository<GoodsSpecification, Integer> {
    Optional<GoodsSpecification> findByNameAndValue(String name, String value);
}
