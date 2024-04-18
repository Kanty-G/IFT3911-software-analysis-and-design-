package TravelBookingSystem.Company;

import java.util.Enumeration;

public interface AirportCompanyDatabase
{
    void AddAirportCompany(AirportCompany airportCompany);
    void SetAirportCompany(AirportCompany airportCompany);
    AirportCompany RemoveAirportCompany(String id);
    AirportCompany GetAirportCompany(String id);
    Enumeration<AirportCompany> GetAllAirportCompanies();
}
