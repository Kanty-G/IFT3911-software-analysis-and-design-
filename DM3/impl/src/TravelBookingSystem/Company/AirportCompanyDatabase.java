package TravelBookingSystem.Company;

import java.util.Enumeration;

public interface AirportCompanyDatabase
{
    void addAirportCompany(AirportCompany airportCompany);
    AirportCompany replaceAirportCompany(AirportCompany airportCompany);
    AirportCompany removeAirportCompany(String id);
    AirportCompany getAirportCompany(String id);
    Enumeration<AirportCompany> getAllAirportCompanies();
}
