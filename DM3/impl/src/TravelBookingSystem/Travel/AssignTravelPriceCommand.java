package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;

public class AssignTravelPriceCommand implements Command
{
    private final TravelService travelService;

    public AssignTravelPriceCommand(TravelService travelService)
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
