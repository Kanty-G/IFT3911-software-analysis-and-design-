package TravelBookingSystem.Vehicle;

public class CruiseShipFactory implements TransportVehicleFactory
{
    private static CruiseShipFactory instance;

    public static CruiseShipFactory getInstance()
    {
        if (instance == null)
            instance = new CruiseShipFactory();

        return instance;
    }

    public CruiseShip createTransportVehicle()
    {
        return new CruiseShip();
    }
}
