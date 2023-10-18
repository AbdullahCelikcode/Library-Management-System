package Library.LibraryManagement.Controllers;

import Library.LibraryManagement.abstracts.CategoryService;
import Library.LibraryManagement.request.CreateCategoryRequest;
import Library.LibraryManagement.request.UpdateCategoryRequest;
import Library.LibraryManagement.response.GetAllCategoryResponse;
import Library.LibraryManagement.response.GetByIdCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/categorys/all")
    public List<GetAllCategoryResponse> getAll(){
        return categoryService.findAll();
    }
    @GetMapping("/categorys/{categoryId}")
    public GetByIdCategoryResponse getByIdCategoryResponse(@PathVariable int categoryId){
        return categoryService.findById(categoryId);
    }

    @PostMapping("/categorys/add")
    public void add(CreateCategoryRequest createCategoryRequest){
        categoryService.add(createCategoryRequest);

    }
    @PutMapping("/categorys/update")
    public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest){
        categoryService.update(updateCategoryRequest);
    }

    @DeleteMapping("/categorys/delete")
    public void delete(int id){
        categoryService.deleteById(id);
    }
}
