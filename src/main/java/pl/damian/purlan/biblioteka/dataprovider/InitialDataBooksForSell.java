package pl.damian.purlan.biblioteka.dataprovider;

import jakarta.persistence.criteria.CriteriaBuilder;
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
        creatBook("Harry Pjoter" , "Biograficzna " , "PWN" , "J.K Rowling" , "4", 100, 0);
        creatBook("Harry Pjoter - wiezien askabanu" , "Historyczna " , "JWP" , "J.K " ,"4.2", 120, 0);
        creatBook("Harry Pjoter - czary feniksa" , "Biograficzna " , "PWN" , "J Rowling" ,"3.8", 80, 0);
        creatBook("Wiedzmin" , "Biograficzna " , "PWN" , "Rowling" , "3.8",80, 0);

    }
    private void creatBook(String name, String gatunek , String wydawnictwo, String autor , String ocena, Integer cena, Integer ammount){
        BookForSellEntity entity = new BookForSellEntity();
        entity.setName(name);
        entity.setGatunek(gatunek);
        entity.setWydawnictwo(wydawnictwo);
        entity.setAutor(autor);
        entity.setOcena(ocena);
        entity.setCena(cena);
        entity.setAmmount(ammount);
        repository.save(entity);
    }
}
