package Library.LibraryManagement.Controllers;

import Library.LibraryManagement.abstracts.UserService;
import Library.LibraryManagement.request.CreateUserRequest;
import Library.LibraryManagement.request.UpdateUserRequest;
import Library.LibraryManagement.response.GetAllUserResponse;
import Library.LibraryManagement.response.GetByIdUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public List<GetAllUserResponse> getAll() {
        return userService.getAll();
    }

    @PutMapping()
    public void update(@RequestBody UpdateUserRequest updateUserRequest) {
        userService.update(updateUserRequest);

    }

    @DeleteMapping()
    public void delete(@PathVariable int id) {
        userService.delete(id);

    }
    @GetMapping("/{userId}")
    public GetByIdUserResponse getById(@PathVariable int userId) {
        return userService.getById(userId);

    }

}
