package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class AssignTravelPriceCommand implements Command
{
    private final TravelService travelService;

    public AssignTravelPriceCommand(TravelService travelService)
    {
        this.travelService = travelService;
    }

    public void execute()
    {
        System.out.println("Assigned Travel Price");
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        System.out.println("Restored Travel Price");
        ConsoleUtils.WaitForInput();
    }
}
