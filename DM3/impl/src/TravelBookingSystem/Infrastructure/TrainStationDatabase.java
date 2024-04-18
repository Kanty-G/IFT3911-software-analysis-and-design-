package TravelBookingSystem.Infrastructure;

import java.util.Enumeration;

public interface TrainStationDatabase
{
    void AddTrainStation(TrainStation trainStation);
    void SetTrainStation(TrainStation trainStation);
    TrainStation RemoveTrainStation(String id);
    TrainStation GetTrainStation(String id);
    Enumeration<TrainStation> GetAllTrainStations();
}
