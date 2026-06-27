package dynastxu.cdg3s_huawei;

import dynastxu.cdg3s_huawei.entity.Category;
import dynastxu.cdg3s_huawei.entity.Goods;
import dynastxu.cdg3s_huawei.entity.GoodsImage;
import dynastxu.cdg3s_huawei.entity.GoodsTag;
import dynastxu.cdg3s_huawei.service.CategoryService;
import dynastxu.cdg3s_huawei.service.GoodsImageService;
import dynastxu.cdg3s_huawei.service.GoodsService;
import dynastxu.cdg3s_huawei.service.GoodsTagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BuildDataBaseTest {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsImageService goodsImageService;

    @Autowired
    private GoodsTagService goodsTagService;

    @Autowired
    private GoodsService goodsService;

    @Test
    void buildDataBase() {
        buildCategory();
        buildGoodsImage();
        buildGoodsTag();
        buildGoods();
    }

    private void buildCategory() {
        CategoryService service = categoryService;

        service.saveOrUpdate(new Category("Xiaomi手机"));
        service.saveOrUpdate(new Category("REDMI手机"));
        service.saveOrUpdate(new Category("手机配件"));
        service.saveOrUpdate(new Category("平板"));
        service.saveOrUpdate(new Category("智能穿戴"));
        service.saveOrUpdate(new Category("电脑办公"));
        service.saveOrUpdate(new Category("电视"));
        service.saveOrUpdate(new Category("空调"));
        service.saveOrUpdate(new Category("洗衣机"));
        service.saveOrUpdate(new Category("冰箱"));
        service.saveOrUpdate(new Category("厨房大电"));
        service.saveOrUpdate(new Category("小家电"));
        service.saveOrUpdate(new Category("智能家居"));
        service.saveOrUpdate(new Category("出行运动"));
        service.saveOrUpdate(new Category("车周边"));
        service.saveOrUpdate(new Category("日用百货"));
        service.saveOrUpdate(new Category("小米服务"));
        service.saveOrUpdate(new Category("儿童用品"));
        service.saveOrUpdate(new Category("有品精选"));

        service.saveOrUpdate(new Category("Xiaomi 数字旗舰", service.findByName("Xiaomi手机")));
        service.saveOrUpdate(new Category("Xiaomi MIX系列", service.findByName("Xiaomi手机")));
        service.saveOrUpdate(new Category("Xiaomi Civi", service.findByName("Xiaomi手机")));
        service.saveOrUpdate(new Category("Xiaomi手机套装", service.findByName("Xiaomi手机")));

        service.saveOrUpdate(new Category("K系列", service.findByName("REDMI手机")));
        service.saveOrUpdate(new Category("Note系列", service.findByName("REDMI手机")));
        service.saveOrUpdate(new Category("Turbo系列", service.findByName("REDMI手机")));
        service.saveOrUpdate(new Category("数字系列", service.findByName("REDMI手机")));

        service.saveOrUpdate(new Category("Xiaomi配件", service.findByName("手机配件")));

    }

    private void buildGoodsImage() {
        GoodsImageService service = goodsImageService;
        String rootPath = "/images/goods";

        service.saveIfUnique(new GoodsImage(rootPath + "/xiaomi_17t_pro/1.png"));
        service.saveIfUnique(new GoodsImage(rootPath + "/xiaomi_17t_pro/2.png"));
        service.saveIfUnique(new GoodsImage(rootPath + "/xiaomi_17t_pro/3.png"));
        service.saveIfUnique(new GoodsImage(rootPath + "/xiaomi_17t_pro/4.png"));
    }

    private void buildGoodsTag() {
        GoodsTagService service = goodsTagService;

        service.saveOrUpdate(new GoodsTag("小米上新"));
        service.saveOrUpdate(new GoodsTag("换新补贴"));
        service.saveOrUpdate(new GoodsTag("小时达"));
    }

    private void buildGoods() {
        GoodsService service = goodsService;

        service.saveIfUnique(Goods.builder()
                .name("Xiaomi 17T Pro")
                .price(3999f)
                .isStartingPrice(true)
                .category(categoryService.findByName("Xiaomi数字旗舰"))
                .goodsTag(List.of(
                        goodsTagService.findByName("小米上新"),
                        goodsTagService.findByName("换新补贴")
                ))
                .build()
        );
    }
}
