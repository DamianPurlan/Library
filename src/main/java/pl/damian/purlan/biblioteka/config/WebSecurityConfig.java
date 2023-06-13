package pl.damian.purlan.biblioteka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


//public class WebSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf(csrf -> csrf.disable()); //wylaczamy csrf bo nie korzystamy z frontu, tylko REST-a
//        httpSecurity.formLogin(form -> form.permitAll()); //wlaczamy mozliwosc logowania sie przez formularz
//        httpSecurity.authorizeHttpRequests(
//                (request -> request //kazdy przychodzacy request, sprawdza czy pasuje do patternu (wzorca) url, jesli tak to jest obsluzony przez ta regule, jesli nie idzie do nastepnej
//                        .requestMatchers(HttpMethod.POST, "/users").permitAll() //kazdy moze wywolac zapytanie dla endpointu /users metoda POST
//                        .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN") //moze wywolac uzytkownik, ktory ma role admin
//                        .requestMatchers(HttpMethod.GET, "/users/info").authenticated() //na /users/info moze 'wejsc' tylko zalogowany uzytkownik
//                )
//        );
//        return httpSecurity.build();
//    }
//}
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf(csrf -> csrf.disable());
        httpSecurity.formLogin(form -> form.permitAll());
        httpSecurity.httpBasic();
        httpSecurity.authorizeHttpRequests(
                (request -> request
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/users/info").authenticated())
        );

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

