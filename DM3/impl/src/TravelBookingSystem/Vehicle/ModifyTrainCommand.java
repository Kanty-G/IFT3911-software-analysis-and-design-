package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;

public class ModifyTrainCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public ModifyTrainCommand(TransportVehicleService transportVehicleService)
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
