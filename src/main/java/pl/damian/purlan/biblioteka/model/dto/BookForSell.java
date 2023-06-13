package pl.damian.purlan.biblioteka.model.dto;

import lombok.Data;

@Data
public class BookForSell {

    private Long id;

    private String nazwa;

    private String gatunek;

    private String wydawnictwo;

    private String autor;

    private String ocena;

    private String cena;

    private String ammount;

    public BookForSell() {

    }
}
