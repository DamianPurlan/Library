package pl.damian.purlan.biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.damian.purlan.biblioteka.entity.BookForRentEntity;
import pl.damian.purlan.biblioteka.entity.BookForSellEntity;

import java.util.Optional;

@Repository
public interface BooksForSellRepository extends JpaRepository<BookForSellEntity, Long > {

//    Optional<BookForSellEntity> findByNameAndAutor(String name, String autor);
//    Iterable<? extends BookForSellEntity> findAllByName(String name);

}
