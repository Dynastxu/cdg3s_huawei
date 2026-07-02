package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.GoodsTag;
import dynastxu.cdg3s_huawei.repository.GoodsTagRepository;
import org.springframework.stereotype.Service;

@Service
public class GoodsTagService extends BaseService<GoodsTagRepository, GoodsTag> {
    public GoodsTagService(GoodsTagRepository repository) {
        super(repository);
    }

    public GoodsTag findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public GoodsTag findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
