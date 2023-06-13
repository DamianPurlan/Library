package pl.damian.purlan.biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.damian.purlan.biblioteka.entity.BookForRentEntity;

@Repository
public interface BooksForRentRepository extends JpaRepository<BookForRentEntity, Long> {

}
