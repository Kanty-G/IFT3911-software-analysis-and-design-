package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;
import TravelBookingSystem.Travel.Visitor.AdminTravelVisitor;

public class ModifyFlightCommand implements Command
{
    private final TravelService travelService;
    private Flight travel;
    private TravelMemento memento;

    public ModifyFlightCommand(TravelService travelService)
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
        System.out.println("Flight restored: " + adminTravelVisitor.getTravelString());
        ConsoleUtils.WaitForInput();
    }
}
