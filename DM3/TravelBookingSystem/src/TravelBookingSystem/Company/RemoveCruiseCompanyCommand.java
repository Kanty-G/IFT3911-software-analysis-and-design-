package TravelBookingSystem.Company;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class RemoveCruiseCompanyCommand implements Command
{
    private final CompanyService companyService;
    private CruiseCompany company;

    public RemoveCruiseCompanyCommand(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    public void execute()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Cruise Company ID: ");
        } while (!Company.isValidId(id));

        company = companyService.removeCruiseCompany(id);
        System.out.println("CruiseCompany removed: " + company);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (company == null)
        {
            return;
        }

        companyService.addCruiseCompany(company);
        System.out.println("CruiseCompany added: " + company);
        ConsoleUtils.WaitForInput();
    }
}
