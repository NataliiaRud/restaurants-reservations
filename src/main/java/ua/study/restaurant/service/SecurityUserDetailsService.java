package ua.study.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.study.restaurant.model.ApplicationUser;
import ua.study.restaurant.repository.ApplicationUserRepository;

/**
 * Service used by web security to load application users
 */

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    public SecurityUserDetailsService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.withDefaultPasswordEncoder()
                .username(username)
                .password(applicationUser.getPassword())
                .roles(applicationUser.getRole())
                .build();
    }
}
