package Library.LibraryManagement.concretes;

import Library.LibraryManagement.abstracts.CategoryService;
import Library.LibraryManagement.dataAccess.abstracts.CategoryRepository;
import Library.LibraryManagement.entity.Category;
import Library.LibraryManagement.mappers.ModelMapperService;
import Library.LibraryManagement.request.CreateCategoryRequest;
import Library.LibraryManagement.request.UpdateCategoryRequest;
import Library.LibraryManagement.response.GetAllCategoryResponse;
import Library.LibraryManagement.response.GetByIdCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(CreateCategoryRequest createCategoryRequest) {
        Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);
        categoryRepository.save(category);
    }

    @Override
    public List<GetAllCategoryResponse> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(book ->
                this.modelMapperService.forResponse().map(book, GetAllCategoryResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetByIdCategoryResponse findById(int id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Book is not found"));
        return this.modelMapperService.forResponse().map(category, GetByIdCategoryResponse.class);
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {
        Category category = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
        this.categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}
