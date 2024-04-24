package TravelBookingSystem.Infrastructure;

import TravelBookingSystem.Console.ConsoleUtils;

public class TrainStationFactory implements InfrastructureFactory
{
    private static TrainStationFactory instance;

    public static TrainStationFactory getInstance()
    {
        if (instance == null)
        {
            instance = new TrainStationFactory();
        }

        return instance;
    }

    public TrainStation createInfrastructure()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Train Station  ID: ");
        } while (!Infrastructure.isValidId(id));

        String city = ConsoleUtils.RequestNextLine("Enter Train Station City: ");

        return new TrainStation(id, city);
    }
}
