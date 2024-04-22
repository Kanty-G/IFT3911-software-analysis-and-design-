package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;

public class AddCruiseShipCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public AddCruiseShipCommand(TransportVehicleService transportVehicleService)
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
