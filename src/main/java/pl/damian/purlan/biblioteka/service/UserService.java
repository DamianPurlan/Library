package pl.damian.purlan.biblioteka.service;

import pl.damian.purlan.biblioteka.entity.UserEntity;
import pl.damian.purlan.biblioteka.model.dto.User;
import pl.damian.purlan.biblioteka.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public List<User> getAllUsers() {
        List<UserEntity> allUsers = repository.findAll();
        List<User> selected = new ArrayList<>();
        for (UserEntity userEntity : allUsers) {
            User user = new User();
            user.setEmail(user.getEmail());
            user.setPassword(user.getPassword());
            selected.add(user);
        }

        return selected;
    }
}
