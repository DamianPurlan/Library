package pl.damian.purlan.biblioteka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.damian.purlan.biblioteka.entity.UserEntity;
import pl.damian.purlan.biblioteka.repository.AuthorityRepository;
import pl.damian.purlan.biblioteka.repository.UserRepository;

import java.util.Collections;

@Component
@Order(2)
public class AdminUserInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthorityRepository authorityRepository;

    @Value("${spring.security.user.name}")
    private String adminName;
    @Value("${spring.security.user.password}")
    private String adminPassword;

    @Override
    public void run(String... args) throws Exception {
        UserEntity userEntity = new UserEntity();

        userEntity.setEmail(adminName);
        userEntity.setPassword(passwordEncoder.encode(adminPassword));
        userEntity.setAuthorities(authorityRepository
                .findByName("ADMIN")
                .map(x -> Collections.singletonList(x))
                .orElseThrow()
        );
        userRepository.save(userEntity);
    }
}
