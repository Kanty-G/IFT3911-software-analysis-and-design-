package TravelBookingSystem.Database;

import TravelBookingSystem.Default.Flight;

import java.util.Enumeration;

public interface FlightDatabase
{
    void AddFlight(Flight flight);
    void SetFlight(Flight flight);
    Flight RemoveFlight(String id);
    Flight GetFlight(String id);
    Enumeration<Flight> GetAllFlights();
}
