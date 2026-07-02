package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.Goods;
import dynastxu.cdg3s_huawei.repository.GoodsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService extends BaseService<GoodsRepository, Goods> {
    public GoodsService(GoodsRepository repository) {
        super(repository);
    }

    public List<Goods> findByCategoryId(Long id) {
        return repository.findByCategory_Id(id);
    }

    public Goods findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
