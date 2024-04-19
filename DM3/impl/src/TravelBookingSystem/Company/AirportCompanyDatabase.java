package TravelBookingSystem.Company;

import java.util.Enumeration;

public interface AirportCompanyDatabase
{
    void addAirportCompany(AirportCompany airportCompany);
    void setAirportCompany(AirportCompany airportCompany);
    AirportCompany removeAirportCompany(String id);
    AirportCompany getAirportCompany(String id);
    Enumeration<AirportCompany> getAllAirportCompanies();
}
