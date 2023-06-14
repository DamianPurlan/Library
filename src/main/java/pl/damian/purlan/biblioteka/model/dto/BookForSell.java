package pl.damian.purlan.biblioteka.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class BookForSell {


    private Long id;

    private String name;

    private String gatunek;

    private String wydawnictwo;

    private String autor;

    private String ocena;

    private Integer cena;

    private Integer ammount;

    public BookForSell() {

    }
}
