package ca.gbc.userservice.controller;


import ca.gbc.userservice.dto.LoginRequest;
import ca.gbc.userservice.dto.SignupRequest;
import ca.gbc.userservice.dto.UserRequest;
import ca.gbc.userservice.dto.UserResponse;
import ca.gbc.userservice.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public SignupRequest signup(@RequestBody SignupRequest signupRequest) {
        return userService.signup(signupRequest);
    }


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginRequest login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }



    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserByEmail(@RequestParam("email") String email) {
        return userService.getUser(email);
    }


    @PutMapping("/{Id}")
    public ResponseEntity<String> updateUser(@PathVariable("Id") String Id, @RequestBody UserRequest userRequest) {
        userService.updateUser(Id, userRequest);

        // Return a response indicating the successful update.
        return ResponseEntity.ok("User information updated successfully");
    }




    @DeleteMapping("/{Id}")
    public ResponseEntity<?> deleteUser(@PathVariable("Id") String Id) {
        userService.deleteUser(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }



}
