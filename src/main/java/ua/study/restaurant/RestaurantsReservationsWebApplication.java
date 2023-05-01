package ua.study.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import ua.study.restaurant.configuration.ApplicationConfiguration;
import ua.study.restaurant.configuration.WebSecurityConfig;

/**
 * Restaurants main Spring boot application
 */

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@Import({ApplicationConfiguration.class, WebSecurityConfig.class})
public class RestaurantsReservationsWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantsReservationsWebApplication.class, args);
    }
}
