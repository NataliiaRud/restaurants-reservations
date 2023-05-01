package ua.study.restaurant.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.study.restaurant.model.Restaurant;
import ua.study.restaurant.service.RestaurantService;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

/**
 * Controller that handles restaurant editing and deletion
 */

@RequestMapping("/admin/restaurant-edit")
@Controller
public class AdminEditRestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public String restaurant(@PathParam(value = "id") int id, HttpServletRequest request, Map<String, Object> model) {
        if ("delete".equals(request.getParameter("action"))) {
            restaurantService.delete(id);

            Iterable<Restaurant> iterable = restaurantService.findAll();

            model.put("restaurants", iterable);

            return "restaurants";
        }

        Optional<Restaurant> optional = restaurantService.getById(id);

        model.put("restaurant", optional.isPresent() ? optional.get() : new Restaurant());

        return "restaurant-edit";
    }

    @PostMapping
    public String saveRestaurant(HttpServletRequest request, HttpServletResponse response,
                                 Map<String, Object> model) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        Optional<Restaurant> optional = restaurantService.getById(id);

        Restaurant restaurant = optional.isPresent() ? optional.get() : new Restaurant();
        restaurant.setName(name);
        restaurant.setAddress(address);

        restaurantService.save(restaurant);

        Iterable<Restaurant> iterable = restaurantService.findAll();
        model.put("restaurants", iterable);

        return "restaurants";
    }
}
