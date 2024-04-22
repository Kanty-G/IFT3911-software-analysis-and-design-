package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;

public class ModifyAirplaneCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public ModifyAirplaneCommand(TransportVehicleService transportVehicleService)
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
