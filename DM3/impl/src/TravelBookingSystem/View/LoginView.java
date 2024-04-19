package TravelBookingSystem.View;

import TravelBookingSystem.Default.TravelBookingSystem;
import TravelBookingSystem.Menu.Menu;
import TravelBookingSystem.Menu.MenuActionItem;
import TravelBookingSystem.User.UserController;

public class LoginView implements View
{
    private final UserController userController;
    private final Menu logInMenu = new Menu("Log In Menu");

    public LoginView(UserController userController)
    {
        this.userController = userController;
        InitializeLogInMenu();
    }

    public void display()
    {
        logInMenu.select();
    }

    private void loginAdmin()
    {
        if (userController.loginAdmin())
        {
            TravelBookingSystem.getInstance().openAdminView();
        }

        TravelBookingSystem.getInstance().openLoggingView();
    }

    private void createAdmin()
    {
        userController.createAdmin();
    }

    private void InitializeLogInMenu()
    {
        logInMenu.AddMenuItem(new MenuActionItem("Client", TravelBookingSystem.getInstance()::openClientView));
        logInMenu.AddMenuItem(MakeAdminMenu());
    }

    private Menu MakeAdminMenu()
    {
        Menu adminMenu = new Menu("Admin", logInMenu);
        adminMenu.AddMenuItem(new MenuActionItem("Log In", this::loginAdmin));
        adminMenu.AddMenuItem(new MenuActionItem("New Admin", this::createAdmin));
        return adminMenu;
    }
}
