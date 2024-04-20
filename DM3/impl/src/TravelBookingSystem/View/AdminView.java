package TravelBookingSystem.View;

import TravelBookingSystem.Console.ConsoleUtils;
import TravelBookingSystem.Controller.AdminController;
import TravelBookingSystem.TravelBookingDatabase;
import TravelBookingSystem.TravelBookingSystem;
import TravelBookingSystem.Menu.Menu;
import TravelBookingSystem.Menu.MenuActionItem;

public class AdminView implements View
{
    // TODO: Remove and replace with a DataExplorer using a visitor
    private final TravelBookingDatabase travelBookingDatabase;

    private final AdminController adminController;
    private final Menu adminMenu = new Menu("Main Menu");

    public AdminView(AdminController adminController, TravelBookingDatabase travelBookingDatabase)
    {
        this.travelBookingDatabase = travelBookingDatabase;
        this.adminController = adminController;
        initializeAdminMenu();
    }

    public void display()
    {
        adminMenu.select();
    }

    private void initializeAdminMenu()
    {
        adminMenu.addMenuComponent(makeManageCompaniesMenu());
        adminMenu.addMenuComponent(makeManageInfrastructuresMenu());
        adminMenu.addMenuComponent(makeManageTravelsMenu());
        adminMenu.addMenuComponent(makeManageTransportVehiclesMenu());
        adminMenu.addMenuComponent(makeDatabaseMenu());
        adminMenu.addMenuComponent(new MenuActionItem("Undo Last Operation", this::undo));
        adminMenu.addMenuComponent(new MenuActionItem("Exit", this::exit));
    }

    private Menu makeManageCompaniesMenu()
    {
        Menu manageCompaniesMenu = new Menu("Manage Companies", adminMenu);
        manageCompaniesMenu.addMenuComponent(makeManageAirportCompaniesMenu(manageCompaniesMenu));
        manageCompaniesMenu.addMenuComponent(makeManageCruiseCompaniesMenu(manageCompaniesMenu));
        manageCompaniesMenu.addMenuComponent(makeManageTrainCompaniesMenu(manageCompaniesMenu));
        return manageCompaniesMenu;
    }

    private Menu makeManageAirportCompaniesMenu(Menu manageCompaniesMenu)
    {
        Menu manageAirportCompaniesMenu = new Menu("Manage Airport Companies", manageCompaniesMenu);
        manageAirportCompaniesMenu.addMenuComponent(new MenuActionItem("Add", this::addAirportCompany));
        manageAirportCompaniesMenu.addMenuComponent(new MenuActionItem("Modify", this::modifyAirportCompany));
        manageAirportCompaniesMenu.addMenuComponent(new MenuActionItem("Delete", this::deleteAirportCompany));
        return manageAirportCompaniesMenu;
    }

    private Menu makeManageCruiseCompaniesMenu(Menu manageCompaniesMenu)
    {
        Menu manageCruiseCompaniesMenu = new Menu("Manage Cruise Companies", manageCompaniesMenu);
        manageCruiseCompaniesMenu.addMenuComponent(new MenuActionItem("Add", this::addCruiseCompany));
        manageCruiseCompaniesMenu.addMenuComponent(new MenuActionItem("Modify", this::modifyCruiseCompany));
        manageCruiseCompaniesMenu.addMenuComponent(new MenuActionItem("Delete", this::deleteCruiseCompany));
        return manageCruiseCompaniesMenu;
    }

    private Menu makeManageTrainCompaniesMenu(Menu manageCompaniesMenu)
    {
        Menu manageTrainCompaniesMenu = new Menu("Manage Train Companies", manageCompaniesMenu);
        manageTrainCompaniesMenu.addMenuComponent(new MenuActionItem("Add", this::addTrainCompany));
        manageTrainCompaniesMenu.addMenuComponent(new MenuActionItem("Modify", this::modifyTrainCompany));
        manageTrainCompaniesMenu.addMenuComponent(new MenuActionItem("Delete", this::deleteTrainCompany));
        return manageTrainCompaniesMenu;
    }

    private Menu makeManageInfrastructuresMenu() {
        Menu manageInfrastructuresMenu = new Menu("Manage Infrastructures", adminMenu);
        manageInfrastructuresMenu.addMenuComponent(makeManageAirportsMenu(manageInfrastructuresMenu));
        manageInfrastructuresMenu.addMenuComponent(makeManageHarborsMenu(manageInfrastructuresMenu));
        manageInfrastructuresMenu.addMenuComponent(makeManageTrainStationsMenu(manageInfrastructuresMenu));
        return manageInfrastructuresMenu;
    }

    private Menu makeManageAirportsMenu(Menu manageInfrastructuresMenu)
    {
        Menu manageAirportsMenu = new Menu("Manage Airports", manageInfrastructuresMenu);
        manageAirportsMenu.addMenuComponent(new MenuActionItem("Add", this::addAirport));
        manageAirportsMenu.addMenuComponent(new MenuActionItem("Modify", this::modifyAirport));
        manageAirportsMenu.addMenuComponent(new MenuActionItem("Delete", this::deleteAirport));
        return manageAirportsMenu;
    }

    private Menu makeManageHarborsMenu(Menu manageInfrastructuresMenu)
    {
        Menu manageHarborsMenu = new Menu("Manage Harbors", manageInfrastructuresMenu);
        manageHarborsMenu.addMenuComponent(new MenuActionItem("Add", this::addHarbor));
        manageHarborsMenu.addMenuComponent(new MenuActionItem("Modify", this::modifyHarbor));
        manageHarborsMenu.addMenuComponent(new MenuActionItem("Delete", this::deleteHarbor));
        return manageHarborsMenu;
    }

    private Menu makeManageTrainStationsMenu(Menu manageInfrastructuresMenu)
    {
        Menu manageTrainStationsMenu = new Menu("Manage Train Stations", manageInfrastructuresMenu);
        manageTrainStationsMenu.addMenuComponent(new MenuActionItem("Add", this::addTrainStation));
        manageTrainStationsMenu.addMenuComponent(new MenuActionItem("Modify", this::modifyTrainStation));
        manageTrainStationsMenu.addMenuComponent(new MenuActionItem("Delete", this::deleteTrainStation));
        return manageTrainStationsMenu;
    }

    private Menu makeManageTransportVehiclesMenu() {
        Menu manageTransportVehiclesMenu = new Menu("Manage Transport Vehicles", adminMenu);
        manageTransportVehiclesMenu.addMenuComponent(makeManageAirplanesMenu(manageTransportVehiclesMenu));
        manageTransportVehiclesMenu.addMenuComponent(makeManageCruisesShipsMenu(manageTransportVehiclesMenu));
        manageTransportVehiclesMenu.addMenuComponent(makeManageTrainsMenu(manageTransportVehiclesMenu));
        return manageTransportVehiclesMenu;
    }

    private Menu makeManageAirplanesMenu(Menu manageTransportVehiclesMenu)
    {
        Menu manageAirplanesMenu = new Menu("Manage Airplanes", manageTransportVehiclesMenu);
        manageAirplanesMenu.addMenuComponent(new MenuActionItem("Add", this::addAirplane));
        manageAirplanesMenu.addMenuComponent(new MenuActionItem("Modify", this::modifyAirplane));
        manageAirplanesMenu.addMenuComponent(new MenuActionItem("Delete", this::deleteAirplane));
        return manageAirplanesMenu;
    }

    private Menu makeManageCruisesShipsMenu(Menu manageTransportVehiclesMenu)
    {
        Menu manageCruiseShipsMenu = new Menu("Manage Cruise Ships", manageTransportVehiclesMenu);
        manageCruiseShipsMenu.addMenuComponent(new MenuActionItem("Add", this::addCruiseShip));
        manageCruiseShipsMenu.addMenuComponent(new MenuActionItem("Modify", this::modifyCruiseShip));
        manageCruiseShipsMenu.addMenuComponent(new MenuActionItem("Delete", this::deleteCruiseShip));
        return manageCruiseShipsMenu;
    }

    private Menu makeManageTrainsMenu(Menu manageTransportVehiclesMenu)
    {
        Menu manageTrainsMenu = new Menu("Manage Trains", manageTransportVehiclesMenu);
        manageTrainsMenu.addMenuComponent(new MenuActionItem("Add", this::addTrain));
        manageTrainsMenu.addMenuComponent(new MenuActionItem("Modify", this::modifyTrain));
        manageTrainsMenu.addMenuComponent(new MenuActionItem("Delete", this::deleteTrain));
        return manageTrainsMenu;
    }

    private Menu makeManageTravelsMenu() {
        Menu manageTravelsMenu = new Menu("Manage Travels", adminMenu);
        manageTravelsMenu.addMenuComponent(makeManageFlightsMenu(manageTravelsMenu));
        manageTravelsMenu.addMenuComponent(makeManageCruisesItinerariesMenu(manageTravelsMenu));
        manageTravelsMenu.addMenuComponent(makeManageTrainRoutesMenu(manageTravelsMenu));
        return manageTravelsMenu;
    }

    private Menu makeManageFlightsMenu(Menu manageTravelsMenu)
    {
        Menu manageFlightsMenu = new Menu("Manage Flights", manageTravelsMenu);
        manageFlightsMenu.addMenuComponent(new MenuActionItem("Add", this::addFlight));
        manageFlightsMenu.addMenuComponent(new MenuActionItem("Modify", this::modifyFlight));
        manageFlightsMenu.addMenuComponent(new MenuActionItem("Delete", this::deleteFlight));
        return manageFlightsMenu;
    }

    private Menu makeManageCruisesItinerariesMenu(Menu manageTravelsMenu)
    {
        Menu manageCruisesItinerariesMenu = new Menu("Manage Cruises Itineraries", manageTravelsMenu);
        manageCruisesItinerariesMenu.addMenuComponent(new MenuActionItem("Add", this::addCruiseItinerary));
        manageCruisesItinerariesMenu.addMenuComponent(new MenuActionItem("Modify", this::modifyCruiseItinerary));
        manageCruisesItinerariesMenu.addMenuComponent(new MenuActionItem("Delete", this::deleteCruiseItinerary));
        return manageCruisesItinerariesMenu;
    }

    private Menu makeManageTrainRoutesMenu(Menu manageTravelsMenu)
    {
        Menu manageTrainRoutesMenu = new Menu("Manage Train Routes", manageTravelsMenu);
        manageTrainRoutesMenu.addMenuComponent(new MenuActionItem("Add", this::addTrainRoute));
        manageTrainRoutesMenu.addMenuComponent(new MenuActionItem("Modify", this::modifyTrainRoute));
        manageTrainRoutesMenu.addMenuComponent(new MenuActionItem("Delete", this::deleteTrainRoute));
        return manageTrainRoutesMenu;
    }

    private Menu makeDatabaseMenu()
    {
        Menu databaseMenu = new Menu("Manage Database", adminMenu);
        databaseMenu.addMenuComponent(makeCheckDatabaseMenu(databaseMenu));
        databaseMenu.addMenuComponent(new MenuActionItem("Clear Database", travelBookingDatabase::clearDatabase));
        return databaseMenu;
    }

    private Menu makeCheckDatabaseMenu(Menu databaseMenu)
    {
        Menu checkDatabaseMenu = new Menu("Explore Data", databaseMenu);
        checkDatabaseMenu.addMenuComponent(new MenuActionItem("Airport Companies", this::printAllAirportCompanies));
        checkDatabaseMenu.addMenuComponent(new MenuActionItem("Cruise Companies", this::printAllCruiseCompanies));
        checkDatabaseMenu.addMenuComponent(new MenuActionItem("Train Companies", this::printAllTrainCompanies));
        checkDatabaseMenu.addMenuComponent(new MenuActionItem("Airports", this::printAllAirports));
        checkDatabaseMenu.addMenuComponent(new MenuActionItem("Harbors", this::printAllHarbors));
        checkDatabaseMenu.addMenuComponent(new MenuActionItem("Train Stations", this::printAllTrainStations));
        checkDatabaseMenu.addMenuComponent(new MenuActionItem("Flights", this::printAllFlights));
        checkDatabaseMenu.addMenuComponent(new MenuActionItem("Cruise Itineraries", this::printAllCruiseItineraries));
        checkDatabaseMenu.addMenuComponent(new MenuActionItem("Train Routes", this::printAllTrainRoutes));
        checkDatabaseMenu.addMenuComponent(new MenuActionItem("Airplanes", this::printAllAirplanes));
        checkDatabaseMenu.addMenuComponent(new MenuActionItem("Cruise Ships", this::printAllCruiseShips));
        checkDatabaseMenu.addMenuComponent(new MenuActionItem("Trains", this::printAllTrains));
        return checkDatabaseMenu;
    }

    private void exit()
    {
        TravelBookingSystem.getInstance().exit();
    }

    private void undo()
    {
        adminController.undo();
    }

    private void addAirportCompany()
    {
        adminController.addAirportCompany();
    }

    private void modifyAirportCompany()
    {
        adminController.modifyAirportCompany();
    }

    private void deleteAirportCompany()
    {
        adminController.deleteAirportCompany();
    }

    private void addCruiseCompany()
    {
        adminController.addCruiseCompany();
    }

    private void modifyCruiseCompany()
    {
        adminController.modifyCruiseCompany();
    }

    private void deleteCruiseCompany()
    {
        adminController.deleteCruiseCompany();
    }

    private void addTrainCompany()
    {
        adminController.addTrainCompany();
    }

    private void modifyTrainCompany()
    {
        adminController.modifyTrainCompany();
    }

    private void deleteTrainCompany()
    {
        adminController.deleteTrainCompany();
    }

    private void addAirport()
    {
        adminController.addAirport();
    }

    private void modifyAirport()
    {
        adminController.modifyAirport();
    }

    private void deleteAirport()
    {
        adminController.deleteAirport();
    }

    private void addHarbor()
    {
        adminController.addHarbor();
    }

    private void modifyHarbor()
    {
        adminController.modifyHarbor();
    }

    private void deleteHarbor()
    {
        adminController.deleteHarbor();
    }

    private void addTrainStation()
    {
        adminController.addTrainStation();
    }

    private void modifyTrainStation()
    {
        adminController.modifyTrainStation();
    }

    private void deleteTrainStation()
    {
        adminController.deleteTrainStation();
    }

    private void addFlight()
    {
        adminController.addFlight();
    }

    private void modifyFlight()
    {
        adminController.modifyFlight();
    }

    private void deleteFlight()
    {
        adminController.deleteFlight();
    }

    private void addCruiseItinerary()
    {
        adminController.addCruiseItinerary();
    }

    private void modifyCruiseItinerary()
    {
        adminController.modifyCruiseItinerary();
    }

    private void deleteCruiseItinerary()
    {
        adminController.deleteCruiseItinerary();
    }

    private void addTrainRoute()
    {
        adminController.addTrainRoute();
    }

    private void modifyTrainRoute()
    {
        adminController.modifyTrainRoute();
    }

    private void deleteTrainRoute()
    {
        adminController.deleteTrainRoute();
    }

    private void addAirplane()
    {
        adminController.addAirplane();
    }

    private void modifyAirplane()
    {
        adminController.modifyAirplane();
    }

    private void deleteAirplane()
    {
        adminController.deleteAirplane();
    }

    private void addCruiseShip()
    {
        adminController.addCruiseShip();
    }

    private void modifyCruiseShip()
    {
        adminController.modifyCruiseShip();
    }

    private void deleteCruiseShip()
    {
        adminController.deleteCruiseShip();
    }

    private void addTrain()
    {
        adminController.addTrain();
    }

    private void modifyTrain()
    {
        adminController.modifyTrain();
    }

    private void deleteTrain()
    {
        adminController.deleteTrain();
    }

    private void printAllAirportCompanies()
    {
        ConsoleUtils.printAllElements(travelBookingDatabase.getAllAirportCompanies());
        ConsoleUtils.WaitForInput();
    }

    private void printAllCruiseCompanies()
    {
        ConsoleUtils.printAllElements(travelBookingDatabase.getAllCruiseCompanies());
        ConsoleUtils.WaitForInput();
    }

    private void printAllTrainCompanies()
    {
        ConsoleUtils.printAllElements(travelBookingDatabase.getAllTrainCompanies());
        ConsoleUtils.WaitForInput();
    }

    private void printAllAirports()
    {
        ConsoleUtils.printAllElements(travelBookingDatabase.getAllAirports());
        ConsoleUtils.WaitForInput();
    }

    private void printAllHarbors()
    {
        ConsoleUtils.printAllElements(travelBookingDatabase.getAllHarbors());
        ConsoleUtils.WaitForInput();
    }

    private void printAllTrainStations()
    {
        ConsoleUtils.printAllElements(travelBookingDatabase.getAllTrainStations());
        ConsoleUtils.WaitForInput();
    }

    private void printAllFlights()
    {
        ConsoleUtils.printAllElements(travelBookingDatabase.getAllFlights());
        ConsoleUtils.WaitForInput();
    }

    private void printAllCruiseItineraries()
    {
        ConsoleUtils.printAllElements(travelBookingDatabase.getAllCruiseItineraries());
        ConsoleUtils.WaitForInput();
    }

    private void printAllTrainRoutes()
    {
        ConsoleUtils.printAllElements(travelBookingDatabase.getAllTrainRoutes());
        ConsoleUtils.WaitForInput();
    }

    private void printAllAirplanes()
    {
        ConsoleUtils.printAllElements(travelBookingDatabase.getAllAirplanes());
        ConsoleUtils.WaitForInput();
    }

    private void printAllCruiseShips()
    {
        ConsoleUtils.printAllElements(travelBookingDatabase.getAllCruiseShips());
        ConsoleUtils.WaitForInput();
    }

    private void printAllTrains()
    {
        ConsoleUtils.printAllElements(travelBookingDatabase.getAllTrains());
        ConsoleUtils.WaitForInput();
    }
}