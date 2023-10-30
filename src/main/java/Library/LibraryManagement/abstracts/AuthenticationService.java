package Library.LibraryManagement.abstracts;

import Library.LibraryManagement.request.CreateUserRequest;
import Library.LibraryManagement.request.UserLoginRequest;
import Library.LibraryManagement.response.LoginResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<String> register(CreateUserRequest createUserRequest);

    LoginResponse login(UserLoginRequest request);
}
