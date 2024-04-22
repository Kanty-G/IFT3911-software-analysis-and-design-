package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Vehicle.TransportVehicleService;

public class AddFlightCommand implements Command
{
    private final TravelService travelService;
    private final TransportVehicleService transportVehicleService;

    public AddFlightCommand(TravelService travelService, TransportVehicleService transportVehicleService)
    {
        this.travelService = travelService;
        this.transportVehicleService = transportVehicleService;
    }

    public void execute()
    {

    }

    public void undo()
    {

    }
}
