package TravelBookingSystem.View;

import TravelBookingSystem.Default.ClientController;
import TravelBookingSystem.Default.Observer;
import TravelBookingSystem.Default.TravelBookingSystem;
import TravelBookingSystem.Menu.Menu;
import TravelBookingSystem.Menu.MenuActionItem;

public class ClientView extends Observer implements View
{
    private final ClientController clientController;
    private final Menu clientMenu = new Menu("Main Menu");

    public ClientView(ClientController clientController)
    {
        this.clientController = clientController;
        InitializeClientMenu();
    }

    public void display()
    {
        clientMenu.select();
    }

    private void InitializeClientMenu()
    {
        clientMenu.AddMenuItem(MakeCheckAvailableTravelsMenu());
        clientMenu.AddMenuItem(MakeReservationMenu());
        clientMenu.AddMenuItem(new MenuActionItem("Make A Payment", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        clientMenu.AddMenuItem(new MenuActionItem("Exit", TravelBookingSystem.getInstance()::exit));
    }

    private Menu MakeCheckAvailableTravelsMenu()
    {
        Menu checkMenu = new Menu("Check Available Travels", clientMenu);
        checkMenu.AddMenuItem(new MenuActionItem("Flights", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        checkMenu.AddMenuItem(new MenuActionItem("Cruises", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        checkMenu.AddMenuItem(new MenuActionItem("Train Routes", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        return checkMenu;
    }

    private Menu MakeReservationMenu()
    {
        Menu reservationMenu = new Menu("Make A Reservation", clientMenu);
        reservationMenu.AddMenuItem(new MenuActionItem("Flights", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        reservationMenu.AddMenuItem(new MenuActionItem("Cruises", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        reservationMenu.AddMenuItem(new MenuActionItem("Train Routes", TravelBookingSystem.getInstance()::displayFocusedView)); // TODO: Route to client controller
        return reservationMenu;
    }
}