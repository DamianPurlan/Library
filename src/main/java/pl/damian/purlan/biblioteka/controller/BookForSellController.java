package pl.damian.purlan.biblioteka.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.damian.purlan.biblioteka.model.dto.BookForSell;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.BookForSellUpdateAmmount;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.BookForSellUpdateValue;
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

    @RequestMapping(method = RequestMethod.GET,  path = "/booksForSell/search/{name}")
    public List<BookForSell> searchBookForSell(@PathVariable String name){
        return  booksService.searchBookForSell(name);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/booksForSell")
    public void createBookForRent (@RequestBody @Valid BookForSell newBookForSell){
        booksService.addBookForSell(newBookForSell);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/booksForSellValue/{name}/{autor}")
    public void updateBookForSellValue(@PathVariable String name ,@PathVariable String autor,@RequestBody BookForSellUpdateValue bookForSellUpdateValue){
        booksService.updateBookForSellValue(name, autor,  bookForSellUpdateValue);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/booksForSellAmmount/{name}/{autor}")
    public void updateBookForSellAmmount(@PathVariable String name ,@PathVariable String autor,@RequestBody BookForSellUpdateAmmount bookForSellUpdateAmmount){
        booksService.updateBookForSellAmmount(name, autor,  bookForSellUpdateAmmount);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/booksForSell/{name}")
        public void deleteBookForSell(@PathVariable String name){
        booksService.deleteBookForSell(name);
    }

}
