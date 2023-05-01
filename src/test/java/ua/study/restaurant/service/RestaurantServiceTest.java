package ua.study.restaurant.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.study.restaurant.model.Restaurant;
import ua.study.restaurant.repository.RestaurantRepository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {
    @Mock
    private RestaurantRepository<Restaurant> restaurantRepository;

    @Test
    public void testFindAll() {
        RestaurantService restaurantService = new RestaurantService(restaurantRepository);
        restaurantService.findAll();
        verify(restaurantRepository, times(1)).findAll();
    }

    @Test
    public void getById() {
        int idToTest = 1;

        RestaurantService restaurantService = new RestaurantService(restaurantRepository);
        restaurantService.getById(idToTest);
        verify(restaurantRepository, times(1)).findById(idToTest);
    }

    @Test
    public void testSave() {
        RestaurantService restaurantService = new RestaurantService(restaurantRepository);
        Restaurant restaurant = new Restaurant();
        restaurantService.save(restaurant);
        verify(restaurantRepository, times(1)).save(restaurant);
    }

    @Test
    public void deleteById() {
        int idToTest = 1;

        RestaurantService restaurantService = new RestaurantService(restaurantRepository);
        restaurantService.delete(idToTest);
        verify(restaurantRepository, times(1)).deleteById(idToTest);
    }
}
