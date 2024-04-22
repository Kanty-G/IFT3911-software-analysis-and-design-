package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;

public class AddTrainCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public AddTrainCommand(TransportVehicleService transportVehicleService)
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
