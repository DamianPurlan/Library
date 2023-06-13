package pl.damian.purlan.biblioteka.service;

import org.springframework.stereotype.Service;
import pl.damian.purlan.biblioteka.entity.BookForRentEntity;
import pl.damian.purlan.biblioteka.model.dto.BookForRent;
import pl.damian.purlan.biblioteka.model.dto.BookForSell;
import pl.damian.purlan.biblioteka.repository.BooksForRentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksForRentService {
    private final BooksForRentRepository booksForRentRepository;

    public BooksForRentService(BooksForRentRepository booksForRentRepository) {
        this.booksForRentRepository = booksForRentRepository;
    }

    public List<BookForRent> getAllBooksForRent(){
        List<BookForRentEntity> allBooksForRent = booksForRentRepository.findAll();
        List<BookForRent> selected = new ArrayList<>();
        for (BookForRentEntity bookForRentEntity : allBooksForRent){
            BookForRent bookForRent = new BookForRent();
            bookForRent.setNazwa(bookForRentEntity.getNazwa());
            bookForRent.setGatunek(bookForRentEntity.getGatunek());
            bookForRent.setWydawnictwo(bookForRentEntity.getWydawnictwo());
            bookForRent.setAutor(bookForRentEntity.getAutor());
            bookForRent.setOcena(bookForRentEntity.getOcena());
            selected.add(bookForRent);
        }
        return selected;
    }


    public BookForRentEntity addBookForRent(BookForRent newBookForRent){
        BookForRentEntity entity = new BookForRentEntity();
        entity.setNazwa(newBookForRent.getNazwa());
        entity.setGatunek(newBookForRent.getGatunek());
        entity.setWydawnictwo(newBookForRent.getWydawnictwo());
        entity.setAutor(newBookForRent.getAutor());
        entity.setOcena(newBookForRent.getOcena());
        return booksForRentRepository.save(entity);
    }


    public void takenBook(){

    }
}

