package pl.damian.purlan.biblioteka.model.dto;

import lombok.Data;

@Data
public class BookForRent {

    private Long id;

    private String nazwa;

    private String gatunek;

    private String wydawnictwo;

    private String autor;

    private String ocena;

    private String ammount;
    public BookForRent() {

    }

}
