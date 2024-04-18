package TravelBookingSystem.Database;

import TravelBookingSystem.Default.TrainRoute;

import java.util.Enumeration;

public interface TrainRouteDatabase
{
    void AddTrainRoute(TrainRoute trainRoute);
    void SetTrainRoute(TrainRoute trainRoute);
    TrainRoute RemoveTrainRoute(String id);
    TrainRoute GetTrainRoute(String id);
    Enumeration<TrainRoute> GetAllTrainRoutes();
}
