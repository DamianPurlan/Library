package pl.damian.purlan.biblioteka.entity;

import jakarta.persistence.*;
import lombok.Data;
import pl.damian.purlan.biblioteka.model.dto.BookForSell;
import pl.damian.purlan.biblioteka.model.dto.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String password;

    private Double wallet;

    private String basket = "";

    private String cart = "";


    @ManyToMany
    private List<AuthorityEntity> authorities;
}
