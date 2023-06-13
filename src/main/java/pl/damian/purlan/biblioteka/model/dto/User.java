package pl.damian.purlan.biblioteka.model.dto;

import lombok.Data;

@Data
public class User {
    private String email;
    private String password;

    public User() {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
