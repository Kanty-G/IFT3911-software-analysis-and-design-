package TravelBookingSystem.Infrastructure;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class ModifyHarborCommand implements Command
{
    private final InfrastructureService infrastructureService;
    private Harbor infrastructure;
    private InfrastructureMemento memento;

    public ModifyHarborCommand(InfrastructureService infrastructureService)
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

        infrastructure = infrastructureService.getHarbor(id);

        if (infrastructure == null)
        {
            System.out.println("Harbor does not exist");
            ConsoleUtils.WaitForInput();
            return;
        }

        memento = infrastructure.getMemento();

        String city = ConsoleUtils.RequestNextLine("Enter Harbor City: ");
        infrastructure.setCity(city);

        System.out.println("Harbor updated: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (memento == null)
        {
            return;
        }

        infrastructure.restoreFromMemento(memento);
        System.out.println("Harbor restored: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }
}
