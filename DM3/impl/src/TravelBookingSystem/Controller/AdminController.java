package TravelBookingSystem.Controller;

import TravelBookingSystem.Company.CompanyService;
import TravelBookingSystem.Default.Command;
import TravelBookingSystem.Infrastructure.InfrastructureService;
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
        // TODO
    }

    public void addAirportCompany()
    {
        // TODO: Convert to command
        companyService.addAirportCompany();
    }

    public void modifyAirportCompany()
    {
        // TODO: Convert to command
        companyService.modifyAirportCompany();
    }

    public void deleteAirportCompany()
    {
        // TODO: Convert to command
        companyService.deleteAirportCompany();
    }

    public void addCruiseCompany()
    {
        // TODO: Convert to command
        companyService.addCruiseCompany();
    }

    public void modifyCruiseCompany()
    {
        // TODO: Convert to command
        companyService.modifyCruiseCompany();
    }

    public void deleteCruiseCompany()
    {
        // TODO: Convert to command
        companyService.deleteCruiseCompany();
    }

    public void addTrainCompany()
    {
        // TODO: Convert to command
        companyService.addTrainCompany();
    }

    public void modifyTrainCompany()
    {
        // TODO: Convert to command
        companyService.modifyTrainCompany();
    }

    public void deleteTrainCompany()
    {
        // TODO: Convert to command
        companyService.deleteTrainCompany();
    }

    public void addAirport()
    {
        // TODO: Convert to command
        infrastructureService.addAirport();
    }

    public void modifyAirport()
    {
        // TODO: Convert to command
        infrastructureService.modifyAirport();
    }

    public void deleteAirport()
    {
        // TODO: Convert to command
        infrastructureService.deleteAirport();
    }

    public void addHarbor()
    {
        // TODO: Convert to command
        infrastructureService.addHarbor();
    }

    public void modifyHarbor()
    {
        // TODO: Convert to command
        infrastructureService.modifyHarbor();
    }

    public void deleteHarbor()
    {
        // TODO: Convert to command
        infrastructureService.deleteHarbor();
    }

    public void addTrainStation()
    {
        // TODO: Convert to command
        infrastructureService.addTrainStation();
    }

    public void modifyTrainStation()
    {
        // TODO: Convert to command
        infrastructureService.modifyTrainStation();
    }

    public void deleteTrainStation()
    {
        // TODO: Convert to command
        infrastructureService.deleteTrainStation();
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