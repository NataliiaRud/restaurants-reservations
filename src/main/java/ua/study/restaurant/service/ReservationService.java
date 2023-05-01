package ua.study.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.study.restaurant.model.Reservation;
import ua.study.restaurant.repository.ReservationRepository;

/**
 * Reservation service
 */

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
