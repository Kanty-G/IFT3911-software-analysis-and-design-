package TravelBookingSystem.Database;

import TravelBookingSystem.Default.*;

import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;

public class TravelBookingDatabase implements Serializable,
        AirportDatabase, HarborDatabase, TrainStationDatabase,
        AirportCompanyDatabase, CruiseCompanyDatabase, TrainCompanyDatabase,
        AirplaneDatabase, CruiseShipDatabase, TrainDatabase,
        FlightDatabase, CruiseItineraryDatabase, TrainRouteDatabase
{
    private static final String databaseFilePath = "./database.data";
    private static final long serialVersionUID = 1L;

    // Infrastructure
    private Hashtable<String, Airport> airportTable = new Hashtable<>();
    private Hashtable<String, Harbor> harborTable = new Hashtable<>();
    private Hashtable<String, TrainStation> trainStationTable = new Hashtable<>();

    // Companies
    private Hashtable<String, AirportCompany> airportCompanyTable = new Hashtable<>();
    private Hashtable<String, CruiseCompany> cruiseCompanyTable = new Hashtable<>();
    private Hashtable<String, TrainCompany> trainCompanyTable = new Hashtable<>();

    // TransportVehicles
    private Hashtable<String, Airplane> airplaneTable = new Hashtable<>();
    private Hashtable<String, CruiseShip> cruiseShipTable = new Hashtable<>();
    private Hashtable<String, Train> trainTable = new Hashtable<>();

    // Travels
    private Hashtable<String, Flight> flightTable = new Hashtable<>();
    private Hashtable<String, CruiseItinerary> itineraryTable = new Hashtable<>();
    private Hashtable<String, TrainRoute> routeTable = new Hashtable<>();

    public void LoadDatabase()
    {
        TravelBookingDatabase database = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(databaseFilePath))) {
            database = (TravelBookingDatabase) ois.readObject();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Couldn't find database file. Generating new one.");
            SaveDatabase();
            return;
        } catch (EOFException eofException) {
            // End of file reached
        } catch (ClassNotFoundException | IOException exception) {
            exception.printStackTrace();
        }

        if (database == null)
        {
            System.out.println("ERROR: Couldn't load database from file.");
            return;
        }

        SetTables(database);
    }

    public void SaveDatabase()
    {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(databaseFilePath))) {
            objectOutputStream.writeObject(this);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void ClearDatabase()
    {
        ClearTables();
        SaveDatabase();
    }

    public void AddAirplane(Airplane airplane)
    {
        if (airplaneTable.contains(airplane))
        {
            System.out.println("Airplane already exists in the database.");
            return;
        }

        airplaneTable.put(airplane.getId(), airplane);
    }

    public void SetAirplane(Airplane airplane)
    {
        String airplaneId = airplane.getId();
        if (!airplaneTable.containsKey(airplaneId))
        {
            System.out.println("No airplane with id" + airplaneId + "exists in the database.");
            return;
        }

        airplaneTable.replace(airplaneId, airplane);
    }

    public Airplane RemoveAirplane(String id)
    {
        return airplaneTable.remove(id);
    }

    public Airplane GetAirplane(String id)
    {
        return airplaneTable.get(id);
    }

    public Enumeration<Airplane> GetAllAirplanes()
    {
        return airplaneTable.elements();
    }

    public void AddAirportCompany(AirportCompany airportCompany)
    {
        if (airportCompanyTable.contains(airportCompany))
        {
            System.out.println("AirportCompany already exists in the database.");
            return;
        }

        airportCompanyTable.put(airportCompany.getId(), airportCompany);
    }

    public void SetAirportCompany(AirportCompany airportCompany)
    {
        String airportCompanyId = airportCompany.getId();
        if (!airportCompanyTable.containsKey(airportCompanyId))
        {
            System.out.println("No airportCompany with id" + airportCompanyId + "exists in the database.");
            return;
        }

        airportCompanyTable.replace(airportCompanyId, airportCompany);
    }

    public AirportCompany RemoveAirportCompany(String id)
    {
        return airportCompanyTable.remove(id);
    }

    public AirportCompany GetAirportCompany(String id)
    {
        return airportCompanyTable.get(id);
    }

    public Enumeration<AirportCompany> GetAllAirportCompanies()
    {
        return airportCompanyTable.elements();
    }

    public void AddAirport(Airport airport)
    {
        if (airportTable.contains(airport))
        {
            System.out.println("Airport already exists in the database.");
            return;
        }

        airportTable.put(airport.getId(), airport);
    }

    public void SetAirport(Airport airport)
    {
        String airportId = airport.getId();
        if (!airportTable.containsKey(airportId))
        {
            System.out.println("No airport with id" + airportId + "exists in the database.");
            return;
        }

        airportTable.replace(airportId, airport);
    }

    public Airport RemoveAirport(String id)
    {
        return airportTable.remove(id);
    }

    public Airport GetAirport(String id)
    {
        return airportTable.get(id);
    }

    public Enumeration<Airport> GetAllAirports()
    {
        return airportTable.elements();
    }

    public void AddCruiseCompany(CruiseCompany cruiseCompany)
    {
        if (cruiseCompanyTable.contains(cruiseCompany))
        {
            System.out.println("CruiseCompany already exists in the database.");
            return;
        }

        cruiseCompanyTable.put(cruiseCompany.getId(), cruiseCompany);
    }

    public void SetCruiseCompany(CruiseCompany cruiseCompany)
    {
        String cruiseCompanyId = cruiseCompany.getId();
        if (!cruiseCompanyTable.containsKey(cruiseCompanyId))
        {
            System.out.println("No cruiseCompany with id" + cruiseCompanyId + "exists in the database.");
            return;
        }

        cruiseCompanyTable.replace(cruiseCompanyId, cruiseCompany);
    }

    public CruiseCompany RemoveCruiseCompany(String id)
    {
        return cruiseCompanyTable.remove(id);
    }

    public CruiseCompany GetCruiseCompany(String id)
    {
        return cruiseCompanyTable.get(id);
    }

    public Enumeration<CruiseCompany> GetAllCruiseCompanies()
    {
        return cruiseCompanyTable.elements();
    }

    public void AddCruiseItinerary(CruiseItinerary itinerary)
    {
        if (itineraryTable.contains(itinerary))
        {
            System.out.println("Itinerary already exists in the database.");
            return;
        }

        itineraryTable.put(itinerary.getId(), itinerary);
    }

    public void SetCruiseItinerary(CruiseItinerary itinerary)
    {
        String itineraryId = itinerary.getId();
        if (!itineraryTable.containsKey(itineraryId))
        {
            System.out.println("No itinerary with id" + itineraryId + "exists in the database.");
            return;
        }

        itineraryTable.replace(itineraryId, itinerary);
    }

    public CruiseItinerary RemoveCruiseItinerary(String id)
    {
        return itineraryTable.remove(id);
    }

    public CruiseItinerary GetCruiseItinerary(String id)
    {
        return itineraryTable.get(id);
    }

    public Enumeration<CruiseItinerary> GetAllCruiseItineraries()
    {
        return itineraryTable.elements();
    }

    public void AddCruiseShip(CruiseShip cruiseShip)
    {
        if (cruiseShipTable.contains(cruiseShip))
        {
            System.out.println("CruiseShip already exists in the database.");
            return;
        }

        cruiseShipTable.put(cruiseShip.getId(), cruiseShip);
    }

    public void SetCruiseShip(CruiseShip cruiseShip)
    {
        String cruiseShipId = cruiseShip.getId();
        if (!cruiseShipTable.containsKey(cruiseShipId))
        {
            System.out.println("No cruiseShip with id" + cruiseShipId + "exists in the database.");
            return;
        }

        cruiseShipTable.replace(cruiseShipId, cruiseShip);
    }

    public CruiseShip RemoveCruiseShip(String id)
    {
        return cruiseShipTable.remove(id);
    }

    public CruiseShip GetCruiseShip(String id)
    {
        return cruiseShipTable.get(id);
    }

    public Enumeration<CruiseShip> GetAllCruiseShips()
    {
        return cruiseShipTable.elements();
    }

    public void AddFlight(Flight flight)
    {
        if (flightTable.contains(flight))
        {
            System.out.println("Flight already exists in the database.");
            return;
        }

        flightTable.put(flight.getId(), flight);
    }

    public void SetFlight(Flight flight)
    {
        String flightId = flight.getId();
        if (!flightTable.containsKey(flightId))
        {
            System.out.println("No flight with id" + flightId + "exists in the database.");
            return;
        }

        flightTable.replace(flightId, flight);
    }

    public Flight RemoveFlight(String id)
    {
        return flightTable.remove(id);
    }

    public Flight GetFlight(String id)
    {
        return flightTable.get(id);
    }

    public Enumeration<Flight> GetAllFlights()
    {
        return flightTable.elements();
    }

    public void AddHarbor(Harbor harbor)
    {
        if (harborTable.contains(harbor))
        {
            System.out.println("Harbor already exists in the database.");
        }
    }

    public void SetHarbor(Harbor harbor)
    {
        String harborId = harbor.getId();
        if (!harborTable.containsKey(harborId))
        {
            System.out.println("No harbor with id" + harborId + "exists in the database.");
            return;
        }

        harborTable.replace(harborId, harbor);
    }

    public Harbor RemoveHarbor(String id)
    {
        return harborTable.remove(id);
    }

    public Harbor GetHarbor(String id)
    {
        return harborTable.get(id);
    }

    public Enumeration<Harbor> GetAllHarbors()
    {
        return harborTable.elements();
    }

    public void AddTrainCompany(TrainCompany trainCompany)
    {
        if (trainCompanyTable.contains(trainCompany))
        {
            System.out.println("TrainCompany already exists in the database.");
            return;
        }

        trainCompanyTable.put(trainCompany.getId(), trainCompany);
    }

    public void SetTrainCompany(TrainCompany trainCompany)
    {
        String trainCompanyId = trainCompany.getId();
        if (!trainCompanyTable.containsKey(trainCompanyId))
        {
            System.out.println("No trainCompany with id" + trainCompanyId + "exists in the database.");
            return;
        }

        trainCompanyTable.replace(trainCompanyId, trainCompany);
    }

    public TrainCompany RemoveTrainCompany(String id)
    {
        return trainCompanyTable.remove(id);
    }

    public TrainCompany GetTrainCompany(String id)
    {
        return trainCompanyTable.get(id);
    }

    public Enumeration<TrainCompany> GetAllTrainCompanies()
    {
        return trainCompanyTable.elements();
    }

    public void AddTrain(Train train)
    {
        if (trainTable.contains(train))
        {
            System.out.println("Train already exists in the database.");
            return;
        }

        trainTable.put(train.getId(), train);
    }

    public void SetTrain(Train train)
    {
        String trainId = train.getId();
        if (!trainTable.containsKey(trainId))
        {
            System.out.println("No train with id" + trainId + "exists in the database.");
            return;
        }

        trainTable.replace(trainId, train);
    }

    public Train RemoveTrain(String id)
    {
        return trainTable.remove(id);
    }

    public Train GetTrain(String id)
    {
        return trainTable.get(id);
    }

    public Enumeration<Train> GetAllTrains()
    {
        return trainTable.elements();
    }

    public void AddTrainRoute(TrainRoute trainRoute)
    {
        if (routeTable.contains(trainRoute))
        {
            System.out.println("Route already exists in the database.");
            return;
        }

        routeTable.put(trainRoute.getId(), trainRoute);
    }

    public void SetTrainRoute(TrainRoute trainRoute)
    {
        String routeId = trainRoute.getId();
        if (!routeTable.containsKey(routeId))
        {
            System.out.println("No route with id" + routeId + "exists in the database.");
            return;
        }

        routeTable.replace(routeId, trainRoute);
    }

    public TrainRoute RemoveTrainRoute(String id)
    {
        return routeTable.remove(id);
    }

    public TrainRoute GetTrainRoute(String id)
    {
        return routeTable.get(id);
    }

    public Enumeration<TrainRoute> GetAllTrainRoutes()
    {
        return routeTable.elements();
    }

    public void AddTrainStation(TrainStation trainStation)
    {
        if (trainStationTable.contains(trainStation))
        {
            System.out.println("TrainStation already exists in the database.");
            return;
        }

        trainStationTable.put(trainStation.getId(), trainStation);
    }

    public void SetTrainStation(TrainStation trainStation)
    {
        if (trainStationTable.contains(trainStation))
        {
            System.out.println("TrainStation already exists in the database.");
            return;
        }

        trainStationTable.put(trainStation.getId(), trainStation);
    }

    public TrainStation RemoveTrainStation(String id)
    {
        return trainStationTable.remove(id);
    }

    public TrainStation GetTrainStation(String id)
    {
        return trainStationTable.get(id);
    }

    public Enumeration<TrainStation> GetAllTrainStations()
    {
        return trainStationTable.elements();
    }

    private void SetTables(TravelBookingDatabase database)
    {
        airportTable = database.airportTable;
        harborTable = database.harborTable;
        trainStationTable = database.trainStationTable;
        airportCompanyTable = database.airportCompanyTable;
        cruiseCompanyTable = database.cruiseCompanyTable;
        trainCompanyTable = database.trainCompanyTable;
        airplaneTable = database.airplaneTable;
        cruiseShipTable = database.cruiseShipTable;
        trainTable = database.trainTable;
        flightTable = database.flightTable;
        itineraryTable = database.itineraryTable;
        routeTable = database.routeTable;
    }

    private void ClearTables()
    {
        airportTable.clear();
        harborTable.clear();
        trainStationTable.clear();
        airportCompanyTable.clear();
        cruiseCompanyTable.clear();
        trainTable.clear();
        airplaneTable.clear();
        cruiseShipTable.clear();
        trainTable.clear();
        flightTable.clear();
        itineraryTable.clear();
        routeTable.clear();
    }
}
