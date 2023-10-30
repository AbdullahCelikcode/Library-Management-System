package Library.LibraryManagement.concretes;

import Library.LibraryManagement.abstracts.AuthenticationService;
import Library.LibraryManagement.dataAccess.abstracts.UserRepository;
import Library.LibraryManagement.entity.Role;
import Library.LibraryManagement.entity.User;
import Library.LibraryManagement.mappers.ModelMapperService;
import Library.LibraryManagement.request.CreateUserRequest;
import Library.LibraryManagement.request.UserLoginRequest;
import Library.LibraryManagement.response.LoginResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthManager implements AuthenticationService {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public ResponseEntity<String> register(CreateUserRequest createUserRequest) {
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        userRepository.save(user);
        return null;
    }

    @Override
    public LoginResponse login(UserLoginRequest request) {
        System.err.println("deneme");

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        final var user = userRepository.findByEmail(request.getEmail());
        final String token = JwtManager.generateToken(user);

        return new LoginResponse(token);
    }
}
