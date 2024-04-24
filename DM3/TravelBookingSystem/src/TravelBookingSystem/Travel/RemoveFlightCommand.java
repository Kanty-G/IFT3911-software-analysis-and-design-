package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class RemoveFlightCommand implements Command
{
    private final TravelService travelService;

    public RemoveFlightCommand(TravelService travelService)
    {
        this.travelService = travelService;
    }

    public void execute()
    {
        System.out.println("Removed flight");
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        System.out.println("Added flight");
        ConsoleUtils.WaitForInput();
    }
}
