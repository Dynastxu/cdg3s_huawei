package dynastxu.cdg3s_huawei.validation;

import dynastxu.cdg3s_huawei.entity.GoodsSpecification;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

public class UniqueSpecificationNamesValidator implements ConstraintValidator<UniqueSpecificationNames, Set<GoodsSpecification>> {

    @Override
    public boolean isValid(Set<GoodsSpecification> specifications, ConstraintValidatorContext context) {
        if (specifications == null || specifications.isEmpty()) {
            return true;
        }

        Set<String> names = new HashSet<>();
        for (GoodsSpecification spec : specifications) {
            if (spec.getName() != null && !names.add(spec.getName())) {
                return false;
            }
        }
        return true;
    }
}
