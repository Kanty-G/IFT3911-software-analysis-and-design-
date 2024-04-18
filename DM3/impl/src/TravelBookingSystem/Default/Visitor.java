package TravelBookingSystem.Default;

public abstract class Visitor
{

    /**
     * 
     * @param trainRoute
     */
    public String visiterTrajet(TrainRoute trainRoute)
    {
        // TODO - implement Visitor.visiterTrajet
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param flight
     */
    public String visiterVol(Flight flight)
    {
        // TODO - implement Visitor.visiterVol
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param itinerary
     */
    public String visiterItinerairel(CruiseItinerary itinerary)
    {
        // TODO - implement Visitor.visiterItinerairel
        throw new UnsupportedOperationException();
    }

    public void getResults()
    {
        // TODO - implement Visitor.getResults
        throw new UnsupportedOperationException();
    }

}