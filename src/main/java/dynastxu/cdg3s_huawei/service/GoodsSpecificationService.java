package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.GoodsSpecification;
import dynastxu.cdg3s_huawei.repository.GoodsSpecificationRepository;
import org.springframework.stereotype.Service;

@Service
public class GoodsSpecificationService extends BaseService<GoodsSpecificationRepository, GoodsSpecification> {
    public GoodsSpecificationService(GoodsSpecificationRepository repository) {
        super(repository);
    }

    public GoodsSpecification findByNameAndValue(String name, String value) {
        return repository.findByNameAndValue(name, value).orElse(null);
    }
}
