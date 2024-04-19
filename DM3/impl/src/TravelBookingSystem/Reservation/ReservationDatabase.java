package TravelBookingSystem.Reservation;

import java.util.Enumeration;

public interface ReservationDatabase
{
    void addReservation(Reservation reservation);
    Reservation replaceReservation(Reservation reservation);
    Reservation removeReservation(String reservationNumber);
    Reservation getReservation(String reservationNumber);
    Enumeration<Reservation> getAllReservations();
}
