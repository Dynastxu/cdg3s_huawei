package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.GoodsSpecificationImage;
import dynastxu.cdg3s_huawei.repository.GoodsSpecificationImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsSpecificationImageService extends BaseService<GoodsSpecificationImageRepository, GoodsSpecificationImage> {
    public GoodsSpecificationImageService(GoodsSpecificationImageRepository repository) {
        super(repository);
    }

    public List<GoodsSpecificationImage> findByGoodsId(Long goodsId) {
        return repository.findByGoods_Id(goodsId);
    }
}
