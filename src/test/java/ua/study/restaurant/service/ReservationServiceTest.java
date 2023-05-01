package ua.study.restaurant.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.study.restaurant.model.Reservation;
import ua.study.restaurant.repository.ReservationRepository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {
    @Mock
    private ReservationRepository reservationRepository;

    @Test
    public void testFindAll() {
        ReservationService reservationService = new ReservationService(reservationRepository);
        reservationService.findAll();
        verify(reservationRepository, times(1)).findAll();
    }

    @Test
    public void testSave() {
        ReservationService reservationService = new ReservationService(reservationRepository);
        Reservation reservation = new Reservation();
        reservationService.save(reservation);
        verify(reservationRepository, times(1)).save(reservation);
    }
}
