package TravelBookingSystem.View;

import TravelBookingSystem.Default.AdminController;
import TravelBookingSystem.Default.Observer;
import TravelBookingSystem.Default.TravelBookingSystem;
import TravelBookingSystem.Menu.Menu;
import TravelBookingSystem.Menu.MenuActionItem;

public class AdminView extends Observer implements View
{
    private final AdminController adminController;
    private final Menu adminMenu = new Menu("Main Menu");

    public AdminView(AdminController adminController)
    {
        this.adminController = adminController;
        InitializeAdminMenu();
    }

    public void display()
    {
        adminMenu.select();
    }

    private void InitializeAdminMenu()
    {
        adminMenu.AddMenuItem(MakeManageCompaniesMenu());
        adminMenu.AddMenuItem(MakeManageInfrastructuresMenu());
        adminMenu.AddMenuItem(MakeManageTravelsMenu());
        adminMenu.AddMenuItem(new MenuActionItem("Exit", TravelBookingSystem.getInstance()::exit));
    }

    private Menu MakeManageCompaniesMenu()
    {
        Menu manageCompaniesMenu = new Menu("Manage Companies", adminMenu);
        manageCompaniesMenu.AddMenuItem(MakeManageAirportCompaniesMenu(manageCompaniesMenu));
        manageCompaniesMenu.AddMenuItem(MakeManageCruiseCompaniesMenu(manageCompaniesMenu));
        manageCompaniesMenu.AddMenuItem(MakeManageTrainCompaniesMenu(manageCompaniesMenu));
        return manageCompaniesMenu;
    }

    private Menu MakeManageAirportCompaniesMenu(Menu manageCompaniesMenu)
    {
        Menu manageAirportCompaniesMenu = new Menu("Manage Airport Companies", manageCompaniesMenu);
        manageAirportCompaniesMenu.AddMenuItem(new MenuActionItem("Add", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageAirportCompaniesMenu.AddMenuItem(new MenuActionItem("Modify", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageAirportCompaniesMenu.AddMenuItem(new MenuActionItem("Delete", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        return manageAirportCompaniesMenu;
    }

    private Menu MakeManageCruiseCompaniesMenu(Menu manageCompaniesMenu)
    {
        Menu manageCruiseCompaniesMenu = new Menu("Manage Cruise Companies", manageCompaniesMenu);
        manageCruiseCompaniesMenu.AddMenuItem(new MenuActionItem("Add", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageCruiseCompaniesMenu.AddMenuItem(new MenuActionItem("Modify", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageCruiseCompaniesMenu.AddMenuItem(new MenuActionItem("Delete", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        return manageCruiseCompaniesMenu;
    }

    private Menu MakeManageTrainCompaniesMenu(Menu manageCompaniesMenu)
    {
        Menu manageTrainCompaniesMenu = new Menu("Manage Train Companies", manageCompaniesMenu);
        manageTrainCompaniesMenu.AddMenuItem(new MenuActionItem("Add", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageTrainCompaniesMenu.AddMenuItem(new MenuActionItem("Modify", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageTrainCompaniesMenu.AddMenuItem(new MenuActionItem("Delete", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        return manageTrainCompaniesMenu;
    }

    private Menu MakeManageInfrastructuresMenu() {
        Menu manageInfrastructuresMenu = new Menu("Manage Infrastructures", adminMenu);
        manageInfrastructuresMenu.AddMenuItem(MakeManageAirportsMenu(manageInfrastructuresMenu));
        manageInfrastructuresMenu.AddMenuItem(MakeManageHarborsMenu(manageInfrastructuresMenu));
        manageInfrastructuresMenu.AddMenuItem(MakeManageTrainStationsMenu(manageInfrastructuresMenu));
        return manageInfrastructuresMenu;
    }

    private Menu MakeManageAirportsMenu(Menu manageInfrastructuresMenu)
    {
        Menu manageAirportsMenu = new Menu("Manage Airports", manageInfrastructuresMenu);
        manageAirportsMenu.AddMenuItem(new MenuActionItem("Add", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageAirportsMenu.AddMenuItem(new MenuActionItem("Modify", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageAirportsMenu.AddMenuItem(new MenuActionItem("Delete", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        return manageAirportsMenu;
    }

    private Menu MakeManageHarborsMenu(Menu manageInfrastructuresMenu)
    {
        Menu manageHarborsMenu = new Menu("Manage Harbors", manageInfrastructuresMenu);
        manageHarborsMenu.AddMenuItem(new MenuActionItem("Add", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageHarborsMenu.AddMenuItem(new MenuActionItem("Modify", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageHarborsMenu.AddMenuItem(new MenuActionItem("Delete", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        return manageHarborsMenu;
    }

    private Menu MakeManageTrainStationsMenu(Menu manageInfrastructuresMenu)
    {
        Menu manageTrainStationsMenu = new Menu("Manage Train Stations", manageInfrastructuresMenu);
        manageTrainStationsMenu.AddMenuItem(new MenuActionItem("Add", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageTrainStationsMenu.AddMenuItem(new MenuActionItem("Modify", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageTrainStationsMenu.AddMenuItem(new MenuActionItem("Delete", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        return manageTrainStationsMenu;
    }

    private Menu MakeManageTravelsMenu() {
        Menu manageTravelsMenu = new Menu("Manage Travels", adminMenu);
        manageTravelsMenu.AddMenuItem(MakeManageFlightsMenu(manageTravelsMenu));
        manageTravelsMenu.AddMenuItem(MakeManageCruisesItinerariesMenu(manageTravelsMenu));
        manageTravelsMenu.AddMenuItem(MakeManageTrainRoutesMenu(manageTravelsMenu));
        return manageTravelsMenu;
    }

    private Menu MakeManageFlightsMenu(Menu manageTravelsMenu)
    {
        Menu manageFlightsMenu = new Menu("Manage Flights", manageTravelsMenu);
        manageFlightsMenu.AddMenuItem(new MenuActionItem("Add", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageFlightsMenu.AddMenuItem(new MenuActionItem("Modify", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageFlightsMenu.AddMenuItem(new MenuActionItem("Delete", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        return manageFlightsMenu;
    }

    private Menu MakeManageCruisesItinerariesMenu(Menu manageTravelsMenu)
    {
        Menu manageCruisesItinerariesMenu = new Menu("Manage Cruises Itineraries", manageTravelsMenu);
        manageCruisesItinerariesMenu.AddMenuItem(new MenuActionItem("Add", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageCruisesItinerariesMenu.AddMenuItem(new MenuActionItem("Modify", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageCruisesItinerariesMenu.AddMenuItem(new MenuActionItem("Delete", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        return manageCruisesItinerariesMenu;
    }

    private Menu MakeManageTrainRoutesMenu(Menu manageTravelsMenu)
    {
        Menu manageTrainRoutesMenu = new Menu("Manage Train Routes", manageTravelsMenu);
        manageTrainRoutesMenu.AddMenuItem(new MenuActionItem("Add", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageTrainRoutesMenu.AddMenuItem(new MenuActionItem("Modify", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        manageTrainRoutesMenu.AddMenuItem(new MenuActionItem("Delete", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        return manageTrainRoutesMenu;
    }
}