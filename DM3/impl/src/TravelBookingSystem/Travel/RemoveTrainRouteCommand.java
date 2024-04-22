package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;

public class RemoveTrainRouteCommand implements Command
{
    private final TravelService travelService;

    public RemoveTrainRouteCommand(TravelService travelService)
    {
        this.travelService = travelService;
    }

    public void execute()
    {

    }

    public void undo()
    {

    }
}
