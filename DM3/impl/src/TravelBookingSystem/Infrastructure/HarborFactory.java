package TravelBookingSystem.Infrastructure;

import TravelBookingSystem.Console.ConsoleUtils;

public class HarborFactory
{
    private static HarborFactory instance;

    public static HarborFactory getInstance()
    {
        if (instance == null)
        {
            instance = new HarborFactory();
        }

        return instance;
    }

    public Harbor createInfrastructure()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Harbor  ID: ");
        } while (!Infrastructure.isValidId(id));

        String city = ConsoleUtils.RequestNextLine("Enter Harbor City: ");

        return new Harbor(id, city);
    }
}
