package TravelBookingSystem.Infrastructure;

import java.io.Serializable;

public class Infrastructure implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;
    private String city;

    public Infrastructure() { } // For Serialization

    public Infrastructure(String id, String city)
    {
        this.id = id;
        this.city = city;
    }

    public String getId()
    {
        return id;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public InfrastructureMemento getMemento()
    {
        return new InfrastructureMemento(city);
    }

    public void restoreFromMemento(InfrastructureMemento memento)
    {
        city = memento.getCity();
    }

    public static boolean isValidId(String id)
    {
        return id != null && id.length() == 3;
    }
}