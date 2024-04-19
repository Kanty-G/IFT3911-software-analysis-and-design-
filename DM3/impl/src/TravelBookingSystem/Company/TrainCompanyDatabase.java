package TravelBookingSystem.Company;

import java.util.Enumeration;

public interface TrainCompanyDatabase
{
    void addTrainCompany(TrainCompany trainCompany);
    TrainCompany replaceTrainCompany(TrainCompany trainCompany);
    TrainCompany removeTrainCompany(String id);
    TrainCompany getTrainCompany(String id);
    Enumeration<TrainCompany> getAllTrainCompanies();
}
