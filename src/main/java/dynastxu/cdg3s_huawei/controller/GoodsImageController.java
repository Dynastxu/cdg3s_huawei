package dynastxu.cdg3s_huawei.controller;

import dynastxu.cdg3s_huawei.entity.GoodsSpecificationImage;
import dynastxu.cdg3s_huawei.service.GoodsImageService;
import dynastxu.cdg3s_huawei.service.GoodsSpecificationImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/goods/image")
public class GoodsImageController {
    private final GoodsImageService goodsImageService;
    private final GoodsSpecificationImageService goodsSpecificationImageService;

    public GoodsImageController(
            GoodsImageService goodsImageService,
            GoodsSpecificationImageService goodsSpecificationImageService
    ) {
        this.goodsImageService = goodsImageService;
        this.goodsSpecificationImageService = goodsSpecificationImageService;
    }

    @RequestMapping("/specification")
    @ResponseBody
    public List<GoodsSpecificationImage> GoodsSpecificationImages(Long goodsId) {
        return goodsSpecificationImageService.findByGoodsId(goodsId);
    }
}
