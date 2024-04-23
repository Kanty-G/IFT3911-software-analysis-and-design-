package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;
import TravelBookingSystem.Travel.Visitor.AdminTravelVisitor;
import TravelBookingSystem.Travel.Visitor.TravelVisitor;

public class ModifyCruiseItineraryCommand implements Command
{
    private final TravelService travelService;
    private CruiseItinerary travel;
    private TravelMemento memento;

    public ModifyCruiseItineraryCommand(TravelService travelService)
    {
        this.travelService = travelService;
    }

    public void execute()
    {
        System.out.println("Modify CruiseItinerary");
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (memento == null)
        {
            System.out.println("Restored CruiseItinerary");
            ConsoleUtils.WaitForInput();
            return;
        }

        travel.restoreFromMemento(memento);

        AdminTravelVisitor adminTravelVisitor = new AdminTravelVisitor();
        travel.accept(adminTravelVisitor);
        System.out.println("Cruise Itinerary restored: " + adminTravelVisitor.getTravelString());
        ConsoleUtils.WaitForInput();
    }
}
