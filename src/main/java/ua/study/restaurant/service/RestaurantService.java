package ua.study.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.study.restaurant.model.Restaurant;
import ua.study.restaurant.repository.RestaurantRepository;

import java.util.Optional;

/**
 * Restaurant service
 */

@Service
public class RestaurantService {
    private RestaurantRepository<Restaurant> restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository<Restaurant> restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Iterable<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getById(int id) {
        return restaurantRepository.findById(id);
    }

    public void save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void delete(int id) {
        restaurantRepository.deleteById(id);
    }
}
