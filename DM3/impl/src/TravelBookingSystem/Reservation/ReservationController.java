package TravelBookingSystem.Reservation;

import TravelBookingSystem.Infrastructure.Infrastructure;
import TravelBookingSystem.Travel.Travel;
import TravelBookingSystem.Vehicle.Category;

import java.util.Date;

public class ReservationController
{
    public void reserveSeat(String travelId, Category category, SeatingPreference priority)
    {
        // TODO - implement ReservationController.reserveSeat
        throw new UnsupportedOperationException();
    }

    public Travel[] searchTravel(Infrastructure departure, Infrastructure destination, Date date)
    {
        // TODO - implement ReservationController.searchTravel
        throw new UnsupportedOperationException();
    }

    public void modifyReservation(int reservationNumber)
    {
        // TODO - implement ReservationController.modifyReservation
        throw new UnsupportedOperationException();
    }

    public Void cancelReservation(int reservationNumber)
    {
        // TODO - implement ReservationController.cancelReservation
        throw new UnsupportedOperationException();
    }

    public Reservation checkReservation(int reservationNumber)
    {
        // TODO - implement ReservationController.checkReservation
        throw new UnsupportedOperationException();
    }
}