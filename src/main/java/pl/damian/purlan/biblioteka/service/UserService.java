package pl.damian.purlan.biblioteka.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.damian.purlan.biblioteka.entity.BookForSellEntity;
import pl.damian.purlan.biblioteka.entity.UserEntity;
import pl.damian.purlan.biblioteka.model.dto.BasketDTO;
import pl.damian.purlan.biblioteka.model.dto.BookForSell;
import pl.damian.purlan.biblioteka.model.dto.User;
import pl.damian.purlan.biblioteka.model.dto.updatevalues.WalletValueUpdate;
import pl.damian.purlan.biblioteka.repository.BooksForSellRepository;
import pl.damian.purlan.biblioteka.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final User user;
    private final UserRepository userRepository;

    private final BooksForSellRepository booksForSellRepository;

    public UserService(User user, UserRepository userRepository, BooksForSellRepository booksForSellRepository) {
        this.user = user;
        this.userRepository = userRepository;
        this.booksForSellRepository = booksForSellRepository;
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
        List<UserEntity> userEntities = userRepository.findByEmail(email)
                .map(Collections::singletonList)
                .orElse(Collections.emptyList());
        List<BasketDTO> select = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            BasketDTO basketDTO = new BasketDTO();
            basketDTO.setBasket(userEntity.getBasket());
            select.add(basketDTO);
        }
        return select;
    }

    public String getBookName(String name, String autor) {
        Optional<BookForSellEntity> bookOptional = booksForSellRepository.findByNameAndAutor(name, autor);
        if (bookOptional.isPresent()) {
            BookForSellEntity book = bookOptional.get();
            String bookName = book.getName();
            return bookName;
        }
        return "Nie ma takiej ksiązki";
    }

    public String addBookToBasket(String email, String name) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);
        String cart = "";
        if (userEntityOptional.isPresent()) {
            List<BookForSell> bookForSells = new ArrayList<>();
            for (BookForSell book : bookForSells) {
                if (name.equals(book)) {
                    String bookName = book.getName();
                    cart += bookName + " ";
                }
            }
        }
        return cart;
    }
}



