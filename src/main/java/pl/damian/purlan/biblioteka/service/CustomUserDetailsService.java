package pl.damian.purlan.biblioteka.service;



import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.damian.purlan.biblioteka.entity.UserEntity;
import pl.damian.purlan.biblioteka.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    public
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
        UserDetails user = User.builder()
                .username(username)
                .password(entity.getPassword())
                .roles(entity.getAuthorities().stream()
                        .map(x -> x.getName())
                        .toArray(String []::new))
                .build();
        return user;
    }
}
