package TravelBookingSystem.Vehicle.Section;

public class Confirmed extends TravelSpaceState
{
    @Override
    public boolean isAvailable()
    {
        return false;
    }

    @Override
    public void reserveSpace(TravelSpace space)
    {
        // Do Nothing
    }

    @Override
    public void confirmSpace(TravelSpace space)
    {
        // Do Nothing
    }

    @Override
    public void cancelSpace(TravelSpace space)
    {
        space.setState(new Available());
    }
}