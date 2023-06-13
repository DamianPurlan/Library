package pl.damian.purlan.biblioteka.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.damian.purlan.biblioteka.entity.UserEntity;
import pl.damian.purlan.biblioteka.repository.UserRepository;


@Component
public class InitialDataForUsers implements CommandLineRunner {
    private final UserRepository userRepository;
    @Autowired
    public InitialDataForUsers(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        createUser("Damian", "admin");
        createUser("Natalia", "admin");
    }

    public void createUser(String email, String password){
        UserEntity entity = new UserEntity();
        entity.setEmail(email);
        entity.setPassword(password);
        userRepository.save(entity);
    }
}
