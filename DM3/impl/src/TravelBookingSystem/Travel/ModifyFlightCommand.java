package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;

public class ModifyFlightCommand implements Command
{
    private final TravelService travelService;

    public ModifyFlightCommand(TravelService travelService)
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
