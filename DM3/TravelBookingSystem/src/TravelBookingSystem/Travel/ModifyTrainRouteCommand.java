package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;
import TravelBookingSystem.Travel.Visitor.AdminTravelVisitor;

public class ModifyTrainRouteCommand implements Command
{
    private final TravelService travelService;
    private TrainRoute travel;
    private TravelMemento memento;

    public ModifyTrainRouteCommand(TravelService travelService)
    {
        this.travelService = travelService;
    }

    public void execute()
    {
        System.out.println("Modified Travel Route");
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (memento == null)
        {
            System.out.println("Restored Travel Route");
            ConsoleUtils.WaitForInput();
            return;
        }

        travel.restoreFromMemento(memento);

        AdminTravelVisitor adminTravelVisitor = new AdminTravelVisitor();
        travel.accept(adminTravelVisitor);
        System.out.println("Train Route restored: " + adminTravelVisitor.getTravelString());
        ConsoleUtils.WaitForInput();
    }
}
