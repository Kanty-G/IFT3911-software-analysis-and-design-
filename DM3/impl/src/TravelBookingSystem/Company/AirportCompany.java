package TravelBookingSystem.Company;

import java.io.Serializable;

public class AirportCompany extends Company implements Serializable
{
    private static final long serialVersionUID = 1L;

    public AirportCompany() { } // For Deserialization

    public AirportCompany(String id, String name)
    {
        super(id, name);
    }
}