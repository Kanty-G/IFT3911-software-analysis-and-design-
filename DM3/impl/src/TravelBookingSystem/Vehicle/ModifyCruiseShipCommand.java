package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;

public class ModifyCruiseShipCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public ModifyCruiseShipCommand(TransportVehicleService transportVehicleService)
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
