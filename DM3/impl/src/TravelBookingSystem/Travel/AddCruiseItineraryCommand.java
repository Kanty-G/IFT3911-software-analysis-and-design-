package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Vehicle.TransportVehicleService;

public class AddCruiseItineraryCommand implements Command
{
    private final TravelService travelService;
    private final TransportVehicleService transportVehicleService;

    public AddCruiseItineraryCommand(TravelService travelService, TransportVehicleService transportVehicleService)
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
