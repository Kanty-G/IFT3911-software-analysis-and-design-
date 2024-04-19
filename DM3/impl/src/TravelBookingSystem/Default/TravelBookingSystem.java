package TravelBookingSystem.Default;

import TravelBookingSystem.Database.TravelBookingDatabase;
import TravelBookingSystem.User.UserController;
import TravelBookingSystem.View.AdminView;
import TravelBookingSystem.View.ClientView;
import TravelBookingSystem.View.LoginView;
import TravelBookingSystem.View.View;

public class TravelBookingSystem
{
    private static TravelBookingSystem instance;

    private TravelBookingDatabase database;

    private View focusedView;

    private LoginView loginView;
    private ClientView clientView;
    private AdminView adminView;

    private UserController userController;
    private ClientController clientController;
    private AdminController adminController;

    public static TravelBookingSystem getInstance()
    {
        if (instance == null)
        {
            instance = new TravelBookingSystem();
        }

        return instance;
    }

    public void Start()
    {
        InitializeDatabase();
        InitializeControllers();
        InitializeViews();
    }

    public void displayFocusedView()
    {
        focusedView.display();
    }

    public void openLoggingView()
    {
        focusedView = loginView;
        focusedView.display();
    }

    public void openClientView()
    {
        focusedView = clientView;
        focusedView.display();
    }

    public void openAdminView()
    {
        focusedView = adminView;
        focusedView.display();
    }

    public void exit()
    {
        database.saveDatabase();
        System.exit(0);
    }

    private void InitializeDatabase()
    {
        database = new TravelBookingDatabase();
        database.loadDatabase();
        // TODO: Add observers
    }

    private void InitializeControllers()
    {
        userController = new UserController();
        clientController = new ClientController();
        adminController = new AdminController();
    }

    private void InitializeViews()
    {
        loginView = new LoginView(userController);
        clientView = new ClientView(clientController);
        adminView = new AdminView(adminController);
        focusedView = loginView;
        focusedView.display();
    }
}