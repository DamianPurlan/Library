package pl.damian.purlan.biblioteka.model.dto;

import lombok.Data;

import java.util.Collections;

@Data
public class User {

    private String email;
    private String password;
    private Double wallet ;
    private Collections basket;

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
