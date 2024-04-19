package TravelBookingSystem.Company;

import java.util.Enumeration;

public interface CruiseCompanyDatabase
{
    void addCruiseCompany(CruiseCompany cruiseCompany);
    void setCruiseCompany(CruiseCompany cruiseCompany);
    CruiseCompany removeCruiseCompany(String id);
    CruiseCompany getCruiseCompany(String id);
    Enumeration<CruiseCompany> getAllCruiseCompanies();
}
