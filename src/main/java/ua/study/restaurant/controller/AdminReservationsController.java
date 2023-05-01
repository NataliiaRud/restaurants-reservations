package ua.study.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.study.restaurant.model.Reservation;
import ua.study.restaurant.model.Restaurant;
import ua.study.restaurant.service.ReservationService;
import ua.study.restaurant.service.RestaurantService;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller that handles displaying list of reservations (admin application)
 */

@RequestMapping("/admin/reservations")
@Controller
public class AdminReservationsController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public String restaurant(Map<String, Object> model) {
        Iterable<Restaurant> restaurantsIterable = restaurantService.findAll();
        Map<Integer, String> restaurantsMap = new HashMap<>();
        for (Restaurant restaurant : restaurantsIterable) {
            restaurantsMap.put(restaurant.getId(), restaurant.getName());
        }

        Iterable<Reservation> iterable = reservationService.findAll();

        model.put("reservations", iterable);
        model.put("restaurantsMap", restaurantsMap);

        return "reservations";
    }
}
