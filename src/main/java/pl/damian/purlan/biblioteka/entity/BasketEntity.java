package pl.damian.purlan.biblioteka.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BasketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketId;
    @OneToOne
    private UserEntity user;
    @OneToOne
    private BookForSellEntity bookForSellEntity;

}
