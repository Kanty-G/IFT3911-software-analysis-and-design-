package TravelBookingSystem.Infrastructure;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class AddHarborCommand implements Command
{
    private final InfrastructureService infrastructureService;
    private Harbor infrastructure;

    public AddHarborCommand(InfrastructureService infrastructureService)
    {
        this.infrastructureService = infrastructureService;
    }

    public void execute()
    {
        infrastructure = HarborFactory.getInstance().createInfrastructure();
        infrastructureService.addHarbor(infrastructure);
        System.out.println("Harbor added: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (infrastructure == null)
        {
            return;
        }

        infrastructureService.removeHarbor(infrastructure.getId());
        System.out.println("Harbor removed: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }
}
