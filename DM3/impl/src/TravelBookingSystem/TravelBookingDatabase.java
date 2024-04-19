package TravelBookingSystem;

import TravelBookingSystem.Company.*;
import TravelBookingSystem.Infrastructure.*;
import TravelBookingSystem.Payment.Payment;
import TravelBookingSystem.Payment.PaymentDatabase;
import TravelBookingSystem.Reservation.Reservation;
import TravelBookingSystem.Reservation.ReservationDatabase;
import TravelBookingSystem.Travel.*;
import TravelBookingSystem.Vehicle.*;

import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;

public class TravelBookingDatabase implements Serializable,
        CompanyDatabase, InfrastructureDatabase,
        TransportVehicleDatabase, TravelDatabase,
        ReservationDatabase, PaymentDatabase
{
    private static final String databaseFilePath = "./database.data";
    private static final long serialVersionUID = 1L;

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
    }

    public Airplane replaceAirplane(Airplane airplane)
    {
        String airplaneId = airplane.getId();
        if (!airplaneTable.containsKey(airplaneId))
        {
            System.out.println("No airplane with id " + airplaneId + " exists in the database.");
            return null;
        }

        return airplaneTable.replace(airplaneId, airplane);
    }

    public Airplane removeAirplane(String id)
    {
        return airplaneTable.remove(id);
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
    }

    public AirportCompany replaceAirportCompany(AirportCompany airportCompany)
    {
        String airportCompanyId = airportCompany.getId();
        if (!airportCompanyTable.containsKey(airportCompanyId))
        {
            System.out.println("No airportCompany with id " + airportCompanyId + " exists in the database.");
            return null;
        }

        return airportCompanyTable.replace(airportCompanyId, airportCompany);
    }

    public AirportCompany removeAirportCompany(String id)
    {
        return airportCompanyTable.remove(id);
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
    }

    public Airport replaceAirport(Airport airport)
    {
        String airportId = airport.getId();
        if (!airportTable.containsKey(airportId))
        {
            System.out.println("No airport with id " + airportId + " exists in the database.");
            return null;
        }

        return airportTable.replace(airportId, airport);
    }

    public Airport removeAirport(String id)
    {
        return airportTable.remove(id);
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
    }

    public CruiseCompany replaceCruiseCompany(CruiseCompany cruiseCompany)
    {
        String cruiseCompanyId = cruiseCompany.getId();
        if (!cruiseCompanyTable.containsKey(cruiseCompanyId))
        {
            System.out.println("No cruiseCompany with id " + cruiseCompanyId + " exists in the database.");
            return null;
        }

        return cruiseCompanyTable.replace(cruiseCompanyId, cruiseCompany);
    }

    public CruiseCompany removeCruiseCompany(String id)
    {
        return cruiseCompanyTable.remove(id);
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
    }

    public CruiseItinerary replaceCruiseItinerary(CruiseItinerary itinerary)
    {
        String itineraryId = itinerary.getId();
        if (!itineraryTable.containsKey(itineraryId))
        {
            System.out.println("No itinerary with id " + itineraryId + " exists in the database.");
            return null;
        }

        return itineraryTable.replace(itineraryId, itinerary);
    }

    public CruiseItinerary removeCruiseItinerary(String id)
    {
        return itineraryTable.remove(id);
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
    }

    public CruiseShip replaceCruiseShip(CruiseShip cruiseShip)
    {
        String cruiseShipId = cruiseShip.getId();
        if (!cruiseShipTable.containsKey(cruiseShipId))
        {
            System.out.println("No cruiseShip with id " + cruiseShipId + " exists in the database.");
            return null;
        }

        return cruiseShipTable.replace(cruiseShipId, cruiseShip);
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
    }

    public Flight replaceFlight(Flight flight)
    {
        String flightId = flight.getId();
        if (!flightTable.containsKey(flightId))
        {
            System.out.println("No flight with id " + flightId + " exists in the database.");
            return null;
        }

        return flightTable.replace(flightId, flight);
    }

    public Flight removeFlight(String id)
    {
        return flightTable.remove(id);
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
    }

    public Harbor replaceHarbor(Harbor harbor)
    {
        String harborId = harbor.getId();
        if (!harborTable.containsKey(harborId))
        {
            System.out.println("No harbor with id " + harborId + " exists in the database.");
            return null;
        }

        return harborTable.replace(harborId, harbor);
    }

    public Harbor removeHarbor(String id)
    {
        return harborTable.remove(id);
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
    }

    public TrainCompany replaceTrainCompany(TrainCompany trainCompany)
    {
        String trainCompanyId = trainCompany.getId();
        if (!trainCompanyTable.containsKey(trainCompanyId))
        {
            System.out.println("No trainCompany with id " + trainCompanyId + " exists in the database.");
            return null;
        }

        return trainCompanyTable.replace(trainCompanyId, trainCompany);
    }

    public TrainCompany removeTrainCompany(String id)
    {
        return trainCompanyTable.remove(id);
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
    }

    public Train replaceTrain(Train train)
    {
        String trainId = train.getId();
        if (!trainTable.containsKey(trainId))
        {
            System.out.println("No train with id " + trainId + " exists in the database.");
            return null;
        }

        return trainTable.replace(trainId, train);
    }

    public Train removeTrain(String id)
    {
        return trainTable.remove(id);
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
    }

    public TrainRoute replaceTrainRoute(TrainRoute trainRoute)
    {
        String routeId = trainRoute.getId();
        if (!routeTable.containsKey(routeId))
        {
            System.out.println("No route with id " + routeId + " exists in the database.");
            return null;
        }

        return routeTable.replace(routeId, trainRoute);
    }

    public TrainRoute removeTrainRoute(String id)
    {
        return routeTable.remove(id);
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
    }

    public TrainStation replaceTrainStation(TrainStation trainStation)
    {
        String trainStationId = trainStation.getId();
        if (!trainStationTable.containsKey(trainStationId))
        {
            System.out.println("No trainStation with id " + trainStationId + " exists in the database.");
            return null;
        }

        return trainStationTable.replace(trainStationId, trainStation);
    }

    public TrainStation removeTrainStation(String id)
    {
        return trainStationTable.remove(id);
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
    }

    public Payment replacePayment(Payment payment)
    {
        String paymentId = payment.getId();
        if (!paymentTable.containsKey(paymentId))
        {
            System.out.println("No payment with id " + paymentId + " exists in the database.");
            return null;
        }

        return paymentTable.replace(paymentId, payment);
    }

    public Payment removePayment(String id)
    {
        return paymentTable.remove(id);
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
    }

    public Reservation replaceReservation(Reservation reservation)
    {
        String reservationNumber = reservation.getReservationNumber();
        if (!reservationTable.containsKey(reservationNumber))
        {
            System.out.println("No reservation with number " + reservationNumber + " exists in the database.");
            return null;
        }

        return reservationTable.replace(reservationNumber, reservation);
    }

    public Reservation removeReservation(String reservationNumber)
    {
        return reservationTable.remove(reservationNumber);
    }

    public Reservation getReservation(String reservationNumber)
    {
        return reservationTable.get(reservationNumber);
    }

    public Enumeration<Reservation> getAllReservations()
    {
        return reservationTable.elements();
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
