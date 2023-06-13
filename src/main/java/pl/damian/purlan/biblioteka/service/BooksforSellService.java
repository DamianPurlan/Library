package pl.damian.purlan.biblioteka.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.damian.purlan.biblioteka.entity.BookForSellEntity;
import pl.damian.purlan.biblioteka.model.dto.BookForSell;
import pl.damian.purlan.biblioteka.model.dto.BookForSellUpdate;
import pl.damian.purlan.biblioteka.repository.BooksForRentRepository;
import pl.damian.purlan.biblioteka.repository.BooksForSellRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksforSellService {


    private final BooksForSellRepository booksForSellRepository;


    @Autowired
    public BooksforSellService(BooksForRentRepository booksForRentRepository, BooksForSellRepository booksForSellRepository) {
        this.booksForSellRepository = booksForSellRepository;
    }


    public List<BookForSell> getAllBooksForSell() {
        List<BookForSellEntity> allBooksForSell = booksForSellRepository.findAll();
        List<BookForSell> selected = new ArrayList<>();
        for (BookForSellEntity bookForSellEntity : allBooksForSell) {
            BookForSell bookForSell = new BookForSell();
            bookForSell.setNazwa(bookForSellEntity.getNazwa());
            bookForSell.setGatunek(bookForSellEntity.getGatunek());
            bookForSell.setWydawnictwo(bookForSellEntity.getWydawnictwo());
            bookForSell.setAutor(bookForSellEntity.getAutor());
            bookForSell.setOcena(bookForSellEntity.getOcena());
            bookForSell.setCena(bookForSellEntity.getCena());
            selected.add(bookForSell);
        }
        return selected;
    }


    public BookForSellEntity addBookForSell(@Valid BookForSell newBookForSell) {
        BookForSellEntity entity = new BookForSellEntity();
        entity.setNazwa(newBookForSell.getNazwa());
        entity.setGatunek(newBookForSell.getGatunek());
        entity.setWydawnictwo(newBookForSell.getWydawnictwo());
        entity.setAutor(newBookForSell.getAutor());
        entity.setOcena(newBookForSell.getOcena());
        return booksForSellRepository.save(entity);
    }

//    public void sellBook(String name, String autor) {
//        booksForSellRepository.findByNameAndAutor(name, autor)
//                .ifPresent(booksForSellRepository::delete);
//    }

//    public void updateBook(String nazwa, String gatunek, String wydawnictwo, String autor, String ocena, String cena, BookForSellUpdate bookForSellUpdate) {
//        booksForSellRepository.findByNameAndAutor(nazwa, autor)
//                .stream().allMatch()
//
//
//    }

}




