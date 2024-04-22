package TravelBookingSystem.Vehicle.Section;

public class Available extends TravelSpaceState
{
    @Override
    public void reserveSpace(TravelSpace space)
    {
        space.setState(new Reserved());
    }

    @Override
    public void confirmSpace(TravelSpace space)
    {
        // Do Nothing
    }

    @Override
    public void cancelSpace(TravelSpace space)
    {
        // Do Nothing
    }
}
