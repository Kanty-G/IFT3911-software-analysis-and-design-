package TravelBookingSystem.Infrastructure;

public class Infrastructure
{
    private final String id;
    private final String city;

    public Infrastructure(String id, String city)
    {
        this.id = id;
        this.city = city;
    }

    public String getId()
    {
        return id;
    }
    public String getCity() { return city; }
}