package pl.damian.purlan.biblioteka.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "Books for sell")
@Entity
@Data
public class BookForSellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String gatunek;

    private String wydawnictwo;

    private String autor;

    private String ocena;

    private Integer cena;

    private Integer ammount;



}
