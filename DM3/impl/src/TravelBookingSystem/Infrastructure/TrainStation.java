package TravelBookingSystem.Infrastructure;

import java.io.Serializable;

public class TrainStation extends Infrastructure implements Serializable
{
    private static final long serialVersionUID = 1L;

    public TrainStation(String id, String city)
    {
        super(id, city);
    }
}