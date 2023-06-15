package pl.damian.purlan.biblioteka.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.damian.purlan.biblioteka.entity.UserEntity;
import pl.damian.purlan.biblioteka.repository.AuthorityRepository;
import pl.damian.purlan.biblioteka.repository.UserRepository;

import java.util.Collections;


@Component
public class InitialDataForUsers implements CommandLineRunner {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public InitialDataForUsers(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        createUser("Damian", "admin", 0.0);
        createUser("Natalia", "admin", 0.0);
    }

    public void createUser(String email, String password, Double wallet){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setPassword(passwordEncoder.encode(password));
        userEntity.setWallet(wallet);
        userEntity.setAuthorities(authorityRepository
                .findByName("USER")
                .map(x -> Collections.singletonList(x))
                .orElseThrow()
        );
        userRepository.save(userEntity);
    }
}
