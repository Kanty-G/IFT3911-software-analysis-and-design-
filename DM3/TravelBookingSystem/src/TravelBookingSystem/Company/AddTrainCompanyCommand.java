package TravelBookingSystem.Company;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class AddTrainCompanyCommand implements Command
{
    private final CompanyService companyService;
    private TrainCompany company;

    public AddTrainCompanyCommand(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    public void execute()
    {
        company = TrainCompanyFactory.getInstance().createCompany();
        companyService.addTrainCompany(company);
        System.out.println("TrainCompany added: " + company);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (company == null)
        {
            return;
        }

        companyService.removeTrainCompany(company.getId());
        System.out.println("TrainCompany removed: " + company);
        ConsoleUtils.WaitForInput();
    }
}
