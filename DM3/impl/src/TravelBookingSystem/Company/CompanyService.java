package TravelBookingSystem.Company;

import java.util.Enumeration;

public class CompanyService
{
    private CompanyDatabase companyDatabase;

    public CompanyService(CompanyDatabase companyDatabase)
    {
        this.companyDatabase = companyDatabase;
    }

    public void addAirportCompany(AirportCompany airportCompany)
    {
        companyDatabase.addAirportCompany(airportCompany);
    }

    public AirportCompany removeAirportCompany(String id)
    {
        return companyDatabase.removeAirportCompany(id);
    }

    public AirportCompany getAirportCompany(String id)
    {
        return companyDatabase.getAirportCompany(id);
    }

    public Enumeration<AirportCompany> getAllAirportCompanies()
    {
        return companyDatabase.getAllAirportCompanies();
    }

    public void addCruiseCompany(CruiseCompany cruiseCompany)
    {
        companyDatabase.addCruiseCompany(cruiseCompany);
    }

    public CruiseCompany removeCruiseCompany(String id)
    {
        return companyDatabase.removeCruiseCompany(id);
    }

    public CruiseCompany getCruiseCompany(String id)
    {
        return companyDatabase.getCruiseCompany(id);
    }

    public Enumeration<CruiseCompany> getAllCruiseCompanies()
    {
        return companyDatabase.getAllCruiseCompanies();
    }

    public void addTrainCompany(TrainCompany trainCompany)
    {
        companyDatabase.addTrainCompany(trainCompany);
    }

    public TrainCompany removeTrainCompany(String id)
    {
        return companyDatabase.removeTrainCompany(id);
    }

    public TrainCompany getTrainCompany(String id)
    {
        return companyDatabase.getTrainCompany(id);
    }

    public Enumeration<TrainCompany> getAllTrainCompanies()
    {
        return companyDatabase.getAllTrainCompanies();
    }
}
