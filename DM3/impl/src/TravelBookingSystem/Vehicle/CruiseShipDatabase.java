package TravelBookingSystem.Vehicle;

import java.util.Enumeration;

public interface CruiseShipDatabase
{
    void addCruiseShip(CruiseShip cruiseShip);
    void setCruiseShip(CruiseShip cruiseShip);
    CruiseShip removeCruiseShip(String id);
    CruiseShip getCruiseShip(String id);
    Enumeration<CruiseShip> getAllCruiseShips();
}
