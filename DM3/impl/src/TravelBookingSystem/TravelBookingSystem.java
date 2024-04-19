package TravelBookingSystem;

import TravelBookingSystem.Company.CompanyService;
import TravelBookingSystem.Controller.AdminController;
import TravelBookingSystem.Controller.ClientController;
import TravelBookingSystem.Controller.LoginController;
import TravelBookingSystem.Database.TravelBookingDatabase;
import TravelBookingSystem.Infrastructure.InfrastructureService;
import TravelBookingSystem.Payment.PaymentService;
import TravelBookingSystem.Reservation.ReservationService;
import TravelBookingSystem.Travel.TravelService;
import TravelBookingSystem.Vehicle.TransportVehicleService;
import TravelBookingSystem.View.AdminView;
import TravelBookingSystem.View.ClientView;
import TravelBookingSystem.View.LoginView;
import TravelBookingSystem.View.View;

public class TravelBookingSystem
{
    private static TravelBookingSystem instance;

    private TravelBookingDatabase database;

    private CompanyService companyService;
    private InfrastructureService infrastructureService;
    private TransportVehicleService transportVehicleService;
    private TravelService travelService;
    private PaymentService paymentService;
    private ReservationService reservationService;

    private LoginController loginController;
    private ClientController clientController;
    private AdminController adminController;

    private LoginView loginView;
    private ClientView clientView;
    private AdminView adminView;

    private View focusedView;

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
        initializeServices();
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

    private void initializeServices()
    {
        companyService = new CompanyService(database);
        infrastructureService = new InfrastructureService(database);
        transportVehicleService = new TransportVehicleService(database);
        travelService = new TravelService(database);
        paymentService = new PaymentService();
        reservationService = new ReservationService();
    }

    private void initializeControllers()
    {
        loginController = new LoginController();
        clientController = new ClientController(paymentService, reservationService, database);
        adminController = new AdminController(companyService, infrastructureService, transportVehicleService, travelService);
    }

    private void initializeViews()
    {
        loginView = new LoginView(loginController);
        clientView = new ClientView(clientController);
        adminView = new AdminView(adminController, database);
        focusedView = loginView;
        focusedView.display();
    }
}