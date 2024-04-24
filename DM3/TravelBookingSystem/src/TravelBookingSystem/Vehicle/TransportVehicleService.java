package TravelBookingSystem.Vehicle;

import java.util.Enumeration;

public class TransportVehicleService
{
    private TransportVehicleDatabase transportVehicleDatabase;

    public TransportVehicleService(TransportVehicleDatabase transportVehicleDatabase)
    {
        this.transportVehicleDatabase = transportVehicleDatabase;
    }

    public void addAirplane(Airplane airplane)
    {
        transportVehicleDatabase.addAirplane(airplane);
    }

    public void deleteAirplane(String id)
    {
        transportVehicleDatabase.removeAirplane(id);
    }

    public Airplane getAirplane(String id)
    {
        return transportVehicleDatabase.getAirplane(id);
    }

    public Enumeration<Airplane> getAirplanes()
    {
        return transportVehicleDatabase.getAllAirplanes();
    }

    public void addCruiseShip(CruiseShip cruiseShip)
    {
        transportVehicleDatabase.addCruiseShip(cruiseShip);
    }

    public void deleteCruiseShip(String id)
    {
        transportVehicleDatabase.removeCruiseShip(id);
    }

    public CruiseShip getCruiseShip(String id)
    {
        return transportVehicleDatabase.getCruiseShip(id);
    }

    public Enumeration<CruiseShip> getAllCruiseShips()
    {
        return transportVehicleDatabase.getAllCruiseShips();
    }

    public void addTrain(Train train)
    {
        transportVehicleDatabase.addTrain(train);
    }

    public void deleteTrain(String id)
    {
        transportVehicleDatabase.removeTrain(id);
    }

    public Train getTrain(String id)
    {
        return transportVehicleDatabase.getTrain(id);
    }

    public Enumeration<Train> getAllTrains()
    {
        return transportVehicleDatabase.getAllTrains();
    }
}
