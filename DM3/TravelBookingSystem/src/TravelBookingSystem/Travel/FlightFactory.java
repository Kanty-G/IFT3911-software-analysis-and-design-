package TravelBookingSystem.Travel;

public class FlightFactory implements TravelFactory
{
    private static FlightFactory instance;

    public static FlightFactory getInstance()
    {
        if (instance == null)
        {
            instance = new FlightFactory();
        }

        return instance;
    }

    public Flight createTravel()
    {
        return new Flight();
    }
}
