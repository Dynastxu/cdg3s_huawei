package dynastxu.cdg3s_huawei.controller;

import dynastxu.cdg3s_huawei.entity.Goods;
import dynastxu.cdg3s_huawei.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController<GoodsService> {
    GoodsController(GoodsService goodsService) {
        super(goodsService);
    }

    @RequestMapping("/getCategoryGoods")
    @ResponseBody
    public List<Goods> getCategoryGoods(Long categoryId) {
        return service.findByCategoryId(categoryId);
    }

    @RequestMapping
    @ResponseBody
    public Goods getGoods(Long id) {
        return service.findById(id);
    }
}
