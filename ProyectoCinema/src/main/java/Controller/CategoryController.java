package Controller;

import Services.CategoryService;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/All"){
    public List<Category> getAll();
    }

    @GetMapping("/{Id}")
    public Optional <Category> getCategory(@PathVariable("id")int id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save (@RequestBody Category category){
        return categoryService.save(category);
    }
}

