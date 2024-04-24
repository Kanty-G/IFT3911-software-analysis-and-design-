package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class ModifyAirplaneCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public ModifyAirplaneCommand(TransportVehicleService transportVehicleService)
    {
        this.transportVehicleService = transportVehicleService;
    }

    public void execute()
    {
        System.out.println("Modified Airplane");
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        System.out.println("Restored Airplane");
        ConsoleUtils.WaitForInput();
    }
}
