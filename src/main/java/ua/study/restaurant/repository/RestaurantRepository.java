package ua.study.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.study.restaurant.model.Restaurant;

/**
 * Restaurant repository
 */

@Repository
public interface RestaurantRepository<P> extends CrudRepository<Restaurant, Integer> {
}
