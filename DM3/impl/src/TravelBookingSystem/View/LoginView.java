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

    public void display()
    {
        loginMenu.select();
    }

    private void initializeLogInMenu()
    {
        loginMenu.addMenuComponent(new MenuActionItem("Client", this::loginClient));
        loginMenu.addMenuComponent(makeAdminMenu());
    }

    private Menu makeAdminMenu()
    {
        Menu adminMenu = new Menu("Admin", loginMenu);
        adminMenu.addMenuComponent(new MenuActionItem("Log In", this::loginAdmin));
        adminMenu.addMenuComponent(new MenuActionItem("New Admin", this::createAdmin));
        return adminMenu;
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
