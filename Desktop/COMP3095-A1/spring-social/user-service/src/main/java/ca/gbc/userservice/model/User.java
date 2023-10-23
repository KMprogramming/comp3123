package ca.gbc.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User
{
    @Id
    private String id;
    private String name;
    private String email;
    private String password;

}
