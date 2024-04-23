package TravelBookingSystem.Company;

import java.io.Serializable;

public class TrainCompany extends Company implements Serializable
{
    private static final long serialVersionUID = 1L;

    public TrainCompany() { } // For Deserialization

    public TrainCompany(String id, String name)
    {
        super(id, name);
    }

    @Override
    public String toString()
    {
        return "Train Company: {" + "id=" + this.getId() + ", name=" + this.getName() + '}';
    }
}