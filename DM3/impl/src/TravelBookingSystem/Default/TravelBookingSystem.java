package TravelBookingSystem.Default;

import TravelBookingSystem.Database.TravelBookingDatabase;

public class TravelBookingSystem
{
    TravelBookingDatabase database;

    ClientView vueClient;
    AdminView vueAdmin;

    ClientController clientController;
    AdminController adminController;

    public void Start()
    {
        database = new TravelBookingDatabase();
        vueClient = new ClientView(clientController);
        vueAdmin = new AdminView(adminController);

        database.LoadDatabase();

        // TODO: Add observers
        //database.addObserver(vueClient);
        //database.addObserver(vueAdmin);

        // TODO: Add login to client of admin
        // TODO: Display the selected view
        vueAdmin.displayLogin();
    }
}