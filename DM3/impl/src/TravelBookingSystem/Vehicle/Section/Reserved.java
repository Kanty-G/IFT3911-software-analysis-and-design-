package TravelBookingSystem.Vehicle.Section;

public class Reserved extends TravelSpaceState
{
    @Override
    public void reserveSpace(TravelSpace space)
    {
        // Do Nothing
    }

    @Override
    public void confirmSpace(TravelSpace space)
    {
        space.setState(new Confirmed());
    }

    @Override
    public void cancelSpace(TravelSpace space)
    {
        space.setState(new Available());
    }
}