package TravelBookingSystem.Database;

import TravelBookingSystem.Default.TrainCompany;

import java.util.Enumeration;

public interface TrainCompanyDatabase
{
    void AddTrainCompany(TrainCompany trainCompany);
    void SetTrainCompany(TrainCompany trainCompany);
    TrainCompany RemoveTrainCompany(String id);
    TrainCompany GetTrainCompany(String id);
    Enumeration<TrainCompany> GetAllTrainCompanies();
}
