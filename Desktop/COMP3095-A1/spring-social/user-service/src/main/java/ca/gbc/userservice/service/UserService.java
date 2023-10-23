package ca.gbc.userservice.service;
import ca.gbc.userservice.dto.LoginRequest;
import ca.gbc.userservice.dto.SignupRequest;
import ca.gbc.userservice.dto.UserRequest;
import ca.gbc.userservice.dto.UserResponse;
import java.util.List;


public interface UserService {


    SignupRequest signup(SignupRequest signupRequest);

    LoginRequest login(LoginRequest loginRequest);

    UserResponse getUser(String email);

    void deleteUser(String email);

    void updateUser(String email, UserRequest userRequest);

    List<UserResponse> getAllUsers();

    void createUser(UserRequest userRequest);

}
