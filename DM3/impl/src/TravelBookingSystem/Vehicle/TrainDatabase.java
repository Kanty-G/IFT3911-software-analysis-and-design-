package TravelBookingSystem.Vehicle;

import java.util.Enumeration;

public interface TrainDatabase
{
    void AddTrain(Train train);
    void SetTrain(Train train);
    Train RemoveTrain(String id);
    Train GetTrain(String id);
    Enumeration<Train> GetAllTrains();
}
