package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;

public class RemoveCruiseItineraryCommand implements Command
{
    private final TravelService travelService;

    public RemoveCruiseItineraryCommand(TravelService travelService)
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
