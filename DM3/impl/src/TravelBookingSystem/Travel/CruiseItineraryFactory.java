package TravelBookingSystem.Travel;

public class CruiseItineraryFactory implements TravelFactory
{
    private static CruiseItineraryFactory instance;

    public static CruiseItineraryFactory getInstance()
    {
        if (instance == null)
        {
            instance = new CruiseItineraryFactory();
        }

        return instance;
    }

    public CruiseItinerary createTravel()
    {
        return new CruiseItinerary();
    }
}
