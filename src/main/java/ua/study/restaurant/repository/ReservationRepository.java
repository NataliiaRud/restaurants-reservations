package ua.study.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.study.restaurant.model.Reservation;

/**
 * Reservation repository
 */

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
}
