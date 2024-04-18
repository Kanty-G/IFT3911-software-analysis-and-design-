package TravelBookingSystem.Vehicle;

public abstract class TravelSpace
{
    private String id;
    private double price;
    private TravelSpaceState state = new Available();

    public void reserve()
    {
        // TODO - implement TravelSpace.reserver
        throw new UnsupportedOperationException();
    }

    public void confirm()
    {
        // TODO - implement TravelSpace.confirmer
        throw new UnsupportedOperationException();
    }

    public void cancel()
    {
        // TODO - implement TravelSpace.annuler
        throw new UnsupportedOperationException();
    }

}