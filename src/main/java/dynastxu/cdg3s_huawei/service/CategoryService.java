package dynastxu.cdg3s_huawei.service;

import dynastxu.cdg3s_huawei.entity.Category;
import dynastxu.cdg3s_huawei.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
