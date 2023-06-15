package pl.damian.purlan.biblioteka.model.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Data
@Service
public class User {

    private String email;
    private String password;
    private Double wallet ;
    private String basket;

    public User() {
        this.email = email;
        this.password = password;
        this.wallet = wallet;
        this.basket = basket;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
