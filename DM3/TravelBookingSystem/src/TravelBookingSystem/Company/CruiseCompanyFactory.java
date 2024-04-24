package TravelBookingSystem.Company;

import TravelBookingSystem.Console.ConsoleUtils;

public class CruiseCompanyFactory implements CompanyFactory
{
    private static CruiseCompanyFactory instance;

    public static CruiseCompanyFactory getInstance()
    {
        if (instance == null)
        {
            instance = new CruiseCompanyFactory();
        }

        return instance;
    }

    public CruiseCompany createCompany()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Cruise Company ID: ");
        } while (!Company.isValidId(id));

        String name = ConsoleUtils.RequestNextLine("Enter Cruise Company Name: ");

        return new CruiseCompany(id, name);
    }
}
