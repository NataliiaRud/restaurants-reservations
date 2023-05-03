package ua.study.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.study.restaurant.model.Reservation;
import ua.study.restaurant.service.ReservationService;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/reserve")
@RestController
public class ReserveController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Map> postInfo(@RequestBody Map<String, Object> input) {
        String name = (String) input.get("name");
        String phone = (String) input.get("phone");
        int guests = Integer.parseInt((String) input.get("number"));
        String day = (String) input.get("day");
        int restaurantId = Integer.parseInt((String) input.get("restaurant-id"));

        Calendar calendar = Calendar.getInstance();
        if ("tomorrow".equals(day)) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        } else if ("day_after_tomorrow".equals(day)) {
            calendar.add(Calendar.DAY_OF_MONTH, 2);
        }

        Reservation reservation = new Reservation();
        reservation.setGuests(guests);
        reservation.setName(name);
        reservation.setPhone(phone);
        reservation.setRestaurantId(restaurantId);
        reservation.setReservationDate(calendar.getTime());

        reservationService.save(reservation);

        Map response = new HashMap();
        response.put("status", "success");

        return new ResponseEntity<Map>(response, HttpStatus.OK);
    }
}
