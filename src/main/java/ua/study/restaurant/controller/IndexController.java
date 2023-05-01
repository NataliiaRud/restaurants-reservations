package ua.study.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.study.restaurant.model.Restaurant;
import ua.study.restaurant.service.RestaurantService;

import java.util.Map;

/**
 * Index page controller
 */

@RequestMapping("/")
@Controller
public class IndexController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public String index(Map<String, Object> model) {
        Iterable<Restaurant> iterable = restaurantService.findAll();

        model.put("restaurants", iterable);

        return "index";
    }
}
