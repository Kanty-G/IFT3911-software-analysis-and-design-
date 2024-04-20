package TravelBookingSystem.Infrastructure;

import java.io.Serializable;

public class Airport extends Infrastructure implements Serializable
{
    private static final long serialVersionUID = 1L;

    public Airport() { } // For Serialization

    public Airport(String id, String city)
    {
        super(id, city);
    }
}