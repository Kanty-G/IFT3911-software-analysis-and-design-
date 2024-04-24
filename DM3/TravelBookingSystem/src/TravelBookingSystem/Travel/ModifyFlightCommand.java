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
        System.out.println("Modified Flight");
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (memento == null)
        {
            System.out.println("Restored Flight");
            ConsoleUtils.WaitForInput();
            return;
        }

        travel.restoreFromMemento(memento);

        AdminTravelVisitor adminTravelVisitor = new AdminTravelVisitor();
        travel.accept(adminTravelVisitor);
        System.out.println("Flight restored: " + adminTravelVisitor.getTravelString());
        ConsoleUtils.WaitForInput();
    }
}
