package TravelBookingSystem.View;

import TravelBookingSystem.Controller.LoginController;
import TravelBookingSystem.TravelBookingSystem;
import TravelBookingSystem.Menu.Menu;
import TravelBookingSystem.Menu.MenuActionItem;

public class LoginView implements View
{
    private final LoginController loginController;
    private final Menu loginMenu = new Menu("Log In Menu");

    public LoginView(LoginController loginController)
    {
        this.loginController = loginController;
        initializeLogInMenu();
    }

    public void update()
    {
        // This would be used in a GUI
    }

    public void display()
    {
        loginMenu.select();
    }

    private void initializeLogInMenu()
    {
        loginMenu.addMenuComponent(new MenuActionItem("Client", this::loginClient));
        loginMenu.addMenuComponent(new MenuActionItem("Admin", this::loginAdmin));
    }

    private void loginClient()
    {
        TravelBookingSystem.getInstance().openClientView();
    }

    private void loginAdmin()
    {
        if (loginController.loginAdmin())
        {
            TravelBookingSystem.getInstance().openAdminView();
        }
    }

    private void createAdmin()
    {
        loginController.createAdmin();
    }
}
