package pl.damian.purlan.biblioteka.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.damian.purlan.biblioteka.model.dto.BookForRent;
import pl.damian.purlan.biblioteka.service.BooksForRentService;

import java.util.List;

@RestController
public class BookForRentController {
    private final BooksForRentService booksService;

    @Autowired
    public BookForRentController(BooksForRentService booksService) {
        this.booksService = booksService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/booksForRent")
    public List<BookForRent> getAllBooksForRent() {
        return booksService.getAllBooksForRent();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/booksForRent")
    public void createBookForRent (@RequestBody @Valid BookForRent newBookForRent){
        booksService.addBookForRent(newBookForRent);
    }



}


