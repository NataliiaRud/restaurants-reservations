package ua.study.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.study.restaurant.model.Restaurant;
import ua.study.restaurant.service.RestaurantService;

import java.util.Map;

/**
 * Controller that handles restaurants page
 */

@RequestMapping("/restaurant")
@Controller
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public String restaurant(Map<String, Object> model) {
        Iterable<Restaurant> iterable = restaurantService.findAll();

        model.put("restaurants", iterable);

        return "restaurant";
    }
}
