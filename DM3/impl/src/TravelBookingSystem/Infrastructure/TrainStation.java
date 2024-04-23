package TravelBookingSystem.Infrastructure;

import java.io.Serializable;

public class TrainStation extends Infrastructure implements Serializable
{
    private static final long serialVersionUID = 1L;

    public TrainStation() { } // For Serialization

    public TrainStation(String id, String city)
    {
        super(id, city);
    }

    @Override
    public String toString()
    {
        return "Train Station: {" + "id=" + this.getId() + ", city=" + this.getCity() + '}';
    }
}