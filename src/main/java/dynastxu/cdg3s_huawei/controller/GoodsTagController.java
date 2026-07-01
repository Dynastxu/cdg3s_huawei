package dynastxu.cdg3s_huawei.controller;

import dynastxu.cdg3s_huawei.entity.GoodsTag;
import dynastxu.cdg3s_huawei.service.GoodsTagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/goods/tag")
public class GoodsTagController extends BaseController<GoodsTagService> {
    GoodsTagController(GoodsTagService goodsTagService) {
        super(goodsTagService);
    }

    @RequestMapping
    @ResponseBody
    public GoodsTag getTag(Long id) {
        return service.findById(id);
    }
}
