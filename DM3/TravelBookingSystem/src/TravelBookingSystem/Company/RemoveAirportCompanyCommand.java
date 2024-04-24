package TravelBookingSystem.Company;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class RemoveAirportCompanyCommand implements Command
{
    private final CompanyService companyService;
    private AirportCompany company;

    public RemoveAirportCompanyCommand(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    public void execute()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Airport Company ID: ");
        } while (!Company.isValidId(id));

        company = companyService.removeAirportCompany(id);
        System.out.println("AirportCompany removed: " + company);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (company == null)
            return;

        companyService.addAirportCompany(company);
        System.out.println("AirportCompany added: " + company);
        ConsoleUtils.WaitForInput();
    }
}
