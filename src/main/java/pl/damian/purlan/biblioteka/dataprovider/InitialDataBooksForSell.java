package pl.damian.purlan.biblioteka.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.damian.purlan.biblioteka.entity.BookForSellEntity;
import pl.damian.purlan.biblioteka.repository.BooksForSellRepository;

@Component
public class InitialDataBooksForSell implements CommandLineRunner {

    private BooksForSellRepository repository;

    @Autowired
    public InitialDataBooksForSell(BooksForSellRepository repository){
        this.repository = repository;
    }


    @Override
    public void run(String... args) throws Exception {
        creatBook("Harry Pjoter" , "Biograficzna " , "PWN" , "J.K Rowling" , "4", " 100");
        creatBook("Harry Pjoter - wiezien askabanu" , "Historyczna " , "JWP" , "J.K " , "4.2", "120");
        creatBook("Harry Pjoter - czary feniksa" , "Biograficzna " , "PWN" , "J Rowling" , "3.8", "80");

    }
    private void creatBook(String nazwa, String gatunek , String wydawnictwo, String autor , String ocena, String cena ){
        BookForSellEntity entity = new BookForSellEntity();
        entity.setNazwa(nazwa);
        entity.setGatunek(gatunek);
        entity.setWydawnictwo(wydawnictwo);
        entity.setAutor(autor);
        entity.setOcena(ocena);
        entity.setCena(cena);
        repository.save(entity);
    }
}
