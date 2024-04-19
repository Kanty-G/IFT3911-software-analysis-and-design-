package TravelBookingSystem.View;

import TravelBookingSystem.Controller.AdminController;
import TravelBookingSystem.Default.Observer;
import TravelBookingSystem.TravelBookingSystem;
import TravelBookingSystem.Menu.Menu;
import TravelBookingSystem.Menu.MenuActionItem;

public class AdminView extends Observer implements View
{
    private final AdminController adminController;
    private final Menu adminMenu = new Menu("Main Menu");

    public AdminView(AdminController adminController)
    {
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
}