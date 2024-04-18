package TravelBookingSystem.Company;

import java.util.Enumeration;

public interface TrainCompanyDatabase
{
    void AddTrainCompany(TrainCompany trainCompany);
    void SetTrainCompany(TrainCompany trainCompany);
    TrainCompany RemoveTrainCompany(String id);
    TrainCompany GetTrainCompany(String id);
    Enumeration<TrainCompany> GetAllTrainCompanies();
}
