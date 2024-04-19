package TravelBookingSystem;

import TravelBookingSystem.Controller.AdminController;
import TravelBookingSystem.Controller.ClientController;
import TravelBookingSystem.Controller.LoginController;
import TravelBookingSystem.Database.TravelBookingDatabase;
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

    private LoginController loginController;
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
        initializeDatabase();
        initializeControllers();
        initializeViews();

        while(true)
        {
            focusedView.display();
        }
    }

    public void openLoggingView()
    {
        focusedView = loginView;
    }

    public void openClientView()
    {
        focusedView = clientView;
    }

    public void openAdminView()
    {
        focusedView = adminView;
    }

    public void exit()
    {
        database.saveDatabase();
        System.exit(0);
    }

    private void initializeDatabase()
    {
        database = new TravelBookingDatabase();
        database.loadDatabase();
        // TODO: Add observers
    }

    private void initializeControllers()
    {
        loginController = new LoginController();
        clientController = new ClientController();
        adminController = new AdminController();
    }

    private void initializeViews()
    {
        loginView = new LoginView(loginController);
        clientView = new ClientView(clientController);
        adminView = new AdminView(adminController);
        focusedView = loginView;
        focusedView.display();
    }
}