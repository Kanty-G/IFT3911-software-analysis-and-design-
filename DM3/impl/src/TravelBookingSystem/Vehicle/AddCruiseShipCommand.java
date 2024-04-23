package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class AddCruiseShipCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public AddCruiseShipCommand(TransportVehicleService transportVehicleService)
    {
        this.transportVehicleService = transportVehicleService;
    }

    public void execute()
    {
        System.out.println("Added CruiseShip");
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        System.out.println("Removed CruiseShip");
        ConsoleUtils.WaitForInput();
    }
}
