package TravelBookingSystem.Infrastructure;

import java.util.Enumeration;

public interface AirportDatabase
{
    void addAirport(Airport airport);
    Airport replaceAirport(Airport airport);
    Airport removeAirport(String id);
    Airport getAirport(String id);
    Enumeration<Airport> getAllAirports();
}
