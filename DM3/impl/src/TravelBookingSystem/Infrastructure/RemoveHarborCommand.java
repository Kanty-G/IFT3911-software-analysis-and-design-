package TravelBookingSystem.Infrastructure;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class RemoveHarborCommand implements Command
{
    private final InfrastructureService infrastructureService;
    private Harbor infrastructure;

    public RemoveHarborCommand(InfrastructureService infrastructureService)
    {
        this.infrastructureService = infrastructureService;
    }

    public void execute()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Harbor ID: ");
        } while (!Infrastructure.isValidId(id));

        infrastructure = infrastructureService.removeHarbor(id);
        System.out.println("Harbor removed: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (infrastructure == null)
        {
            return;
        }

        infrastructureService.addHarbor(infrastructure);
        System.out.println("Harbor added: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }
}
