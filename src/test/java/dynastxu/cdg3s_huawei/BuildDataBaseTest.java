package dynastxu.cdg3s_huawei;

import dynastxu.cdg3s_huawei.entity.Category;
import dynastxu.cdg3s_huawei.entity.Goods;
import dynastxu.cdg3s_huawei.entity.GoodsImage;
import dynastxu.cdg3s_huawei.entity.GoodsTag;
import dynastxu.cdg3s_huawei.service.*;
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

    @Autowired
    private UserService userService;

    @Test
    void buildDataBase() {
        buildCategory();
        buildGoodsImage();
        buildGoodsTag();
        buildGoods();
        buildUser();
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
        service.saveOrUpdate(new Category("REDMI手机配件", service.findByName("手机配件")));
        service.saveOrUpdate(new Category("创意配件", service.findByName("手机配件")));

        service.saveOrUpdate(new Category("Xiaomi平板", service.findByName("平板")));
        service.saveOrUpdate(new Category("REDMI平板", service.findByName("平板")));
        service.saveOrUpdate(new Category("平板配件", service.findByName("平板")));

        service.saveOrUpdate(new Category("智能手环", service.findByName("智能穿戴")));
        service.saveOrUpdate(new Category("智能手表", service.findByName("智能穿戴")));
        service.saveOrUpdate(new Category("智能耳机", service.findByName("智能穿戴")));
        service.saveOrUpdate(new Category("其他穿戴", service.findByName("智能穿戴")));

        service.saveOrUpdate(new Category("笔记本", service.findByName("电脑办公")));
        service.saveOrUpdate(new Category("显示器", service.findByName("电脑办公")));
        service.saveOrUpdate(new Category("办公配件", service.findByName("电脑办公")));

        service.saveOrUpdate(new Category("旗舰系列", service.findByName("电视")));
        service.saveOrUpdate(new Category("性价比爆款", service.findByName("电视")));
        service.saveOrUpdate(new Category("巨幕影院", service.findByName("电视")));
        service.saveOrUpdate(new Category("激光投影", service.findByName("电视")));
        service.saveOrUpdate(new Category("小米盒子", service.findByName("电视")));
        service.saveOrUpdate(new Category("电视周边", service.findByName("电视")));

        service.saveOrUpdate(new Category("挂壁空调", service.findByName("空调")));
        service.saveOrUpdate(new Category("立式空调", service.findByName("空调")));
        service.saveOrUpdate(new Category("中央空调", service.findByName("空调")));
        service.saveOrUpdate(new Category("中央空调配件", service.findByName("空调")));
        service.saveOrUpdate(new Category("挂机/柜机配件", service.findByName("空调")));

        service.saveOrUpdate(new Category("热销推荐", service.findByName("洗衣机")));
        service.saveOrUpdate(new Category("主推新品", service.findByName("洗衣机")));
        service.saveOrUpdate(new Category("波轮洗衣机", service.findByName("洗衣机")));
        service.saveOrUpdate(new Category("洗烘一体机", service.findByName("洗衣机")));
        service.saveOrUpdate(new Category("滚筒洗衣机", service.findByName("洗衣机")));
        service.saveOrUpdate(new Category("迷你/内衣洗", service.findByName("洗衣机")));
        service.saveOrUpdate(new Category("干衣机", service.findByName("洗衣机")));
        service.saveOrUpdate(new Category("洗烘套装", service.findByName("洗衣机")));
        service.saveOrUpdate(new Category("蓝氧洗衣机", service.findByName("洗衣机")));

        service.saveOrUpdate(new Category("热销系列", service.findByName("冰箱")));
        service.saveOrUpdate(new Category("容积分类", service.findByName("冰箱")));
        service.saveOrUpdate(new Category("门体分类", service.findByName("冰箱")));
        service.saveOrUpdate(new Category("冰箱配件", service.findByName("冰箱")));

        service.saveOrUpdate(new Category("清洁电器", service.findByName("小家电")));
        service.saveOrUpdate(new Category("环境电器", service.findByName("小家电")));
        service.saveOrUpdate(new Category("厨房小电", service.findByName("小家电")));
        service.saveOrUpdate(new Category("个护电器", service.findByName("小家电")));

        service.saveOrUpdate(new Category("小爱音响", service.findByName("智能家居")));
        service.saveOrUpdate(new Category("路由器", service.findByName("智能家居")));
        service.saveOrUpdate(new Category("智能安防", service.findByName("智能家居")));
        service.saveOrUpdate(new Category("智能家装", service.findByName("智能家居")));
        service.saveOrUpdate(new Category("智能控制", service.findByName("智能家居")));
        service.saveOrUpdate(new Category("智能传灯具", service.findByName("智能家居")));
        service.saveOrUpdate(new Category("智能酷玩", service.findByName("智能家居")));

        service.saveOrUpdate(new Category("户外出行", service.findByName("出行运动")));
        service.saveOrUpdate(new Category("运动健康", service.findByName("出行运动")));
        service.saveOrUpdate(new Category("箱包", service.findByName("出行运动")));

        service.saveOrUpdate(new Category("通用品", service.findByName("车周边")));
        service.saveOrUpdate(new Category("XiaomiLife", service.findByName("车周边")));

        service.saveOrUpdate(new Category("家具日用", service.findByName("日用百货")));
        service.saveOrUpdate(new Category("个人护理", service.findByName("日用百货")));
        service.saveOrUpdate(new Category("防护清洁", service.findByName("日用百货")));
        service.saveOrUpdate(new Category("床品家居", service.findByName("日用百货")));
        service.saveOrUpdate(new Category("鞋服配饰", service.findByName("日用百货")));

        service.saveOrUpdate(new Category("热门推荐", service.findByName("小米服务")));
        service.saveOrUpdate(new Category("电池服务", service.findByName("小米服务")));
        service.saveOrUpdate(new Category("安装服务", service.findByName("小米服务")));
        service.saveOrUpdate(new Category("手机服务", service.findByName("小米服务")));
        service.saveOrUpdate(new Category("维修服务", service.findByName("小米服务")));
        service.saveOrUpdate(new Category("清洁保养", service.findByName("小米服务")));
        service.saveOrUpdate(new Category("勘测服务", service.findByName("小米服务")));
        service.saveOrUpdate(new Category("保障服务", service.findByName("小米服务")));
        service.saveOrUpdate(new Category("购买无忧", service.findByName("小米服务")));
        service.saveOrUpdate(new Category("金融服务", service.findByName("小米服务")));
        service.saveOrUpdate(new Category("通信服务", service.findByName("小米服务")));
        service.saveOrUpdate(new Category("小米云服务", service.findByName("小米服务")));
        service.saveOrUpdate(new Category("其他服务", service.findByName("小米服务")));

        service.saveOrUpdate(new Category("热卖好物", service.findByName("有品精选")));
        service.saveOrUpdate(new Category("有品爆品", service.findByName("有品精选")));
        service.saveOrUpdate(new Category("日常元素", service.findByName("有品精选")));





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
                .category(categoryService.findByName("Xiaomi 数字旗舰"))
                .goodsTag(List.of(
                        goodsTagService.findByName("小米上新"),
                        goodsTagService.findByName("换新补贴")
                ))
                .mainImage(goodsImageService.findByImagePath("/images/goods/xiaomi_17t_pro/1.png"))
                .build()
        );
    }

    private void buildUser() {
        UserService service = userService;

        service.register("ZhangSan", "123456");
        service.register("LiSi", "666666");
    }
}
