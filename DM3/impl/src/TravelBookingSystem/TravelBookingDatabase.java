package TravelBookingSystem;

import TravelBookingSystem.Company.*;
import TravelBookingSystem.Infrastructure.*;
import TravelBookingSystem.Observer.Observer;
import TravelBookingSystem.Observer.Subject;
import TravelBookingSystem.Payment.Payment;
import TravelBookingSystem.Payment.PaymentDatabase;
import TravelBookingSystem.Reservation.Reservation;
import TravelBookingSystem.Reservation.ReservationDatabase;
import TravelBookingSystem.Travel.*;
import TravelBookingSystem.Vehicle.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class TravelBookingDatabase implements Serializable, Subject,
        CompanyDatabase, InfrastructureDatabase,
        TransportVehicleDatabase, TravelDatabase,
        ReservationDatabase, PaymentDatabase
{
    private static final String databaseFilePath = "./database.data";
    private static final long serialVersionUID = 1L;

    private ArrayList<Observer> observers = new ArrayList<>();

    // Companies
    private Hashtable<String, AirportCompany> airportCompanyTable = new Hashtable<>();
    private Hashtable<String, CruiseCompany> cruiseCompanyTable = new Hashtable<>();
    private Hashtable<String, TrainCompany> trainCompanyTable = new Hashtable<>();

    // Infrastructure
    private Hashtable<String, Airport> airportTable = new Hashtable<>();
    private Hashtable<String, Harbor> harborTable = new Hashtable<>();
    private Hashtable<String, TrainStation> trainStationTable = new Hashtable<>();

    // TransportVehicles
    private Hashtable<String, Airplane> airplaneTable = new Hashtable<>();
    private Hashtable<String, CruiseShip> cruiseShipTable = new Hashtable<>();
    private Hashtable<String, Train> trainTable = new Hashtable<>();

    // Travels
    private Hashtable<String, Flight> flightTable = new Hashtable<>();
    private Hashtable<String, CruiseItinerary> itineraryTable = new Hashtable<>();
    private Hashtable<String, TrainRoute> routeTable = new Hashtable<>();

    //Client
    private Hashtable<String, Reservation> reservationTable = new Hashtable<>();
    private Hashtable<String, Payment> paymentTable = new Hashtable<>();

    public TravelBookingDatabase() { }

    public void register(Observer observer)
    {
        if (observer == null)
        {
            throw new NullPointerException("Null observer");
        }

        if (!observers.contains(observer))
        {
            observers.add(observer);
        }
    }

    public void unregister(Observer observer)
    {
        observers.remove(observer);
    }

    public void loadDatabase()
    {
        TravelBookingDatabase database = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(databaseFilePath)))
        {
            database = (TravelBookingDatabase) ois.readObject();
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.out.println("Couldn't find database file. Generating new one.");
            saveDatabase();
            return;
        }
        catch (EOFException eofException)
        {
            // End of file reached
        }
        catch (ClassNotFoundException | IOException exception)
        {
            exception.printStackTrace();
            return;
        }

        if (database == null)
        {
            System.out.println("ERROR: Couldn't load database from file.");
            return;
        }

        setTables(database);
    }

    public void saveDatabase()
    {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(databaseFilePath)))
        {
            objectOutputStream.writeObject(this);
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }

    public void clearDatabase()
    {
        clearTables();
        saveDatabase();
    }

    public void addAirplane(Airplane airplane)
    {
        String airplaneId = airplane.getId();
        if (airplaneTable.containsKey(airplaneId))
        {
            System.out.println("Airplane with id " + airplaneId + " already exists in the database.");
            return;
        }

        airplaneTable.put(airplaneId, airplane);
        notifyObservers();
    }

    public Airplane removeAirplane(String id)
    {
        Airplane airplane = airplaneTable.remove(id);
        notifyObservers();
        return airplane;
    }

    public Airplane getAirplane(String id)
    {
        return airplaneTable.get(id);
    }

    public Enumeration<Airplane> getAllAirplanes()
    {
        return airplaneTable.elements();
    }

    public void addAirportCompany(AirportCompany airportCompany)
    {
        String airportCompanyId = airportCompany.getId();
        if (airportCompanyTable.containsKey(airportCompanyId))
        {
            System.out.println("AirportCompany with id " + airportCompanyId + " already exists in the database.");
            return;
        }

        airportCompanyTable.put(airportCompanyId, airportCompany);
        notifyObservers();
    }

    public AirportCompany removeAirportCompany(String id)
    {
        AirportCompany airportCompany = airportCompanyTable.remove(id);
        notifyObservers();
        return airportCompany;
    }

    public AirportCompany getAirportCompany(String id)
    {
        return airportCompanyTable.get(id);
    }

    public Enumeration<AirportCompany> getAllAirportCompanies()
    {
        return airportCompanyTable.elements();
    }

    public void addAirport(Airport airport)
    {
        String airportId = airport.getId();
        if (airportTable.containsKey(airportId))
        {
            System.out.println("Airport with id " + airportId + " already exists in the database.");
            return;
        }

        airportTable.put(airportId, airport);
        notifyObservers();
    }

    public Airport removeAirport(String id)
    {
        Airport airport = airportTable.remove(id);
        notifyObservers();
        return airport;
    }

    public Airport getAirport(String id)
    {
        return airportTable.get(id);
    }

    public Enumeration<Airport> getAllAirports()
    {
        return airportTable.elements();
    }

    public void addCruiseCompany(CruiseCompany cruiseCompany)
    {
        String cruiseCompanyId = cruiseCompany.getId();
        if (cruiseCompanyTable.containsKey(cruiseCompanyId))
        {
            System.out.println("CruiseCompany with id " + cruiseCompanyId + " already exists in the database.");
            return;
        }

        cruiseCompanyTable.put(cruiseCompanyId, cruiseCompany);
        notifyObservers();
    }

    public CruiseCompany removeCruiseCompany(String id)
    {
        CruiseCompany cruiseCompany = cruiseCompanyTable.remove(id);
        notifyObservers();
        return cruiseCompany;
    }

    public CruiseCompany getCruiseCompany(String id)
    {
        return cruiseCompanyTable.get(id);
    }

    public Enumeration<CruiseCompany> getAllCruiseCompanies()
    {
        return cruiseCompanyTable.elements();
    }

    public void addCruiseItinerary(CruiseItinerary itinerary)
    {
        String cruiseItineraryId = itinerary.getId();
        if (itineraryTable.containsKey(cruiseItineraryId))
        {
            System.out.println("CruiseItinerary with id " + cruiseItineraryId + " already exists in the database.");
            return;
        }

        itineraryTable.put(cruiseItineraryId, itinerary);
        notifyObservers();
    }

    public CruiseItinerary removeCruiseItinerary(String id)
    {
        CruiseItinerary cruiseItinerary = itineraryTable.remove(id);
        return cruiseItinerary;
    }

    public CruiseItinerary getCruiseItinerary(String id)
    {
        return itineraryTable.get(id);
    }

    public Enumeration<CruiseItinerary> getAllCruiseItineraries()
    {
        return itineraryTable.elements();
    }

    public void addCruiseShip(CruiseShip cruiseShip)
    {
        String cruiseShipId = cruiseShip.getId();
        if (cruiseShipTable.containsKey(cruiseShipId))
        {
            System.out.println("CruiseShip with id " + cruiseShipId + " already exists in the database.");
            return;
        }

        cruiseShipTable.put(cruiseShipId, cruiseShip);
        notifyObservers();
    }

    public CruiseShip removeCruiseShip(String id)
    {
        return cruiseShipTable.remove(id);
    }

    public CruiseShip getCruiseShip(String id)
    {
        return cruiseShipTable.get(id);
    }

    public Enumeration<CruiseShip> getAllCruiseShips()
    {
        return cruiseShipTable.elements();
    }

    public void addFlight(Flight flight)
    {
        String flightId = flight.getId();
        if (flightTable.containsKey(flightId))
        {
            System.out.println("Flight with id " + flightId + " already exists in the database.");
            return;
        }

        flightTable.put(flightId, flight);
        notifyObservers();
    }

    public Flight removeFlight(String id)
    {
        Flight flight = flightTable.remove(id);
        notifyObservers();
        return flight;
    }

    public Flight getFlight(String id)
    {
        return flightTable.get(id);
    }

    public Enumeration<Flight> getAllFlights()
    {
        return flightTable.elements();
    }

    public void addHarbor(Harbor harbor)
    {
        String harborId = harbor.getId();
        if (harborTable.containsKey(harborId))
        {
            System.out.println("Harbor with id " + harborId + " already exists in the database.");
            return;
        }

        harborTable.put(harborId, harbor);
        notifyObservers();
    }

    public Harbor removeHarbor(String id)
    {
        Harbor harbor = harborTable.remove(id);
        notifyObservers();
        return harbor;
    }

    public Harbor getHarbor(String id)
    {
        return harborTable.get(id);
    }

    public Enumeration<Harbor> getAllHarbors()
    {
        return harborTable.elements();
    }

    public void addTrainCompany(TrainCompany trainCompany)
    {
        String trainCompanyId = trainCompany.getId();
        if (trainCompanyTable.containsKey(trainCompanyId))
        {
            System.out.println("TrainCompany with id " + trainCompanyId + " already exists in the database.");
            return;
        }

        trainCompanyTable.put(trainCompanyId, trainCompany);
        notifyObservers();
    }

    public TrainCompany removeTrainCompany(String id)
    {
        TrainCompany trainCompany = trainCompanyTable.remove(id);
        notifyObservers();
        return trainCompany;
    }

    public TrainCompany getTrainCompany(String id)
    {
        return trainCompanyTable.get(id);
    }

    public Enumeration<TrainCompany> getAllTrainCompanies()
    {
        return trainCompanyTable.elements();
    }

    public void addTrain(Train train)
    {
        String trainId = train.getId();
        if (trainTable.containsKey(trainId))
        {
            System.out.println("Train with id " + trainId + " already exists in the database.");
            return;
        }

        trainTable.put(trainId, train);
        notifyObservers();
    }

    public Train removeTrain(String id)
    {
        Train train = trainTable.remove(id);
        notifyObservers();
        return train;
    }

    public Train getTrain(String id)
    {
        return trainTable.get(id);
    }

    public Enumeration<Train> getAllTrains()
    {
        return trainTable.elements();
    }

    public void addTrainRoute(TrainRoute trainRoute)
    {
        String trainRouteId = trainRoute.getId();
        if (routeTable.containsKey(trainRouteId))
        {
            System.out.println("Route with id " + trainRouteId + " already exists in the database.");
            return;
        }

        routeTable.put(trainRouteId, trainRoute);
        notifyObservers();
    }

    public TrainRoute removeTrainRoute(String id)
    {
        TrainRoute trainRoute = routeTable.remove(id);
        notifyObservers();
        return trainRoute;
    }

    public TrainRoute getTrainRoute(String id)
    {
        return routeTable.get(id);
    }

    public Enumeration<TrainRoute> getAllTrainRoutes()
    {
        return routeTable.elements();
    }

    public void addTrainStation(TrainStation trainStation)
    {
        String trainStationId = trainStation.getId();
        if (trainStationTable.containsKey(trainStationId))
        {
            System.out.println("TrainStation with id " + trainStationId + " already exists in the database.");
            return;
        }

        trainStationTable.put(trainStationId, trainStation);
        notifyObservers();
    }

    public TrainStation removeTrainStation(String id)
    {
        TrainStation trainStation = trainStationTable.remove(id);
        notifyObservers();
        return trainStation;
    }

    public TrainStation getTrainStation(String id)
    {
        return trainStationTable.get(id);
    }

    public Enumeration<TrainStation> getAllTrainStations()
    {
        return trainStationTable.elements();
    }

    public void addPayment(Payment payment)
    {
        String paymentId = payment.getId();
        if (paymentTable.containsKey(paymentId))
        {
            System.out.println("Payment with id " + paymentId + " already exists in the database.");
            return;
        }

        paymentTable.put(paymentId, payment);
        notifyObservers();
    }

    public Payment removePayment(String id)
    {
        Payment payment = paymentTable.remove(id);
        notifyObservers();
        return payment;
    }

    public Payment getPayment(String id)
    {
        return paymentTable.get(id);
    }

    public Enumeration<Payment> getAllPayments()
    {
        return paymentTable.elements();
    }

    public void addReservation(Reservation reservation)
    {
        String reservationNumber = reservation.getReservationNumber();
        if (reservationTable.containsKey(reservationNumber))
        {
            System.out.println("Reservation with number " + reservationNumber + " already exists in the database.");
            return;
        }

        reservationTable.put(reservationNumber, reservation);
        notifyObservers();
    }

    public Reservation removeReservation(String reservationNumber)
    {
        Reservation reservation = reservationTable.remove(reservationNumber);
        notifyObservers();
        return reservation;
    }

    public Reservation getReservation(String reservationNumber)
    {
        return reservationTable.get(reservationNumber);
    }

    public Enumeration<Reservation> getAllReservations()
    {
        return reservationTable.elements();
    }

    private void notifyObservers()
    {
        for (Observer observer : observers)
        {
            observer.update();
        }
    }

    private void setTables(TravelBookingDatabase database)
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
        reservationTable = database.reservationTable;
        paymentTable = database.paymentTable;
    }

    private void clearTables()
    {
        airportTable.clear();
        harborTable.clear();
        trainStationTable.clear();
        airportCompanyTable.clear();
        cruiseCompanyTable.clear();
        trainCompanyTable.clear();
        trainTable.clear();
        airplaneTable.clear();
        cruiseShipTable.clear();
        trainTable.clear();
        flightTable.clear();
        itineraryTable.clear();
        routeTable.clear();
        reservationTable.clear();
        paymentTable.clear();
    }
}
