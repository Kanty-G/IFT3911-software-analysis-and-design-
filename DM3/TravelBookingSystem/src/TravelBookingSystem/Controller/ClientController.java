package TravelBookingSystem.Controller;

import TravelBookingSystem.Payment.PaymentService;
import TravelBookingSystem.Reservation.ReservationService;
import TravelBookingSystem.Travel.TravelDatabase;

public class ClientController
{
    private final PaymentService paymentService;
    private final ReservationService reservationService;
    private final TravelDatabase travelDatabase;

    public ClientController(PaymentService paymentService, ReservationService reservationService, TravelDatabase travelDatabase)
    {
        this.paymentService = paymentService;
        this.reservationService = reservationService;
        this.travelDatabase = travelDatabase;
    }

    public void makePayment()
    {
        paymentService.makePayment();
    }

    public void checkFlights()
    {
        // TODO
    }

    public void checkCruises()
    {
        // TODO
    }

    public void checkTrainRoutes()
    {
        // TODO
    }

    public void reserveFlight()
    {
        reservationService.reserveFlight();
    }

    public void reserveCruise()
    {
        reservationService.reserveCruise();
    }

    public void reserveTrainRoute()
    {
        reservationService.reserveTrainRoute();
    }
}