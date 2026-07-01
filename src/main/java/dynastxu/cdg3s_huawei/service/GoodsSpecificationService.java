package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.GoodsSpecification;
import dynastxu.cdg3s_huawei.repository.GoodsSpecificationRepository;
import org.springframework.stereotype.Service;

@Service
public class GoodsSpecificationService extends BaseService<GoodsSpecificationRepository> {
    public GoodsSpecificationService(GoodsSpecificationRepository repository) {
        super(repository);
    }

    public GoodsSpecification save(GoodsSpecification goodsSpecification) {
        return repository.save(goodsSpecification);
    }

    public GoodsSpecification findByNameAndValue(String name, String value) {
        return repository.findByNameAndValue(name, value).orElse(null);
    }
}
