package TravelBookingSystem.Company;

import TravelBookingSystem.Console.ConsoleUtils;

public class TrainCompanyFactory
{
    private static TrainCompanyFactory instance;

    public static TrainCompanyFactory getInstance()
    {
        if (instance == null)
        {
            instance = new TrainCompanyFactory();
        }

        return instance;
    }

    public TrainCompany createCompany()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Train Company ID: ");
        } while (!Company.isValidId(id));

        String name = ConsoleUtils.RequestNextLine("Enter Train Company Name: ");

        return new TrainCompany(id, name);
    }
}
