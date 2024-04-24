package TravelBookingSystem.Travel;

public class TrainRouteFactory implements TravelFactory
{
    private static TrainRouteFactory instance;

    public static TrainRouteFactory getInstance()
    {
        if (instance == null)
        {
            instance = new TrainRouteFactory();
        }

        return instance;
    }

    public TrainRoute createTravel()
    {
        return new TrainRoute();
    }
}
