package TravelBookingSystem.Controller;

import TravelBookingSystem.Command.Command;
import TravelBookingSystem.Company.*;
import TravelBookingSystem.Console.ConsoleUtils;
import TravelBookingSystem.Infrastructure.*;
import TravelBookingSystem.Travel.*;
import TravelBookingSystem.Travel.Visitor.AdminTravelVisitor;
import TravelBookingSystem.Vehicle.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
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
        Command command = new AddFlightCommand(travelService, transportVehicleService);
        command.execute();
        commandHistory.push(command);
    }

    public void modifyFlight()
    {
        Command command = new ModifyFlightCommand(travelService);
        command.execute();
        commandHistory.push(command);
    }

    public void deleteFlight()
    {
        Command command = new RemoveFlightCommand(travelService);
        command.execute();
        commandHistory.push(command);
    }

    public ArrayList<Travel> searchFlightsByAirport()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Departure Airport ID: ");
        } while (!Infrastructure.isValidId(id));

        return filterTravelsByDepartureInfrastructure(id, travelService.getAllFlights());
    }

    public ArrayList<Travel> searchFlightsByAirportCompany()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Airport Company ID: ");
        } while (!Company.isValidId(id));

        return filterTravelByCompany(id, travelService.getAllFlights());
    }

    public void addCruiseItinerary()
    {
        Command command = new AddCruiseItineraryCommand(travelService, transportVehicleService);
        command.execute();
        commandHistory.push(command);
    }

    public void modifyCruiseItinerary()
    {
        Command command = new ModifyCruiseItineraryCommand(travelService);
        command.execute();
        commandHistory.push(command);
    }

    public void deleteCruiseItinerary()
    {
        Command command = new RemoveCruiseItineraryCommand(travelService);
        command.execute();
        commandHistory.push(command);
    }

    public ArrayList<Travel> searchCruiseItinerariesByHarbor()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Departure Harbor ID: ");
        } while (!Infrastructure.isValidId(id));

        return filterTravelsByDepartureInfrastructure(id, travelService.getAllCruiseItineraries());
    }

    public ArrayList<Travel> searchCruiseItinerariesByCruiseCompany()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Cruise Company ID: ");
        } while (!Company.isValidId(id));

        return filterTravelByCompany(id, travelService.getAllCruiseItineraries());
    }

    public void addTrainRoute()
    {
        Command command = new AddTrainRouteCommand(travelService, transportVehicleService);
        command.execute();
        commandHistory.push(command);
    }

    public void modifyTrainRoute()
    {
        Command command = new ModifyTrainRouteCommand(travelService);
        command.execute();
        commandHistory.push(command);
    }

    public void deleteTrainRoute()
    {
        Command command = new RemoveTrainRouteCommand(travelService);
        command.execute();
        commandHistory.push(command);
    }

    public ArrayList<Travel> searchTrainRoutesByTrainStation()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Departure Train Station ID: ");
        } while (!Infrastructure.isValidId(id));

        return filterTravelsByDepartureInfrastructure(id, travelService.getAllTrainRoutes());
    }

    public ArrayList<Travel> searchTrainRoutesByTrainCompany()
    {
        String id;
        do
        {
            id = ConsoleUtils.RequestNextLine("Enter Train Company ID: ");
        } while (!Company.isValidId(id));

        return filterTravelByCompany(id, travelService.getAllTrainRoutes());
    }

    public void addAirplane()
    {
        Command command = new AddAirplaneCommand(transportVehicleService);
        command.execute();
        commandHistory.push(command);
    }

    public void modifyAirplane()
    {
        Command command = new ModifyAirplaneCommand(transportVehicleService);
        command.execute();
        commandHistory.push(command);
    }

    public void deleteAirplane()
    {
        Command command = new RemoveAirplaneCommand(transportVehicleService);
        command.execute();
        commandHistory.push(command);
    }

    public void addCruiseShip()
    {
        Command command = new AddCruiseShipCommand(transportVehicleService);
        command.execute();
        commandHistory.push(command);
    }

    public void modifyCruiseShip()
    {
        Command command = new ModifyCruiseShipCommand(transportVehicleService);
        command.execute();
        commandHistory.push(command);
    }

    public void deleteCruiseShip()
    {
        Command command = new RemoveCruiseShipCommand(transportVehicleService);
        command.execute();
        commandHistory.push(command);
    }

    public void addTrain()
    {
        Command command = new AddTrainCommand(transportVehicleService);
        command.execute();
        commandHistory.push(command);
    }

    public void modifyTrain()
    {
        Command command = new ModifyTrainCommand(transportVehicleService);
        command.execute();
        commandHistory.push(command);
    }

    public void deleteTrain()
    {
        Command command = new RemoveTrainCommand(transportVehicleService);
        command.execute();
        commandHistory.push(command);
    }

    private ArrayList<Travel> filterTravelByCompany(String companyId, Enumeration<? extends Travel> travels)
    {
        ArrayList<Travel> filteredTravels = new ArrayList<>();
        while(travels.hasMoreElements())
        {
            Travel travel = travels.nextElement();
            if (travel.getCompanyId().equals(companyId))
            {
                filteredTravels.add(travel);
            }
        }

        return filteredTravels;
    }

    private ArrayList<Travel> filterTravelsByDepartureInfrastructure(String departureInfrastructureId, Enumeration<? extends Travel> travels)
    {
        ArrayList<Travel> filteredTravels = new ArrayList<>();
        while(travels.hasMoreElements())
        {
            Travel travel = travels.nextElement();
            if (travel.getDepartureInfrastructure().getId().equals(departureInfrastructureId))
            {
                filteredTravels.add(travel);
            }
        }

        return filteredTravels;
    }
}