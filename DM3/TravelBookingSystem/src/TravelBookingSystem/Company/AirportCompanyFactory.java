package TravelBookingSystem.Company;

import TravelBookingSystem.Console.ConsoleUtils;

public class AirportCompanyFactory implements CompanyFactory
{
    private static AirportCompanyFactory instance;

    public static AirportCompanyFactory getInstance()
    {
        if (instance == null)
        {
            instance = new AirportCompanyFactory();
        }

        return instance;
    }

    public AirportCompany createCompany()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Airport Company ID: ");
        } while (!Company.isValidId(id));

        String name = ConsoleUtils.RequestNextLine("Enter Airport Company Name: ");

        return new AirportCompany(id, name);
    }
}
