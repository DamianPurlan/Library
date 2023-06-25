package pl.damian.purlan.biblioteka.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private LocalDate data;

    @OneToOne
    private UserEntity user;

    @OneToOne
    private BookForRentEntity bookForRentEntity;


}
