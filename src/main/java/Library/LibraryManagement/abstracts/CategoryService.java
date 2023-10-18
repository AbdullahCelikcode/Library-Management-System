package Library.LibraryManagement.abstracts;

import Library.LibraryManagement.request.CreateCategoryRequest;
import Library.LibraryManagement.request.UpdateCategoryRequest;
import Library.LibraryManagement.response.GetAllCategoryResponse;
import Library.LibraryManagement.response.GetByIdCategoryResponse;

import java.util.List;

public interface CategoryService {
    public void add(CreateCategoryRequest createCategoryRequest);

    List<GetAllCategoryResponse> findAll();

    GetByIdCategoryResponse findById(int id);

    void update(UpdateCategoryRequest updateCategoryRequest);
    void deleteById(int id);
}
