package TravelBookingSystem.Travel;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;
import TravelBookingSystem.Vehicle.TransportVehicleService;

public class AddTrainRouteCommand implements Command
{
    private final TravelService travelService;
    private final TransportVehicleService transportVehicleService;

    public AddTrainRouteCommand(TravelService travelService, TransportVehicleService transportVehicleService)
    {
        this.travelService = travelService;
        this.transportVehicleService = transportVehicleService;
    }

    public void execute()
    {
        System.out.println("Added TrainRoute");
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        System.out.println("Removed TrainRoute");
        ConsoleUtils.WaitForInput();
    }
}
