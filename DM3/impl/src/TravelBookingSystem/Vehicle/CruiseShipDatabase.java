package TravelBookingSystem.Vehicle;

import java.util.Enumeration;

public interface CruiseShipDatabase
{
    void AddCruiseShip(CruiseShip cruiseShip);
    void SetCruiseShip(CruiseShip cruiseShip);
    CruiseShip RemoveCruiseShip(String id);
    CruiseShip GetCruiseShip(String id);
    Enumeration<CruiseShip> GetAllCruiseShips();
}
