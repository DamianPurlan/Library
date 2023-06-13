package pl.damian.purlan.biblioteka.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.damian.purlan.biblioteka.model.dto.BookForRent;
import pl.damian.purlan.biblioteka.model.dto.BookForSell;
import pl.damian.purlan.biblioteka.service.BooksforSellService;

import java.util.List;

@RestController
public class BookForSellController {

    private final BooksforSellService booksService;

    @Autowired

    public BookForSellController(BooksforSellService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping( method = RequestMethod.GET, path = "/booksForSell")
    public List<BookForSell> getAllBooksForSell(){
        return booksService.getAllBooksForSell();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/booksForSell")
    public void createBookForRent (@RequestBody @Valid BookForSell newBookForSell){
        booksService.addBookForSell(newBookForSell);
    }
//    @RequestMapping(method = RequestMethod.DELETE, path = "/booksForSell/{name}/{autor}")
//        public void deleteBook(@PathVariable String name, @PathVariable String autor){
//        booksService.sellBook(name,autor);
//    }
//    @RequestMapping(method = RequestMethod.PUT, path = "booksForSell/{name}/{autor}")
//    public


}
