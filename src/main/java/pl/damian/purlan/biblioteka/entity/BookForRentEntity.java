package pl.damian.purlan.biblioteka.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "Books for rent")
@Entity
@Data
public class BookForRentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String gatunek;

    private String wydawnictwo;

    private String autor;

    private String ocena;



}

