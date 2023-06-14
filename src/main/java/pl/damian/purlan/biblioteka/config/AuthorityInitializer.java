package pl.damian.purlan.biblioteka.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import pl.damian.purlan.biblioteka.entity.AuthorityEntity;
import pl.damian.purlan.biblioteka.repository.AuthorityRepository;

@Service
@RequiredArgsConstructor
@Order(1)
public class AuthorityInitializer implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;

    @Override
    public void run(String... args) throws Exception {
        createAndSaveAuthority("ADMIN");
        createAndSaveAuthority("USER");
        createAndSaveAuthority("WORKER");
    }

    private void createAndSaveAuthority(String authorityName){
        AuthorityEntity authorityEntity = new AuthorityEntity();

        authorityEntity.setName(authorityName);

        authorityRepository.save(authorityEntity);
    }
}
