package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;

public class RemoveCruiseShipCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public RemoveCruiseShipCommand(TransportVehicleService transportVehicleService)
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
