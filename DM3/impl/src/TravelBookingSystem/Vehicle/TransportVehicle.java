package TravelBookingSystem.Vehicle;

public abstract class TransportVehicle
{
    private String id;
    private int numberOfColumn;
    private int numberOfRow;

    public String getId()
    {
        return id;
    }

    public int getNumberOfColumn()
    {
        return numberOfColumn;
    }

    public int getNumberOfRow()
    {
        return numberOfRow;
    }
}