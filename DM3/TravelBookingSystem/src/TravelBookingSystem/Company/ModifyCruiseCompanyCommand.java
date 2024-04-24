package TravelBookingSystem.Company;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class ModifyCruiseCompanyCommand implements Command
{
    private final CompanyService companyService;
    private CruiseCompany company;
    private CompanyMemento memento;

    public ModifyCruiseCompanyCommand(CompanyService companyService)
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

        company = companyService.getCruiseCompany(id);

        if (company == null)
        {
            System.out.println("Cruise Company does not exist");
            ConsoleUtils.WaitForInput();
            return;
        }

        memento = company.getMemento();

        String name = ConsoleUtils.RequestNextLine("Enter Cruise Company Name: ");
        company.setName(name);

        System.out.println("CruiseCompany updated: " + company);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (memento == null)
        {
            return;
        }

        company.restoreFromMemento(memento);
        System.out.println("CruiseCompany restored: " + company);
        ConsoleUtils.WaitForInput();
    }
}
