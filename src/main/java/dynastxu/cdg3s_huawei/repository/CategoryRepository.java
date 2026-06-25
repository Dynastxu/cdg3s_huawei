package dynastxu.cdg3s_huawei.repository;

import dynastxu.cdg3s_huawei.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends
        JpaRepository<Category, Long>,
        CrudRepository<Category, Long> {
}
