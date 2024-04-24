package TravelBookingSystem.Infrastructure;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class RemoveTrainStationCommand implements Command
{
    private final InfrastructureService infrastructureService;
    private TrainStation infrastructure;

    public RemoveTrainStationCommand(InfrastructureService infrastructureService)
    {
        this.infrastructureService = infrastructureService;
    }

    public void execute()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Train Station ID: ");
        } while (!Infrastructure.isValidId(id));

        infrastructure = infrastructureService.removeTrainStation(id);
        System.out.println("Train Station removed: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (infrastructure == null)
        {
            return;
        }

        infrastructureService.addTrainStation(infrastructure);
        System.out.println("Train Station added: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }
}
