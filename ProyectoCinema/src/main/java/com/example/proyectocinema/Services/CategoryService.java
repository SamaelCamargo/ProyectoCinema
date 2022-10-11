package com.example.proyectocinema.Services;
import com.example.proyectocinema.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class CategoryService {
    @Autowired
    private CategoryService cinemaRepository;

    public List<Category> getAll() {
        return cinemaRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return cinemaRepository.getCategory(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return cinemaRepository.save(category);
        } else {
            Optional<Category> category1 = cinemaRepository.getCategory(category.getId());
            if (category1.isEmpty()) {
                return cinemaRepository.save(category);
            } else {
                return category;
            }
        }
    }
}

