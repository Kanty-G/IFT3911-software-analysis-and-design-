package TravelBookingSystem.Company;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class AddAirportCompanyCommand implements Command
{
    private final CompanyService companyService;
    private AirportCompany company;

    public AddAirportCompanyCommand(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    public void execute()
    {
        company = AirportCompanyFactory.getInstance().createCompany();
        companyService.addAirportCompany(company);
        System.out.println("AirportCompany added: " + company);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (company == null)
            return;

        companyService.removeAirportCompany(company.getId());
        System.out.println("AirportCompany removed: " + company);
        ConsoleUtils.WaitForInput();
    }
}
