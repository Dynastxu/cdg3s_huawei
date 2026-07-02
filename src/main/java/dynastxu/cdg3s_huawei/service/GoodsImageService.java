package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.GoodsImage;
import dynastxu.cdg3s_huawei.repository.GoodsImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsImageService extends BaseService<GoodsImageRepository, GoodsImage> {
    GoodsImageService(GoodsImageRepository repository) {
        super(repository);
    }

    public GoodsImage findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public GoodsImage findByImagePath(String imagePath) {
        List<GoodsImage> images = repository.findByImagePath(imagePath);
        if (images.isEmpty()) {
            return null;
        } else {
            return images.get(0);
        }
    }
}
