package pl.damian.purlan.biblioteka.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.damian.purlan.biblioteka.model.dto.BookForSell;
import pl.damian.purlan.biblioteka.model.dto.BookForSellUpdateAmmount;
import pl.damian.purlan.biblioteka.model.dto.BookForSellUpdateValue;
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

    @RequestMapping(method = RequestMethod.PUT, path = "booksForSell/{name}/{autor}")
    public void updateBookForSellValue(@PathVariable String name , @PathVariable String autor ,@RequestBody BookForSellUpdateValue bookForSellUpdateValue){
        booksService.updateBookForSellValue(name, autor, bookForSellUpdateValue);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/booksForSell/{name}")
        public void deleteBookForSell(@PathVariable String name){
        booksService.deleteBookForSell(name);
    }

}
