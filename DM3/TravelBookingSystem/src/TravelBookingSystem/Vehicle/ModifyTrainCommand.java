package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class ModifyTrainCommand implements Command
{
    private final TransportVehicleService transportVehicleService;

    public ModifyTrainCommand(TransportVehicleService transportVehicleService)
    {
        this.transportVehicleService = transportVehicleService;
    }

    public void execute()
    {
        System.out.println("Modified Train");
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        System.out.println("Restored Train");
        ConsoleUtils.WaitForInput();
    }
}
