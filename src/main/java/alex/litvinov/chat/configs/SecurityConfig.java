package alex.litvinov.chat.configs;

import alex.litvinov.chat.domain.User;
import alex.litvinov.chat.repositories.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeRequests()
                .antMatchers("/main","/chat").hasRole("USER")
                .antMatchers("/login", "/register","/register**","/chat").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .and()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepo userRepo){

        return login -> {
            User user = userRepo.findByLogin(login);
            if(user != null) return user;
            throw new UsernameNotFoundException(login);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
