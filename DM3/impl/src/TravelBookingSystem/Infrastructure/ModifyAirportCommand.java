package TravelBookingSystem.Infrastructure;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class ModifyAirportCommand implements Command
{
    private final InfrastructureService infrastructureService;
    private Airport infrastructure;
    private InfrastructureMemento memento;

    public ModifyAirportCommand(InfrastructureService infrastructureService)
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

        infrastructure = infrastructureService.getAirport(id);

        if (infrastructure == null)
        {
            System.out.println("Airport does not exist");
            ConsoleUtils.WaitForInput();
            return;
        }

        memento = infrastructure.getMemento();

        String city = ConsoleUtils.RequestNextLine("Enter Airport City: ");
        infrastructure.setCity(city);

        System.out.println("Airport updated: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (memento == null)
            return;

        infrastructure.restoreFromMemento(memento);
        System.out.println("Airport restored: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }
}
