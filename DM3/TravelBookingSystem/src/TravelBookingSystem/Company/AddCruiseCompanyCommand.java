package TravelBookingSystem.Company;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class AddCruiseCompanyCommand implements Command
{
    private final CompanyService companyService;
    private CruiseCompany company;

    public AddCruiseCompanyCommand(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    public void execute()
    {
        company = CruiseCompanyFactory.getInstance().createCompany();
        companyService.addCruiseCompany(company);
        System.out.println("CruiseCompany added: " + company);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (company == null)
        {
            return;
        }

        companyService.removeCruiseCompany(company.getId());
        System.out.println("CruiseCompany removed: " + company);
        ConsoleUtils.WaitForInput();
    }
}
