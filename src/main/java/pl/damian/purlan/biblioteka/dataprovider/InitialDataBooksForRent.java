package pl.damian.purlan.biblioteka.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.damian.purlan.biblioteka.entity.BookForRentEntity;
import pl.damian.purlan.biblioteka.repository.BooksForRentRepository;

@Component
public class InitialDataBooksForRent implements CommandLineRunner {

    private BooksForRentRepository repository;

    @Autowired
    public InitialDataBooksForRent(BooksForRentRepository repository){
        this.repository = repository;
    }


    @Override
    public void run(String... args) throws Exception {
        creatBook("Harry Pjoter" , "Biograficzna " , "PWN" , "J.K Rowling" , "4");
        creatBook( "Harry Pjoter - wiezien askabanu" , "Historyczna " , "JWP" , "J.K " , "4.2");
        creatBook( "Harry Pjoter - czary feniksa" , "Biograficzna " , "PWN" , "J Rowling" , "3.8");

    }

    private void creatBook( String name, String gatunek , String wydawnictwo, String autor , String ocena ){
        BookForRentEntity entity = new BookForRentEntity();
        entity.setName(name);
        entity.setGatunek(gatunek);
        entity.setWydawnictwo(wydawnictwo);
        entity.setAutor(autor);
        entity.setOcena(ocena);
        repository.save(entity);
    }

}

