package TravelBookingSystem.Company;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class ModifyAirportCompanyCommand implements Command
{
    private final CompanyService companyService;
    private AirportCompany company;
    private CompanyMemento memento;

    public ModifyAirportCompanyCommand(CompanyService companyService)
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

        company = companyService.getAirportCompany(id);

        if (company == null)
        {
            System.out.println("Airport Company does not exist");
            ConsoleUtils.WaitForInput();
            return;
        }

        memento = company.getMemento();

        String name = ConsoleUtils.RequestNextLine("Enter Airport Company Name: ");
        company.setName(name);

        System.out.println("AirportCompany updated: " + company);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (memento == null)
            return;

        company.restoreFromMemento(memento);
        System.out.println("AirportCompany restored: " + company);
        ConsoleUtils.WaitForInput();
    }
}
