package ca.gbc.userservice.service;

import org.springframework.stereotype.Service;
import ca.gbc.userservice.dto.LoginRequest;
import ca.gbc.userservice.dto.SignupRequest;
import ca.gbc.userservice.dto.UserRequest;
import ca.gbc.userservice.dto.UserResponse;
import ca.gbc.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ca.gbc.userservice.model.User;



import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(UserRequest userRequest) {
        log.info("Creating a new user: {}", userRequest.getName());

        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();

        userRepository.save(user);

        log.info("User {} is created", user.getId());
    }

    @Override
    public SignupRequest signup(SignupRequest signupRequest) {
        log.info("Signing up a new user: {}", signupRequest.getName());

        User user = User.builder()
                .name(signupRequest.getName())
                .email(signupRequest.getEmail())
                .password(signupRequest.getPassword())
                .build();

        userRepository.save(user);

        log.info("User {} is signed up", user.getId());

        return signupRequest; // Return the SignupRequest as a response
    }


    @Override
    public LoginRequest login(LoginRequest loginRequest) {
        log.info("Logging in user with email: {}", loginRequest.getEmail);

        User user = userRepository.findByEmail(loginRequest.getEmail);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Password mismatch");
        }

        return LoginRequest.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    @Override
    public UserResponse getUser(String email) {
        log.info("Getting user with email: {}", email);

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    @Override
    public void deleteUser(String email) {
        log.info("Deleting user with email: {}", email);

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        userRepository.delete(user);
    }

    @Override
    public void updateUser(String email, UserRequest userRequest) {
        log.info("Updating user with email: {}", email);

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());

        userRepository.save(user);

        log.info("User {} is updated", user.getId());
    }


    @Override
    public List<UserResponse> getAllUsers() {
        log.info("Getting a list of all users");

        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user : users) {
            userResponses.add(UserResponse.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .build());
        }

        return userResponses;
    }
}



