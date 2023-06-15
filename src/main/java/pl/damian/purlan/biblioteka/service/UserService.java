package pl.damian.purlan.biblioteka.service;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pl.damian.purlan.biblioteka.entity.UserEntity;
import pl.damian.purlan.biblioteka.model.dto.User;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.BasketUpdate;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.WalletValueUpdate;
import pl.damian.purlan.biblioteka.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final User user;
    private final UserRepository userRepository;


    public UserService(User user, UserRepository userRepository) {
        this.user = user;
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        List<UserEntity> allUsers = userRepository.findAll();
        List<User> selected = new ArrayList<>();
        for (UserEntity userEntity : allUsers) {
            User user = new User();
            user.setEmail(userEntity.getEmail());
            user.setPassword(userEntity.getPassword());
            user.setWallet(userEntity.getWallet());
            user.setBasket(user.getBasket());
            selected.add(user);
        }

        return selected;
    }

    @Transactional
    public void updateWalletValue(String email, WalletValueUpdate walletValueUpdate) {
        userRepository.findByEmail(email)
                .map(x -> {
                    x.setWallet(walletValueUpdate.getWallet());
                    return x;
                });
    }

    @Transactional
    public void getBasket(String email, BasketUpdate basketUpdate) {
        userRepository.findByEmail(email)
                .map(x -> {
                    x.setBasket(basketUpdate.getBasket());
                    return x;
                });
    }
//        List<UserEntity> allUsers = userRepository.findAll();
//        List<User> select = new ArrayList<>();
//        for (UserEntity userEntity : allUsers) {
//            if (userEntity.equals())
//            user.setBasket(userEntity.getBasket());
//            select.add(user);
//        }
//        return select;



}
