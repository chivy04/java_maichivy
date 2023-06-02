package maichivy.demo.services;

import maichivy.demo.repository.ICategoryRepository;
import maichivy.demo.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category get(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void delete(long id) {
        categoryRepository.deleteById(id);
    }
}
