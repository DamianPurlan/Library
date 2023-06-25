package pl.damian.purlan.biblioteka.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.damian.purlan.biblioteka.entity.*;
import pl.damian.purlan.biblioteka.model.dto.BasketDTO;
import pl.damian.purlan.biblioteka.model.dto.CartDTO;
import pl.damian.purlan.biblioteka.model.dto.User;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.BasketUpdate;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.CartUpdate;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.WalletValueUpdate;
import pl.damian.purlan.biblioteka.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final User user;
    private final UserRepository userRepository;
    private final BasketRepository basketRepository;
    private final BooksForSellRepository booksForSellRepository;
    private final BooksForRentRepository booksForRentRepository;
    private final CartRepository cartRepository;

    public UserService(User user, UserRepository userRepository, BasketRepository basketRepository, BooksForSellRepository booksForSellRepository, BooksForRentRepository booksForRentRepository, CartRepository cartRepository) {
        this.user = user;
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
        this.booksForSellRepository = booksForSellRepository;
        this.booksForRentRepository = booksForRentRepository;
        this.cartRepository = cartRepository;
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


    public List<BasketDTO> getBasket(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(/*tutaj moze byc nasz wlasny wyjatek */);
        List<BasketDTO> basketContent = basketRepository.findAllByUser(userEntity)
                .stream()
                .map(basketItem -> {
                    BasketDTO basketDTO = new BasketDTO();
                    basketDTO.setBasketItem(basketItem.getBookForSellEntity().getName());
                    return basketDTO;
                })
                .collect(Collectors.toList());
        return basketContent;
    }

    public List<CartDTO> getCart(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow();
        List<CartDTO> cartContent = cartRepository.findAllByUser(userEntity)
                .stream()
                .map(cartItem -> {
                    CartDTO cartDTO = new CartDTO();
                    cartDTO.setCartItem(cartItem.getBookForRentEntity().getName());
                    return cartDTO;
                })
                .collect(Collectors.toList());
        return cartContent;
    }
//
//    public String getBookName(String name, String autor) {
//        Optional<BookForSellEntity> bookOptional = booksForSellRepository.findByNameAndAutor(name, autor);
//        if (bookOptional.isPresent()) {
//            BookForSellEntity book = bookOptional.get();
//            String bookName = book.getName();
//            return bookName;
//        }
//        return "Nie ma takiej ksiązki";
//    }


    public void addBookToBasket(String email, BasketUpdate updateData) {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(); //no bo nie dodamy jak go nie znajdziemy
        BookForSellEntity bookToAdd = booksForSellRepository.findById(updateData.getBookForSellId()).orElseThrow(); //no bo nie dodamy jak jej nie znajdziemy

        BasketEntity newBasketItem = new BasketEntity();
        newBasketItem.setUser(user);
        newBasketItem.setBookForSellEntity(bookToAdd);

        basketRepository.save(newBasketItem);
    }

    public void addBookToCart(String email, CartUpdate cartUpdate) {
        UserEntity user = userRepository.findByEmail(email).orElseThrow();
        BookForRentEntity bookToAdd = booksForRentRepository.findById(cartUpdate.getBookForRentId()).orElseThrow();

        CartEntity newCartItem = new CartEntity();
        newCartItem.setUser(user);
        newCartItem.setBookForRentEntity(bookToAdd);

        cartRepository.save(newCartItem);

    }

}



