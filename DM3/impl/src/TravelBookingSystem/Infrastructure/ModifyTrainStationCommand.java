package TravelBookingSystem.Infrastructure;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class ModifyTrainStationCommand implements Command
{
    private final InfrastructureService infrastructureService;
    private TrainStation infrastructure;
    private InfrastructureMemento memento;

    public ModifyTrainStationCommand(InfrastructureService infrastructureService)
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

        infrastructure = infrastructureService.getTrainStation(id);

        if (infrastructure == null)
        {
            System.out.println("Train Station does not exist");
            ConsoleUtils.WaitForInput();
            return;
        }

        memento = infrastructure.getMemento();

        String city = ConsoleUtils.RequestNextLine("Enter Train Station City: ");
        infrastructure.setCity(city);

        System.out.println("Train Station updated: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (memento == null)
            return;

        infrastructure.restoreFromMemento(memento);
        System.out.println("Train Station restored: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }
}
