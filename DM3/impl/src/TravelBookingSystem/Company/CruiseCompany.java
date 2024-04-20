package TravelBookingSystem.Company;

import java.io.Serializable;

public class CruiseCompany extends Company implements Serializable
{
    private static final long serialVersionUID = 1L;

    public CruiseCompany() { } // For Deserialization

    public CruiseCompany(String id, String name)
    {
        super(id, name);
    }
}