package TravelBookingSystem.Vehicle.Section;

public abstract class TravelSpaceState
{
    public abstract boolean isAvailable();
    public abstract void reserveSpace(TravelSpace space);
    public abstract void confirmSpace(TravelSpace space);
    public abstract void cancelSpace(TravelSpace space);
}