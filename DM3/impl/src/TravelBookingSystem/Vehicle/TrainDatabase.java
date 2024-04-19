package TravelBookingSystem.Vehicle;

import java.util.Enumeration;

public interface TrainDatabase
{
    void addTrain(Train train);
    Train replaceTrain(Train train);
    Train removeTrain(String id);
    Train getTrain(String id);
    Enumeration<Train> getAllTrains();
}
