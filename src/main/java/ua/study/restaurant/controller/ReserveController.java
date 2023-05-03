package ua.study.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.study.restaurant.service.ReservationService;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/reserve")
@RestController
public class ReserveController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Map> postInfo(@RequestBody String input) {
        System.out.println("Input data: " + input);

        Map response = new HashMap();
        response.put("message", "input received");

        return new ResponseEntity<Map>(response, HttpStatus.OK);
    }
}
