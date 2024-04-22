package TravelBookingSystem.Vehicle;

public class AirplaneFactory implements TransportVehicleFactory
{
    private static AirplaneFactory instance;

    public static AirplaneFactory getInstance()
    {
        if (instance == null)
            instance = new AirplaneFactory();

        return instance;
    }

    public Airplane createTransportVehicle()
    {
        return new Airplane();
    }
}
