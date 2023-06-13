package pl.damian.purlan.biblioteka.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "Books for sell")
@Entity
@Data
public class BookForSellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;

    private String gatunek;

    private String wydawnictwo;

    private String autor;

    private String ocena;

    private String cena;

    public BookForSellEntity(){

    }
}
