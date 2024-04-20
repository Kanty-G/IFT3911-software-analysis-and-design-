package TravelBookingSystem.Controller;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Company.*;
import TravelBookingSystem.Console.ConsoleUtils;
import TravelBookingSystem.Infrastructure.*;
import TravelBookingSystem.Travel.TravelService;
import TravelBookingSystem.Vehicle.TransportVehicleService;

import java.util.Stack;

public class AdminController
{
    private final CompanyService companyService;
    private final InfrastructureService infrastructureService;
    private final TransportVehicleService transportVehicleService;
    private final TravelService travelService;

    private final Stack<Command> commandHistory = new Stack<>();

    public AdminController(CompanyService companyService, InfrastructureService infrastructureService, TransportVehicleService transportVehicleService, TravelService travelService)
    {
        this.companyService = companyService;
        this.infrastructureService = infrastructureService;
        this.transportVehicleService = transportVehicleService;
        this.travelService = travelService;
    }

    public void undo()
    {
        if (commandHistory.isEmpty())
        {
            System.out.println("Nothing to undo");
            ConsoleUtils.WaitForInput();
            return;
        }

        Command command = commandHistory.pop();
        command.undo();
    }

    public void addAirportCompany()
    {
        Command command = new AddAirportCompanyCommand(companyService);
        command.execute();
        commandHistory.push(command);
    }

    public void modifyAirportCompany()
    {
        Command command = new ModifyAirportCompanyCommand(companyService);
        command.execute();
        commandHistory.push(command);
    }

    public void deleteAirportCompany()
    {
        Command command = new RemoveAirportCompanyCommand(companyService);
        command.execute();
        commandHistory.push(command);
    }

    public void addCruiseCompany()
    {
        Command command = new AddCruiseCompanyCommand(companyService);
        command.execute();
        commandHistory.push(command);
    }

    public void modifyCruiseCompany()
    {
        Command command = new ModifyCruiseCompanyCommand(companyService);
        command.execute();
        commandHistory.push(command);
    }

    public void deleteCruiseCompany()
    {
        Command command = new RemoveCruiseCompanyCommand(companyService);
        command.execute();
        commandHistory.push(command);
    }

    public void addTrainCompany()
    {
        Command command = new AddTrainCompanyCommand(companyService);
        command.execute();
        commandHistory.push(command);
    }

    public void modifyTrainCompany()
    {
        Command command = new ModifyTrainCompanyCommand(companyService);
        command.execute();
        commandHistory.push(command);
    }

    public void deleteTrainCompany()
    {
        Command command = new RemoveTrainCompanyCommand(companyService);
        command.execute();
        commandHistory.push(command);
    }

    public void addAirport()
    {
        Command command = new AddAirportCommand(infrastructureService);
        command.execute();
        commandHistory.push(command);
    }

    public void modifyAirport()
    {
        Command command = new ModifyAirportCommand(infrastructureService);
        command.execute();
        commandHistory.push(command);
    }

    public void deleteAirport()
    {
        Command command = new RemoveAirportCommand(infrastructureService);
        command.execute();
        commandHistory.push(command);
    }

    public void addHarbor()
    {
        Command command = new AddHarborCommand(infrastructureService);
        command.execute();
        commandHistory.push(command);
    }

    public void modifyHarbor()
    {
        Command command = new ModifyHarborCommand(infrastructureService);
        command.execute();
        commandHistory.push(command);
    }

    public void deleteHarbor()
    {
        Command command = new RemoveHarborCommand(infrastructureService);
        command.execute();
        commandHistory.push(command);
    }

    public void addTrainStation()
    {
        Command command = new AddTrainStationCommand(infrastructureService);
        command.execute();
        commandHistory.push(command);
    }

    public void modifyTrainStation()
    {
        Command command = new ModifyTrainStationCommand(infrastructureService);
        command.execute();
        commandHistory.push(command);
    }

    public void deleteTrainStation()
    {
        Command command = new RemoveTrainStationCommand(infrastructureService);
        command.execute();
        commandHistory.push(command);
    }

    public void addFlight()
    {
        // TODO: Convert to command
        travelService.addFlight();
    }

    public void modifyFlight()
    {
        // TODO: Convert to command
        travelService.modifyFlight();
    }

    public void deleteFlight()
    {
        // TODO: Convert to command
        travelService.deleteFlight();
    }

    public void addCruiseItinerary()
    {
        // TODO: Convert to command
        travelService.addCruiseItinerary();
    }

    public void modifyCruiseItinerary()
    {
        // TODO: Convert to command
        travelService.modifyCruiseItinerary();
    }

    public void deleteCruiseItinerary()
    {
        // TODO: Convert to command
        travelService.deleteCruiseItinerary();
    }

    public void addTrainRoute()
    {
        // TODO: Convert to command
        travelService.addTrainRoute();
    }

    public void modifyTrainRoute()
    {
        // TODO: Convert to command
        travelService.modifyTrainRoute();
    }

    public void deleteTrainRoute()
    {
        // TODO: Convert to command
        travelService.deleteTrainRoute();
    }

    public void addAirplane()
    {
        // TODO: Convert to command
        transportVehicleService.addAirplane();
    }

    public void modifyAirplane()
    {
        // TODO: Convert to command
        transportVehicleService.modifyAirplane();
    }

    public void deleteAirplane()
    {
        // TODO: Convert to command
        transportVehicleService.deleteAirplane();
    }

    public void addCruiseShip()
    {
        // TODO: Convert to command
        transportVehicleService.addCruiseShip();
    }

    public void modifyCruiseShip()
    {
        // TODO: Convert to command
        transportVehicleService.modifyCruiseShip();
    }

    public void deleteCruiseShip()
    {
        // TODO: Convert to command
        transportVehicleService.deleteCruiseShip();
    }

    public void addTrain()
    {
        // TODO: Convert to command
        transportVehicleService.addTrain();
    }

    public void modifyTrain()
    {
        // TODO: Convert to command
        transportVehicleService.modifyTrain();
    }

    public void deleteTrain()
    {
        // TODO: Convert to command
        transportVehicleService.deleteTrain();
    }
}