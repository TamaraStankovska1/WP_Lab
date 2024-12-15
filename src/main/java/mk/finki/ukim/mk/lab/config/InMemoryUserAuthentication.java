package mk.finki.ukim.mk.lab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class InMemoryUserAuthentication {

    private final PasswordEncoder passwordEncoder;

    public InMemoryUserAuthentication(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // In Memory Authentication
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user3 = User.builder()
                .username("tamsi")
                .password(passwordEncoder.encode("tamsi"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user3, admin);
    }
}