package dynastxu.cdg3s_huawei;

import dynastxu.cdg3s_huawei.entity.*;
import dynastxu.cdg3s_huawei.service.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class DatabaseGenerator {
    private final CategoryService categoryService;

    private final GoodsImageService goodsImageService;

    private final GoodsTagService goodsTagService;

    private final GoodsService goodsService;

    private final UserService userService;

    private final GoodsSpecificationService goodsSpecificationService;

    public DatabaseGenerator(
            CategoryService categoryService,
            GoodsImageService goodsImageService,
            GoodsTagService goodsTagService,
            GoodsService goodsService,
            UserService userService,
            GoodsSpecificationService goodsSpecificationService
    ) {
        this.categoryService = categoryService;
        this.goodsImageService = goodsImageService;
        this.goodsTagService = goodsTagService;
        this.goodsService = goodsService;
        this.userService = userService;
        this.goodsSpecificationService = goodsSpecificationService;
        genDatabase();
    }

    void genDatabase() {
        genCategory();
        genGoodsImage();
        genGoodsTag();
        genGoodsSpecification();
        genGoods();
        genUser();
    }

    private void genCategory() {
        CategoryService service = categoryService;

        service.save(new Category("Xiaomi手机"));
        service.save(new Category("REDMI手机"));
        service.save(new Category("手机配件"));
        service.save(new Category("平板"));
        service.save(new Category("智能穿戴"));
        service.save(new Category("电脑办公"));
        service.save(new Category("电视"));
        service.save(new Category("空调"));
        service.save(new Category("洗衣机"));
        service.save(new Category("冰箱"));
        service.save(new Category("厨房大电"));
        service.save(new Category("小家电"));
        service.save(new Category("智能家居"));
        service.save(new Category("出行运动"));
        service.save(new Category("车周边"));
        service.save(new Category("日用百货"));
        service.save(new Category("小米服务"));
        service.save(new Category("儿童用品"));
        service.save(new Category("有品精选"));

        service.save(new Category("Xiaomi 数字旗舰", service.findByName("Xiaomi手机")));
        service.save(new Category("Xiaomi MIX系列", service.findByName("Xiaomi手机")));
        service.save(new Category("Xiaomi Civi", service.findByName("Xiaomi手机")));
        service.save(new Category("Xiaomi手机套装", service.findByName("Xiaomi手机")));

        service.save(new Category("K系列", service.findByName("REDMI手机")));
        service.save(new Category("Note系列", service.findByName("REDMI手机")));
        service.save(new Category("Turbo系列", service.findByName("REDMI手机")));
        service.save(new Category("数字系列", service.findByName("REDMI手机")));

        service.save(new Category("Xiaomi配件", service.findByName("手机配件")));
        service.save(new Category("REDMI手机配件", service.findByName("手机配件")));
        service.save(new Category("创意配件", service.findByName("手机配件")));

        service.save(new Category("Xiaomi平板", service.findByName("平板")));
        service.save(new Category("REDMI平板", service.findByName("平板")));
        service.save(new Category("平板配件", service.findByName("平板")));

        service.save(new Category("智能手环", service.findByName("智能穿戴")));
        service.save(new Category("智能手表", service.findByName("智能穿戴")));
        service.save(new Category("智能耳机", service.findByName("智能穿戴")));
        service.save(new Category("其他穿戴", service.findByName("智能穿戴")));

        service.save(new Category("笔记本", service.findByName("电脑办公")));
        service.save(new Category("显示器", service.findByName("电脑办公")));
        service.save(new Category("办公配件", service.findByName("电脑办公")));

        service.save(new Category("旗舰系列", service.findByName("电视")));
        service.save(new Category("性价比爆款", service.findByName("电视")));
        service.save(new Category("巨幕影院", service.findByName("电视")));
        service.save(new Category("激光投影", service.findByName("电视")));
        service.save(new Category("小米盒子", service.findByName("电视")));
        service.save(new Category("电视周边", service.findByName("电视")));

        service.save(new Category("挂壁空调", service.findByName("空调")));
        service.save(new Category("立式空调", service.findByName("空调")));
        service.save(new Category("中央空调", service.findByName("空调")));
        service.save(new Category("中央空调配件", service.findByName("空调")));
        service.save(new Category("挂机/柜机配件", service.findByName("空调")));

        service.save(new Category("热销推荐", service.findByName("洗衣机")));
        service.save(new Category("主推新品", service.findByName("洗衣机")));
        service.save(new Category("波轮洗衣机", service.findByName("洗衣机")));
        service.save(new Category("洗烘一体机", service.findByName("洗衣机")));
        service.save(new Category("滚筒洗衣机", service.findByName("洗衣机")));
        service.save(new Category("迷你/内衣洗", service.findByName("洗衣机")));
        service.save(new Category("干衣机", service.findByName("洗衣机")));
        service.save(new Category("洗烘套装", service.findByName("洗衣机")));
        service.save(new Category("蓝氧洗衣机", service.findByName("洗衣机")));

        service.save(new Category("热销系列", service.findByName("冰箱")));
        service.save(new Category("容积分类", service.findByName("冰箱")));
        service.save(new Category("门体分类", service.findByName("冰箱")));
        service.save(new Category("冰箱配件", service.findByName("冰箱")));

        service.save(new Category("清洁电器", service.findByName("小家电")));
        service.save(new Category("环境电器", service.findByName("小家电")));
        service.save(new Category("厨房小电", service.findByName("小家电")));
        service.save(new Category("个护电器", service.findByName("小家电")));

        service.save(new Category("小爱音响", service.findByName("智能家居")));
        service.save(new Category("路由器", service.findByName("智能家居")));
        service.save(new Category("智能安防", service.findByName("智能家居")));
        service.save(new Category("智能家装", service.findByName("智能家居")));
        service.save(new Category("智能控制", service.findByName("智能家居")));
        service.save(new Category("智能传灯具", service.findByName("智能家居")));
        service.save(new Category("智能酷玩", service.findByName("智能家居")));

        service.save(new Category("户外出行", service.findByName("出行运动")));
        service.save(new Category("运动健康", service.findByName("出行运动")));
        service.save(new Category("箱包", service.findByName("出行运动")));

        service.save(new Category("通用品", service.findByName("车周边")));
        service.save(new Category("XiaomiLife", service.findByName("车周边")));

        service.save(new Category("家具日用", service.findByName("日用百货")));
        service.save(new Category("个人护理", service.findByName("日用百货")));
        service.save(new Category("防护清洁", service.findByName("日用百货")));
        service.save(new Category("床品家居", service.findByName("日用百货")));
        service.save(new Category("鞋服配饰", service.findByName("日用百货")));

        service.save(new Category("热门推荐", service.findByName("小米服务")));
        service.save(new Category("电池服务", service.findByName("小米服务")));
        service.save(new Category("安装服务", service.findByName("小米服务")));
        service.save(new Category("手机服务", service.findByName("小米服务")));
        service.save(new Category("维修服务", service.findByName("小米服务")));
        service.save(new Category("清洁保养", service.findByName("小米服务")));
        service.save(new Category("勘测服务", service.findByName("小米服务")));
        service.save(new Category("保障服务", service.findByName("小米服务")));
        service.save(new Category("购买无忧", service.findByName("小米服务")));
        service.save(new Category("金融服务", service.findByName("小米服务")));
        service.save(new Category("通信服务", service.findByName("小米服务")));
        service.save(new Category("小米云服务", service.findByName("小米服务")));
        service.save(new Category("其他服务", service.findByName("小米服务")));

        service.save(new Category("热卖好物", service.findByName("有品精选")));
        service.save(new Category("有品爆品", service.findByName("有品精选")));
        service.save(new Category("日常元素", service.findByName("有品精选")));


    }

    private void genGoodsImage() {
        GoodsImageService service = goodsImageService;
        String rootPath = "/images/goods";

        service.save(new GoodsImage(rootPath + "/xiaomi_17t_pro/0.png"));
        service.save(new GoodsImage(rootPath + "/xiaomi_17t_pro/1.jpg"));
        service.save(new GoodsImage(rootPath + "/xiaomi_17t_pro/2.jpg"));
        service.save(new GoodsImage(rootPath + "/xiaomi_17t_pro/3.jpg"));
        service.save(new GoodsImage(rootPath + "/xiaomi_17t_pro/4.jpg"));

        service.save(new GoodsImage(rootPath + "/xiaomi_17t/0.png"));

        service.save(new GoodsImage(rootPath + "/xiaomi_17_max/0.png"));

        service.save(new GoodsImage(rootPath + "/xiaomi_mix_flip_2/0.png"));

        service.save(new GoodsImage(rootPath + "/xiaomi_civi_5_pro/0.png"));

        service.save(new GoodsImage(rootPath + "/xiaomi_civi_4_pro/0.png"));
    }

    private void genGoodsTag() {
        GoodsTagService service = goodsTagService;

        service.save(new GoodsTag("小米上新"));
        service.save(new GoodsTag("换新补贴"));
        service.save(new GoodsTag("小时达"));
        service.save(new GoodsTag("商城赠品"));
    }

    private void genGoods() {
        GoodsService service = goodsService;

        service.save(Goods.builder()
                .name("Xiaomi 17T Pro")
                .price(4299f)
                .discountedPrice(3999f)
                .startingPrice(3999f)
                .category(categoryService.findByName("Xiaomi 数字旗舰"))
                .goodsTag(List.of(
                        goodsTagService.findByName("小米上新"),
                        goodsTagService.findByName("换新补贴")
                ))
                .mainImage(goodsImageService.findByImagePath("/images/goods/xiaomi_17t_pro/0.png"))
                .images(List.of(
                        goodsImageService.findByImagePath("/images/goods/xiaomi_17t_pro/1.jpg"),
                        goodsImageService.findByImagePath("/images/goods/xiaomi_17t_pro/2.jpg"),
                        goodsImageService.findByImagePath("/images/goods/xiaomi_17t_pro/3.jpg"),
                        goodsImageService.findByImagePath("/images/goods/xiaomi_17t_pro/4.jpg")
                ))
                .specifications(List.of(
                        goodsSpecificationService.findByNameAndValue("版本", "12GB+256GB"),
                        goodsSpecificationService.findByNameAndValue("版本", "12GB+512GB"),
                        goodsSpecificationService.findByNameAndValue("版本", "16GB+512GB"),
                        goodsSpecificationService.findByNameAndValue("颜色", "黑色"),
                        goodsSpecificationService.findByNameAndValue("颜色", "午夜蓝"),
                        goodsSpecificationService.findByNameAndValue("颜色", "星云紫")
                ))
                .build()
        );

        service.save(Goods.builder()
                .name("Xiaomi 17T")
                .price(3299f)
                .discountedPrice(2999f)
                .startingPrice(2999f)
                .category(categoryService.findByName("Xiaomi 数字旗舰"))
                .goodsTag(List.of(
                        goodsTagService.findByName("小米上新"),
                        goodsTagService.findByName("换新补贴")
                ))
                .mainImage(goodsImageService.findByImagePath("/images/goods/xiaomi_17t/0.png"))
                .build()
        );

        service.save(Goods.builder()
                .name("Xiaomi 17 Max")
                .price(4799f)
                .startingPrice(4799f)
                .category(categoryService.findByName("Xiaomi 数字旗舰"))
                .goodsTag(List.of(
                        goodsTagService.findByName("小时达"),
                        goodsTagService.findByName("换新补贴")
                ))
                .mainImage(goodsImageService.findByImagePath("/images/goods/xiaomi_17_max/0.png"))
                .build()
        );

        service.save(Goods.builder()
                .name("Xiaomi MIX Flip 2")
                .price(5999f)
                .discountedPrice(5499f)
                .startingPrice(4999f)
                .category(categoryService.findByName("Xiaomi MIX系列"))
                .goodsTag(List.of(
                        goodsTagService.findByName("小时达"),
                        goodsTagService.findByName("换新补贴"),
                        goodsTagService.findByName("商城赠品")
                ))
                .mainImage(goodsImageService.findByImagePath("/images/goods/xiaomi_17t/0.png"))
                .build()
        );

        service.save(Goods.builder()
                .name("Xiaomi Civi 5 Pro")
                .price(2799f)
                .discountedPrice(2499f)
                .startingPrice(2499f)
                .category(categoryService.findByName("Xiaomi Civi"))
                .goodsTag(List.of(
                        goodsTagService.findByName("小时达"),
                        goodsTagService.findByName("换新补贴")
                ))
                .mainImage(goodsImageService.findByImagePath("/images/goods/xiaomi_civi_5_pro/0.png"))
                .build()
        );

        service.save(Goods.builder()
                .name("Xiaomi Civi 4 Pro")
                .price(2799f)
                .discountedPrice(2299f)
                .startingPrice(2099f)
                .category(categoryService.findByName("Xiaomi Civi"))
                .goodsTag(List.of(
                        goodsTagService.findByName("小时达"),
                        goodsTagService.findByName("换新补贴")
                ))
                .mainImage(goodsImageService.findByImagePath("/images/goods/xiaomi_civi_4_pro/0.png"))
                .build()
        );
    }

    private void genUser() {
        UserService service = userService;

        service.register("ZhangSan", "123456");
        service.register("LiSi", "666666");

        service.setNickname("ZhangSan", "法外狂徒");
    }

    private void genGoodsSpecification() {
        GoodsSpecificationService service = goodsSpecificationService;

        Set.of("12GB+256GB", "12GB+512GB", "16GB+512GB").forEach(v -> service.save(
                GoodsSpecification.builder()
                        .name("版本")
                        .value(v)
                        .build()
        ));

        Set.of("黑色", "午夜蓝", "星云紫").forEach(v -> service.save(
                GoodsSpecification.builder()
                        .name("颜色")
                        .value(v)
                        .build()
        ));
    }
}
