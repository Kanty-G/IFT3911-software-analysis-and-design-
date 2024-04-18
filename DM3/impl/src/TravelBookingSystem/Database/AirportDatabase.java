package TravelBookingSystem.Database;

import TravelBookingSystem.Default.Airport;

import java.util.Enumeration;

public interface AirportDatabase
{
    void AddAirport(Airport airport);
    void SetAirport(Airport airport);
    Airport RemoveAirport(String id);
    Airport GetAirport(String id);
    Enumeration<Airport> GetAllAirports();
}
