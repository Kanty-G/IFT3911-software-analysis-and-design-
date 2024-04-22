package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;

public class ModifyTrainRouteCommand implements Command
{
    private final TravelService travelService;

    public ModifyTrainRouteCommand(TravelService travelService)
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
