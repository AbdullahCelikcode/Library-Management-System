package Library.LibraryManagement.Controllers;

import Library.LibraryManagement.abstracts.CategoryService;
import Library.LibraryManagement.request.CreateCategoryRequest;
import Library.LibraryManagement.request.UpdateCategoryRequest;
import Library.LibraryManagement.response.GetAllCategoryResponse;
import Library.LibraryManagement.response.GetByIdCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping()
    public List<GetAllCategoryResponse> getAll(){
        return categoryService.findAll();
    }
    @GetMapping("/category/{categoryId}")
    public GetByIdCategoryResponse getByIdCategoryResponse(@PathVariable int categoryId){
        return categoryService.findById(categoryId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(CreateCategoryRequest createCategoryRequest){
        categoryService.add(createCategoryRequest);

    }
    @PutMapping()
    public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest){
        categoryService.update(updateCategoryRequest);
    }

    @DeleteMapping()
    public void delete(int id){
        categoryService.deleteById(id);
    }
}
