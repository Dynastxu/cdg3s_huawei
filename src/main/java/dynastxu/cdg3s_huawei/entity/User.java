package dynastxu.cdg3s_huawei.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer permissionLevel = 0;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(unique = true)
    @Pattern(regexp = "^[A-Za-z0-9_]+$", message = "只允许大小写英文字母、数字及下划线")
    private String username;

    @Size(min = 3, max = 50)
    @Pattern(regexp = "^\\S+(?:.*\\S)?$", message = "首尾不能为空格")
    private String nickname;

    @NotBlank
    private String password;

    @NotNull
    private Boolean enabled = true;

    @NotNull
    private Boolean locked = false;

    private Integer failedAttempt = 0;

    private LocalDateTime lastLoginTime;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public User(
            String username,
            String password
    ) {
        this.username = username;
        this.password = password;
    }
}
