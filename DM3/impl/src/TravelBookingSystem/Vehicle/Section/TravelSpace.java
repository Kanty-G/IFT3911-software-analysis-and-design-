package TravelBookingSystem.Vehicle.Section;

public abstract class TravelSpace
{
    private String id;
    private TravelSpaceState spaceState;

    public void setState(TravelSpaceState state)
    {
        this.spaceState = state;
    }
}