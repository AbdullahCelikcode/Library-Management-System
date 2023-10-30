package Library.LibraryManagement.abstracts;

import Library.LibraryManagement.request.CreateUserRequest;
import Library.LibraryManagement.request.UpdateUserRequest;
import Library.LibraryManagement.response.GetAllUserResponse;
import Library.LibraryManagement.response.GetByIdUserResponse;

import java.util.List;

public interface UserService {
    void add(CreateUserRequest createUserRequest);

    public List<GetAllUserResponse> getAll();

    void update(UpdateUserRequest updateUserRequest);

    void delete(int id);

    GetByIdUserResponse getById(int userId);
}
