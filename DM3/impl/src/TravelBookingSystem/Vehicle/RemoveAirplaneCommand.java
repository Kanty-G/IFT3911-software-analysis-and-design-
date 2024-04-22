package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;

public class RemoveAirplaneCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public RemoveAirplaneCommand(TransportVehicleService transportVehicleService)
    {
        this.transportVehicleService = transportVehicleService;
    }

    public void execute()
    {

    }

    public void undo()
    {

    }
}
