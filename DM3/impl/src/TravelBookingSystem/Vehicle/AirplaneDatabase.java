package TravelBookingSystem.Vehicle;

import java.util.Enumeration;

public interface AirplaneDatabase
{
    void addAirplane(Airplane airplane);
    void setAirplane(Airplane airplane);
    Airplane removeAirplane(String id);
    Airplane getAirplane(String id);
    Enumeration<Airplane> getAllAirplanes();
}
