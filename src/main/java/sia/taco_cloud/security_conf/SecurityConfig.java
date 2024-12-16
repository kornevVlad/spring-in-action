package sia.taco_cloud.security_conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import sia.taco_cloud.dao.UserRepository;
import sia.taco_cloud.model.User;


@Configuration
public class SecurityConfig {

    /**
     * Кодер входящего пароля
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Проверка имени пользователя в БД
     */
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null) {
                return user;
            }
            throw new UsernameNotFoundException(
                    "User '" + username + "' not found");
        };
    }

    /**
     * Фильтр доступа http запросов по роли
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/design", "/orders").hasRole("USER")  // Указываем маршруты с ограничением
                        .anyRequest().permitAll()  // Разрешаем все остальные запросы
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Указываем страницу логина
                        .permitAll()          // Разрешаем доступ к странице логина
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")  // Используем OAuth2 авторизацию, если необходимо
                )
                
                .build();
    }

}