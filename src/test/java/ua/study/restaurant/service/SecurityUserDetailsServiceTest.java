package ua.study.restaurant.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import ua.study.restaurant.model.ApplicationUser;
import ua.study.restaurant.repository.ApplicationUserRepository;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SecurityUserDetailsServiceTest {
    @Mock
    private ApplicationUserRepository applicationUserRepository;

    @Test
    public void testLoadUserByName() {
        String name = "admin";

        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUserName(name);
        applicationUser.setPassword("-");
        applicationUser.setRole("-");

        when(applicationUserRepository.findByUsername(name)).thenReturn(applicationUser);

        SecurityUserDetailsService service = new SecurityUserDetailsService(applicationUserRepository);
        UserDetails userDetails = service.loadUserByUsername(name);
        verify(applicationUserRepository, times(1)).findByUsername(name);

        Assertions.assertEquals(userDetails.getUsername(), name);
    }
}
