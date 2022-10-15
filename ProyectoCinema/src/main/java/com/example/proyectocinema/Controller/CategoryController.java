package com.example.proyectocinema.Controller;
import com.example.proyectocinema.Services.CategoryService;
import com.example.proyectocinema.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE
})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    @PostMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Category> getAllUserAdmin() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id")int id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save (@RequestBody Category category){
        return categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategoy(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return true;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category updateCategory(@RequestBody Category categoryModel) {
        return categoryService.update(categoryModel);
    }
}
