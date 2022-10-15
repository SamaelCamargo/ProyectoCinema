package com.example.proyectocinema.Services;
import com.example.proyectocinema.Repository.CategoryRepository;
import com.example.proyectocinema.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> category1 = categoryRepository.getCategory(category.getId());
            if (category1.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }
//RETO4
    public Category update(Category category){
        if (category.getId()!=null){
            Optional<Category>category1=categoryRepository.getCategory(category.getId());
            if (!category1.isEmpty()){
                if (category.getDescription()!=null){
                    category1.get().setDescription(category.getDescription());
                }
                if (category.getName()!=null){
                    category1.get().setName(category.getName());
                }
                return categoryRepository.save(category1.get());
            }
        }
        return category;
    }

    public boolean deleteCategory(int id){
        boolean d = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }

}

