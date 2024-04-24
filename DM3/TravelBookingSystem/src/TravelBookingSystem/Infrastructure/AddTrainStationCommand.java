package TravelBookingSystem.Infrastructure;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class AddTrainStationCommand implements Command
{
    private final InfrastructureService infrastructureService;
    private TrainStation infrastructure;

    public AddTrainStationCommand(InfrastructureService infrastructureService)
    {
        this.infrastructureService = infrastructureService;
    }

    public void execute()
    {
        infrastructure = TrainStationFactory.getInstance().createInfrastructure();
        infrastructureService.addTrainStation(infrastructure);
        System.out.println("Train Station added: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (infrastructure == null)
        {
            return;
        }

        infrastructureService.removeTrainStation(infrastructure.getId());
        System.out.println("Train Station removed: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }
}
