package TravelBookingSystem.Infrastructure;

import java.util.Enumeration;

public class InfrastructureService
{
    private InfrastructureDatabase infrastructureDatabase;

    public InfrastructureService(InfrastructureDatabase infrastructureDatabase)
    {
        this.infrastructureDatabase = infrastructureDatabase;
    }


    public void addAirport(Airport airport)
    {
        infrastructureDatabase.addAirport(airport);
    }

    public Airport removeAirport(String id)
    {
        return infrastructureDatabase.removeAirport(id);
    }

    public Airport getAirport(String id)
    {
        return infrastructureDatabase.getAirport(id);
    }

    public Enumeration<Airport> getAllAirports()
    {
        return infrastructureDatabase.getAllAirports();
    }

    public void addHarbor(Harbor harbor)
    {
        infrastructureDatabase.addHarbor(harbor);
    }

    public Harbor removeHarbor(String id)
    {
        return infrastructureDatabase.removeHarbor(id);
    }

    public Harbor getHarbor(String id)
    {
        return infrastructureDatabase.getHarbor(id);
    }

    public Enumeration<Harbor> getAllHarbors()
    {
        return infrastructureDatabase.getAllHarbors();
    }

    public void addTrainStation(TrainStation trainStation)
    {
        infrastructureDatabase.addTrainStation(trainStation);
    }

    public TrainStation removeTrainStation(String id)
    {
        return infrastructureDatabase.removeTrainStation(id);
    }

    public TrainStation getTrainStation(String id)
    {
        return infrastructureDatabase.getTrainStation(id);
    }

    public Enumeration<TrainStation> getAllTrainStations()
    {
        return infrastructureDatabase.getAllTrainStations();
    }
}
