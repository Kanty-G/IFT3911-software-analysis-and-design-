package TravelBookingSystem.Database;

import TravelBookingSystem.Default.CruiseCompany;

import java.util.Enumeration;

public interface CruiseCompanyDatabase
{
    void AddCruiseCompany(CruiseCompany cruiseCompany);
    void SetCruiseCompany(CruiseCompany cruiseCompany);
    CruiseCompany RemoveCruiseCompany(String id);
    CruiseCompany GetCruiseCompany(String id);
    Enumeration<CruiseCompany> GetAllCruiseCompanies();
}
