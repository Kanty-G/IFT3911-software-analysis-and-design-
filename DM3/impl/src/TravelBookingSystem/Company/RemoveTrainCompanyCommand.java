package TravelBookingSystem.Company;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class RemoveTrainCompanyCommand implements Command
{
    private final CompanyService companyService;
    private TrainCompany company;

    public RemoveTrainCompanyCommand(CompanyService companyService)
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

        company = companyService.removeTrainCompany(id);
        System.out.println("TrainCompany removed: " + company);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (company == null)
        {
            return;
        }

        companyService.addTrainCompany(company);
        System.out.println("TrainCompany added: " + company);
        ConsoleUtils.WaitForInput();
    }
}
