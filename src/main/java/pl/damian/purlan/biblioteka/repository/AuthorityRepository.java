package pl.damian.purlan.biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.damian.purlan.biblioteka.entity.AuthorityEntity;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Integer> {
    Optional<AuthorityEntity> findByName(String name);

}
