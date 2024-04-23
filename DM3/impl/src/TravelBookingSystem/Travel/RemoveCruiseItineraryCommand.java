package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class RemoveCruiseItineraryCommand implements Command
{
    private final TravelService travelService;

    public RemoveCruiseItineraryCommand(TravelService travelService)
    {
        this.travelService = travelService;
    }

    public void execute()
    {
        System.out.println("Removed CruiseItinerary");
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        System.out.println("Added CruiseItinerary");
        ConsoleUtils.WaitForInput();
    }
}
