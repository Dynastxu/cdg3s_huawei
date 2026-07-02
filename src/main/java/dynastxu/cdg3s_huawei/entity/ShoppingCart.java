package dynastxu.cdg3s_huawei.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dynastxu.cdg3s_huawei.validation.UniqueSpecificationNames;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    @NotNull
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn
    @NotNull
    private Goods goods;

    @ManyToMany
    @JoinTable
    @NotNull
    @UniqueSpecificationNames
    private Set<GoodsSpecification> specifications;

    @NotNull
    @Builder.Default
    private Integer quantity = 1;

    /**
     * 数量加一
     *
     * @return 修改后的数量
     */
    public Integer addQuantity() {
        return addQuantity(1);
    }

    /**
     * 增加或减少数量
     *
     * @param num 数量
     * @return 修改后的数量
     */
    public Integer addQuantity(Integer num) {
        quantity += num;
        return quantity;
    }
}
