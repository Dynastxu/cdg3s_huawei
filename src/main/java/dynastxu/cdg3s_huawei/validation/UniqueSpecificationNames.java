package dynastxu.cdg3s_huawei.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 检查商品规格名是否重复，即一种规格只能有一个值
 */
@Documented
@Constraint(validatedBy = UniqueSpecificationNamesValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueSpecificationNames {
    String message() default "规格名称不能重复";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
