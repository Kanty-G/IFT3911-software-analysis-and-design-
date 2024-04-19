package TravelBookingSystem.Travel;

import java.util.Enumeration;

public interface TrainRouteDatabase
{
    void addTrainRoute(TrainRoute trainRoute);
    TrainRoute replaceTrainRoute(TrainRoute trainRoute);
    TrainRoute removeTrainRoute(String id);
    TrainRoute getTrainRoute(String id);
    Enumeration<TrainRoute> getAllTrainRoutes();
}
