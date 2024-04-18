package TravelBookingSystem.Company;

import java.util.Enumeration;

public interface CruiseCompanyDatabase
{
    void AddCruiseCompany(CruiseCompany cruiseCompany);
    void SetCruiseCompany(CruiseCompany cruiseCompany);
    CruiseCompany RemoveCruiseCompany(String id);
    CruiseCompany GetCruiseCompany(String id);
    Enumeration<CruiseCompany> GetAllCruiseCompanies();
}
