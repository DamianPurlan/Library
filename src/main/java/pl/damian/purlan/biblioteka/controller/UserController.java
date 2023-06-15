package pl.damian.purlan.biblioteka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.damian.purlan.biblioteka.entity.UserEntity;
import pl.damian.purlan.biblioteka.model.dto.User;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.WalletValueUpdate;
import pl.damian.purlan.biblioteka.repository.AuthorityRepository;
import pl.damian.purlan.biblioteka.repository.UserRepository;
import pl.damian.purlan.biblioteka.service.UserService;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class UserController {


    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository){
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;

    }

    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public void createUser(@RequestBody User newUser){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(newUser.getEmail());
        userEntity.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userEntity.setWallet(newUser.getWallet());
        userEntity.setAuthorities(authorityRepository
                .findByName("USER")
                .map(x -> Collections.singletonList(x))
                .orElseThrow()
        );
        userRepository.save(userEntity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users/info")
    public void displayUserInfoInLogs(Principal principal){
        String name = principal.getName();
        System.out.println(name);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/users/{name}")
    public void updateWalletValue(@PathVariable String name, @RequestBody WalletValueUpdate walletValueUpdate){
        userService.updateWalletValue(name, walletValueUpdate);
    }
}
