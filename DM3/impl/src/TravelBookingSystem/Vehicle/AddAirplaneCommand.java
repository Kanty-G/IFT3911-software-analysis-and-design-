package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;

public class AddAirplaneCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public AddAirplaneCommand(TransportVehicleService transportVehicleService)
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
