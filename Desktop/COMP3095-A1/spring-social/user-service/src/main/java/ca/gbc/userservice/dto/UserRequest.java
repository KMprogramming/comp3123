package ca.gbc.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String Id;
    private String name;
    private String email;
    private String password;
    // Getters and setters
}

