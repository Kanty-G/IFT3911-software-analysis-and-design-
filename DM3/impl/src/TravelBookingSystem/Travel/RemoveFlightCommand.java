package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;

public class RemoveFlightCommand implements Command
{
    private final TravelService travelService;

    public RemoveFlightCommand(TravelService travelService)
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
