package TravelBookingSystem.Infrastructure;

import java.io.Serializable;

public class Harbor extends Infrastructure implements Serializable
{
    private static final long serialVersionUID = 1L;

    public Harbor() { } // For Serialization

    public Harbor(String id, String city)
    {
        super(id, city);
    }

    @Override
    public String toString()
    {
        return "Harbor: {" + "id=" + this.getId() + ", city=" + this.getCity() + '}';
    }
}