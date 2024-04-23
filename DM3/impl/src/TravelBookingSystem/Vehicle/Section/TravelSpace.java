package TravelBookingSystem.Vehicle.Section;

import java.io.Serializable;

public abstract class TravelSpace implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;
    private transient TravelSpaceState spaceState = new Available();

    public TravelSpace() { } // For Serialization

    public TravelSpace(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public boolean isAvailable()
    {
        return spaceState.isAvailable();
    }

    public void setState(TravelSpaceState state)
    {
        this.spaceState = state;
    }
}