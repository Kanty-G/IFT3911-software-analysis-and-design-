package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class RemoveTrainRouteCommand implements Command
{
    private final TravelService travelService;

    public RemoveTrainRouteCommand(TravelService travelService)
    {
        this.travelService = travelService;
    }

    public void execute()
    {
        System.out.println("Removed train route");
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        System.out.println("Added train route");
        ConsoleUtils.WaitForInput();
    }
}
