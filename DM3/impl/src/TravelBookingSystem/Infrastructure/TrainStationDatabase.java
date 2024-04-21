package TravelBookingSystem.Infrastructure;

import java.util.Enumeration;

public interface TrainStationDatabase
{
    void addTrainStation(TrainStation trainStation);
    TrainStation removeTrainStation(String id);
    TrainStation getTrainStation(String id);
    Enumeration<TrainStation> getAllTrainStations();
}
