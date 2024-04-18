public class TravelBookingSystem
{
    BaseDeDonnees baseDeDonnees;
    VueClient vueClient;
    VueAdmin vueAdmin;

    public void Start()
    {
        baseDeDonnees = new BaseDeDonnees();
        vueClient = new VueClient();
        vueAdmin = new VueAdmin();

        // TODO: Add initialization of base de donnee
        baseDeDonnees.addObserver(vueClient);
        baseDeDonnees.addObserver(vueAdmin);
    }
}