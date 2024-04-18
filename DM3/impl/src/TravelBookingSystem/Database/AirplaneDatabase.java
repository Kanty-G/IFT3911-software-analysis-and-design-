package TravelBookingSystem.Database;

import TravelBookingSystem.Default.Airplane;

import java.util.Enumeration;

public interface AirplaneDatabase
{
    void AddAirplane(Airplane airplane);
    void SetAirplane(Airplane airplane);
    Airplane RemoveAirplane(String id);
    Airplane GetAirplane(String id);
    Enumeration<Airplane> GetAllAirplanes();
}
