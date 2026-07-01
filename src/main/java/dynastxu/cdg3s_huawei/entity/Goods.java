package dynastxu.cdg3s_huawei.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private Float price;

    private Float discountedPrice;

    private Float startingPrice;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable
    private List<GoodsTag> goodsTag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private GoodsImage mainImage;

    @OneToMany(fetch = FetchType.LAZY)
    private List<GoodsImage> images;

    @ManyToMany
    @JoinTable
    private List<GoodsSpecification> specifications;
}
