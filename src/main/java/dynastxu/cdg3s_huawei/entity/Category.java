package dynastxu.cdg3s_huawei.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_category")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Category parent;

    public Category(String name, Category parent) {
        this.name = name;
        this.parent = parent;
    }
}
