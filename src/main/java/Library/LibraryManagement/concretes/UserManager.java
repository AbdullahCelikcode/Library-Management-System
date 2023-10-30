package Library.LibraryManagement.concretes;

import Library.LibraryManagement.abstracts.UserService;
import Library.LibraryManagement.dataAccess.abstracts.UserRepository;
import Library.LibraryManagement.entity.User;
import Library.LibraryManagement.mappers.ModelMapperService;
import Library.LibraryManagement.request.CreateUserRequest;
import Library.LibraryManagement.request.UpdateUserRequest;
import Library.LibraryManagement.response.GetAllUserResponse;
import Library.LibraryManagement.response.GetByIdUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(CreateUserRequest createUserRequest) {
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);

        userRepository.save(user);
    }

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> this.modelMapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());

    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public GetByIdUserResponse getById(int userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User is not found"));
        return this.modelMapperService.forResponse().map(user, GetByIdUserResponse.class);
    }


}




