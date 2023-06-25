package pl.damian.purlan.biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.damian.purlan.biblioteka.entity.BasketEntity;
import pl.damian.purlan.biblioteka.entity.CartEntity;
import pl.damian.purlan.biblioteka.entity.UserEntity;
import pl.damian.purlan.biblioteka.model.dto.CartDTO;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository <CartEntity, CartDTO> {

    List<CartEntity> findAllByUser(UserEntity user);

}
