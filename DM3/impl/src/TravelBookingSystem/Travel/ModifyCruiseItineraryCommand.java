package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;

public class ModifyCruiseItineraryCommand implements Command
{
    private final TravelService travelService;

    public ModifyCruiseItineraryCommand(TravelService travelService)
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
