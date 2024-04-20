package TravelBookingSystem.Company;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class ModifyTrainCompanyCommand implements Command
{
    private final CompanyService companyService;
    private TrainCompany company;
    private CompanyMemento memento;

    public ModifyTrainCompanyCommand(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    public void execute()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Train Company ID: ");
        } while (!Company.isValidId(id));

        company = companyService.getTrainCompany(id);

        if (company == null)
        {
            System.out.println("Train Company does not exist");
            ConsoleUtils.WaitForInput();
            return;
        }

        memento = company.getMemento();

        String name = ConsoleUtils.RequestNextLine("Enter Train Company Name: ");
        company.setName(name);

        System.out.println("TrainCompany updated: " + company);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (memento == null)
            return;

        company.restoreFromMemento(memento);
        System.out.println("TrainCompany restored: " + company);
        ConsoleUtils.WaitForInput();
    }
}
