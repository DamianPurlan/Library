package pl.damian.purlan.biblioteka.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.damian.purlan.biblioteka.entity.UserEntity;
import pl.damian.purlan.biblioteka.model.dto.User;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.WalletValueUpdate;
import pl.damian.purlan.biblioteka.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
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
            selected.add(user);
        }

        return selected;
    }
    @Transactional
    public void updateWalletValue(String name, WalletValueUpdate walletValueUpdate){
        userRepository.findByEmail(name)
                .map(x -> {
                    x.setWallet(walletValueUpdate.getWallet());
                    return x;
                });
    }
}
