package TravelBookingSystem.View;

import TravelBookingSystem.Controller.ClientController;
import TravelBookingSystem.Default.Observer;
import TravelBookingSystem.TravelBookingSystem;
import TravelBookingSystem.Menu.Menu;
import TravelBookingSystem.Menu.MenuActionItem;

public class ClientView extends Observer implements View
{
    private final ClientController clientController;
    private final Menu clientMenu = new Menu("Main Menu");

    public ClientView(ClientController clientController)
    {
        this.clientController = clientController;
        initializeClientMenu();
    }

    public void display()
    {
        clientMenu.select();
    }

    private void initializeClientMenu()
    {
        clientMenu.addMenuComponent(makeCheckAvailableTravelsMenu());
        clientMenu.addMenuComponent(makeReservationMenu());
        clientMenu.addMenuComponent(new MenuActionItem("Make A Payment", this::makePayment));
        clientMenu.addMenuComponent(new MenuActionItem("Exit", this::exit));
    }

    private Menu makeCheckAvailableTravelsMenu()
    {
        Menu checkMenu = new Menu("Check Available Travels", clientMenu);
        checkMenu.addMenuComponent(new MenuActionItem("Flights", this::checkFlights));
        checkMenu.addMenuComponent(new MenuActionItem("Cruises", this::checkCruises));
        checkMenu.addMenuComponent(new MenuActionItem("Train Routes", this::checkTrainRoutes));
        return checkMenu;
    }

    private Menu makeReservationMenu()
    {
        Menu reservationMenu = new Menu("Make A Reservation", clientMenu);
        reservationMenu.addMenuComponent(new MenuActionItem("Flights", this::reserveFlight));
        reservationMenu.addMenuComponent(new MenuActionItem("Cruises", this::reserveCruise));
        reservationMenu.addMenuComponent(new MenuActionItem("Train Routes", this::reserveTrainRoute));
        return reservationMenu;
    }

    private void exit()
    {
        TravelBookingSystem.getInstance().exit();
    }

    private void makePayment()
    {
        clientController.makePayment();
    }

    private void checkFlights()
    {
        clientController.checkFlights();
    }

    private void checkCruises()
    {
        clientController.checkCruises();
    }

    private void checkTrainRoutes()
    {
        clientController.checkTrainRoutes();
    }

    private void reserveFlight()
    {
        clientController.reserveFlight();
    }

    private void reserveCruise()
    {
        clientController.reserveCruise();
    }

    private void reserveTrainRoute()
    {
        clientController.reserveTrainRoute();
    }
}