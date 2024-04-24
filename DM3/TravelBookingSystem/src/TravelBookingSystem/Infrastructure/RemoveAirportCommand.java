package TravelBookingSystem.Infrastructure;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class RemoveAirportCommand implements Command
{
    private final InfrastructureService infrastructureService;
    private Airport infrastructure;

    public RemoveAirportCommand(InfrastructureService infrastructureService)
    {
        this.infrastructureService = infrastructureService;
    }

    public void execute()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Airport ID: ");
        } while (!Infrastructure.isValidId(id));

        infrastructure = infrastructureService.removeAirport(id);
        System.out.println("Airport removed: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (infrastructure == null)
            return;

        infrastructureService.addAirport(infrastructure);
        System.out.println("Airport added: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }
}
