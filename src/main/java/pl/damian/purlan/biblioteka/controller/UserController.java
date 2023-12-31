package pl.damian.purlan.biblioteka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.damian.purlan.biblioteka.entity.UserEntity;
import pl.damian.purlan.biblioteka.model.dto.BasketDTO;
import pl.damian.purlan.biblioteka.model.dto.CartDTO;
import pl.damian.purlan.biblioteka.model.dto.User;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.BasketUpdate;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.CartUpdate;
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
        userEntity.setCart(newUser.getCart());
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

    @RequestMapping(method = RequestMethod.GET, path = "/basket")
    public List<BasketDTO> getBasket(Principal principal) {
        return userService.getBasket(principal.getName());
    }
    @RequestMapping(method = RequestMethod.GET, path = "/cart/{email}")
    public List<CartDTO> getCart(Principal principal){
        return userService.getCart(principal.getName());
    }
    @RequestMapping(method = RequestMethod.GET, path = "/users/info")
    public void displayUserInfoInLogs(Principal principal){
        String name = principal.getName();
        System.out.println(name);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/basket")
    public void addBookToBasket(Principal principal, @RequestBody BasketUpdate basketUpdate){
        userService.addBookToBasket(principal.getName(), basketUpdate);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/cart/{email}")
    public void addBookToCart(Principal principal, @RequestBody CartUpdate cartUpdate){
        userService.addBookToCart(principal.getName(), cartUpdate);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/users/{email}")
    public void updateWalletValue(@PathVariable String email, @RequestBody WalletValueUpdate walletValueUpdate){
        userService.updateWalletValue(email, walletValueUpdate);
    }



}
