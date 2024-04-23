package TravelBookingSystem.Travel;

import java.util.Enumeration;

public class TravelService
{
    private TravelDatabase travelDatabase;

    public TravelService(TravelDatabase travelDatabase)
    {
        this.travelDatabase = travelDatabase;
    }

    public void addFlight(Flight flight)
    {
        travelDatabase.addFlight(flight);
    }

    public void deleteFlight(String id)
    {
        travelDatabase.removeFlight(id);
    }

    public Flight getFlight(String id)
    {
        return travelDatabase.getFlight(id);
    }

    public Enumeration<Flight> getAllFlights()
    {
        return travelDatabase.getAllFlights();
    }

    public void addCruiseItinerary(CruiseItinerary cruiseItinerary)
    {
        travelDatabase.addCruiseItinerary(cruiseItinerary);
    }

    public void deleteCruiseItinerary(String id)
    {
        travelDatabase.removeCruiseItinerary(id);
    }

    public void getCruiseItinerary(String id)
    {
        travelDatabase.getCruiseItinerary(id);
    }

    public Enumeration<CruiseItinerary> getAllCruiseItineraries()
    {
        return travelDatabase.getAllCruiseItineraries();
    }

    public void addTrainRoute(TrainRoute trainRoute)
    {
        travelDatabase.addTrainRoute(trainRoute);
    }

    public void deleteTrainRoute(String id)
    {
        travelDatabase.removeTrainRoute(id);
    }

    public TrainRoute getTrainRoute(String id)
    {
        return travelDatabase.getTrainRoute(id);
    }

    public Enumeration<TrainRoute> getAllTrainRoutes()
    {
        return travelDatabase.getAllTrainRoutes();
    }
}
