package Library.LibraryManagement.Controllers;

import Library.LibraryManagement.abstracts.AuthenticationService;
import Library.LibraryManagement.request.CreateUserRequest;
import Library.LibraryManagement.request.UserLoginRequest;
import Library.LibraryManagement.response.LoginResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CreateUserRequest createUserRequest){
        return authenticationService.register(createUserRequest);
    }

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody UserLoginRequest request) {

        return ResponseEntity.ok(authenticationService.login(request));
    }


}
