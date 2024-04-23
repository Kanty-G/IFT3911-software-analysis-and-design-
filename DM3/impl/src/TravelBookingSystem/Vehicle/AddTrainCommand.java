package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class AddTrainCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public AddTrainCommand(TransportVehicleService transportVehicleService)
    {
        this.transportVehicleService = transportVehicleService;
    }

    public void execute()
    {
        System.out.println("Added Train");
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        System.out.println("Removed Train");
        ConsoleUtils.WaitForInput();
    }
}
