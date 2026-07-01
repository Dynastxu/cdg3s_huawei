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
public class GoodsSpecificationImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    private Goods goods;

    @ManyToMany
    @JoinTable
    @NotNull
    @UniqueSpecificationNames
    private Set<GoodsSpecification> specifications;

    @ManyToOne
    private GoodsImage image;
}
