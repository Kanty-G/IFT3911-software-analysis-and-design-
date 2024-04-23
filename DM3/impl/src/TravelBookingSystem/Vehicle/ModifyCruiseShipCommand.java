package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class ModifyCruiseShipCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public ModifyCruiseShipCommand(TransportVehicleService transportVehicleService)
    {
        this.transportVehicleService = transportVehicleService;
    }

    public void execute()
    {
        System.out.println("Modified CruiseShip");
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        System.out.println("Restored CruiseShip");
        ConsoleUtils.WaitForInput();
    }
}
