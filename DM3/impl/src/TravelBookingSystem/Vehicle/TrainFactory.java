package TravelBookingSystem.Vehicle;

public class TrainFactory implements TransportVehicleFactory
{
    private static TrainFactory instance;

    public static TrainFactory getInstance()
    {
        if (instance == null)
            instance = new TrainFactory();

        return instance;
    }

    public Train createTransportVehicle()
    {
        return new Train();
    }
}
