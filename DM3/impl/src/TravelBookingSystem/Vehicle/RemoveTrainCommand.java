package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;

public class RemoveTrainCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public RemoveTrainCommand(TransportVehicleService transportVehicleService)
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
