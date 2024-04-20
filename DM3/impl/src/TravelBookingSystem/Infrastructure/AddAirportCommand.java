package TravelBookingSystem.Infrastructure;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Console.ConsoleUtils;

public class AddAirportCommand implements Command
{
    private final InfrastructureService infrastructureService;
    private Airport infrastructure;

    public AddAirportCommand(InfrastructureService infrastructureService)
    {
        this.infrastructureService = infrastructureService;
    }

    public void execute()
    {
        infrastructure = AirportFactory.getInstance().createInfrastructure();
        infrastructureService.addAirport(infrastructure);
        System.out.println("Airport added: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }

    public void undo()
    {
        if (infrastructure == null)
        {
            return;
        }

        infrastructureService.removeAirport(infrastructure.getId());
        System.out.println("Airport removed: " + infrastructure);
        ConsoleUtils.WaitForInput();
    }
}
