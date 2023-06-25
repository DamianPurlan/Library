package pl.damian.purlan.biblioteka.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.damian.purlan.biblioteka.entity.BasketEntity;
import pl.damian.purlan.biblioteka.entity.UserEntity;
import pl.damian.purlan.biblioteka.model.dto.BasketDTO;

import java.util.List;

public interface BasketRepository extends JpaRepository<BasketEntity, BasketDTO> {

    List<BasketEntity> findAllByUser(UserEntity user);

}
