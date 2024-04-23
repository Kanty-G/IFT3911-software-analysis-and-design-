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

    }

    public void undo()
    {
        if (memento == null)
            return;

        travel.restoreFromMemento(memento);

        AdminTravelVisitor adminTravelVisitor = new AdminTravelVisitor();
        travel.accept(adminTravelVisitor);
        System.out.println("Train Route restored: " + adminTravelVisitor.getTravelString());
        ConsoleUtils.WaitForInput();
    }
}
