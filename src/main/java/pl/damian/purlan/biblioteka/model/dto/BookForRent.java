package pl.damian.purlan.biblioteka.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;


@Data
public class BookForRent {

    private Long id;

    private String name;

    private String gatunek;

    private String wydawnictwo;

    private String autor;

    private String ocena;

    private Integer ammount;
    public BookForRent() {

    }

}
