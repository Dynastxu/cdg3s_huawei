package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.Category;
import dynastxu.cdg3s_huawei.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends BaseService<CategoryRepository, Category> {

    CategoryService(CategoryRepository repository) {
        super(repository);
    }

    public Category findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public List<Category> listChild(Category category) {
        return repository.findAllByParent(category);
    }

    public List<Category> listRoots() {
        return repository.findAllByParentIsNull();
    }
}
