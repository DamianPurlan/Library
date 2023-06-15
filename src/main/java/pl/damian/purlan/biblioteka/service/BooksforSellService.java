package pl.damian.purlan.biblioteka.service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.damian.purlan.biblioteka.entity.BookForSellEntity;
import pl.damian.purlan.biblioteka.model.dto.BookForSell;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.BookForSellUpdateAmmount;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.BookForSellUpdateValue;
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
            bookForSell.setId(bookForSellEntity.getId());
            bookForSell.setName(bookForSellEntity.getName());
            bookForSell.setGatunek(bookForSellEntity.getGatunek());
            bookForSell.setWydawnictwo(bookForSellEntity.getWydawnictwo());
            bookForSell.setAutor(bookForSellEntity.getAutor());
            bookForSell.setOcena(bookForSellEntity.getOcena());
            bookForSell.setCena(bookForSellEntity.getCena());
            bookForSell.setAmmount(bookForSellEntity.getAmmount());
            selected.add(bookForSell);
        }
        return selected;
    }


    public BookForSellEntity addBookForSell(@Valid BookForSell newBookForSell) {
        BookForSellEntity entity = new BookForSellEntity();
        entity.setName(newBookForSell.getName());
        entity.setGatunek(newBookForSell.getGatunek());
        entity.setWydawnictwo(newBookForSell.getWydawnictwo());
        entity.setAutor(newBookForSell.getAutor());
        entity.setCena(newBookForSell.getCena());
        entity.setOcena(newBookForSell.getOcena());
        return booksForSellRepository.save(entity);
    }

    @Transactional
    public void updateBookForSellValue(String name, String autor, BookForSellUpdateValue bookForSellUpdateValue) {
        booksForSellRepository.findByNameAndAutor(name, autor)
                .map(x -> {
                    x.setCena(bookForSellUpdateValue.getCena());
                    return x;
                });

    }

    @Transactional
    public void updateBookForSellAmmount(String name, String autor,  BookForSellUpdateAmmount bookForSellUpdateAmmount){
        booksForSellRepository.findByNameAndAutor(name, autor)
                .map(x -> {
                    x.setAmmount(bookForSellUpdateAmmount.getAmmount());
                    return x;
                });
    }

    public void deleteBookForSell(String name){
        booksForSellRepository.deleteAll(booksForSellRepository.findAllByName(name));
    }

    public List<BookForSell> searchBookForSell(String name){
        List<BookForSellEntity> all = (List<BookForSellEntity>) booksForSellRepository.findAllByName(name);
        List<BookForSell> selected = new ArrayList<>();
        for (BookForSellEntity bookForSellEntity : all){
            BookForSell bookForSell = new BookForSell();
            bookForSell.setId(bookForSellEntity.getId());
            bookForSell.setName(bookForSellEntity.getName());
            bookForSell.setGatunek(bookForSellEntity.getGatunek());
            bookForSell.setWydawnictwo(bookForSellEntity.getWydawnictwo());
            bookForSell.setAutor(bookForSellEntity.getAutor());
            bookForSell.setOcena(bookForSellEntity.getOcena());
            bookForSell.setCena(bookForSellEntity.getCena());
            bookForSell.setAmmount(bookForSellEntity.getAmmount());
            selected.add(bookForSell);
        }
        return selected;
    }




}




