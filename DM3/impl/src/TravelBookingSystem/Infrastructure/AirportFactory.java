package TravelBookingSystem.Infrastructure;

import TravelBookingSystem.Console.ConsoleUtils;

public class AirportFactory implements InfrastructureFactory
{
    private static AirportFactory instance;

    public static AirportFactory getInstance()
    {
        if (instance == null)
        {
            instance = new AirportFactory();
        }

        return instance;
    }

    public Airport createInfrastructure()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Airport  ID: ");
        } while (!Infrastructure.isValidId(id));

        String city = ConsoleUtils.RequestNextLine("Enter Airport City: ");

        return new Airport(id, city);
    }
}
