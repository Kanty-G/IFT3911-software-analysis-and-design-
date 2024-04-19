package TravelBookingSystem.Database;

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

    public void ClearDatabase()
    {
        clearTables();
        saveDatabase();
    }

    public void addAirplane(Airplane airplane)
    {
        if (airplaneTable.contains(airplane))
        {
            System.out.println("Airplane already exists in the database.");
            return;
        }

        airplaneTable.put(airplane.getId(), airplane);
    }

    public void setAirplane(Airplane airplane)
    {
        String airplaneId = airplane.getId();
        if (!airplaneTable.containsKey(airplaneId))
        {
            System.out.println("No airplane with id " + airplaneId + " exists in the database.");
            return;
        }

        airplaneTable.replace(airplaneId, airplane);
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
        if (airportCompanyTable.contains(airportCompany))
        {
            System.out.println("AirportCompany already exists in the database.");
            return;
        }

        airportCompanyTable.put(airportCompany.getId(), airportCompany);
    }

    public void setAirportCompany(AirportCompany airportCompany)
    {
        String airportCompanyId = airportCompany.getId();
        if (!airportCompanyTable.containsKey(airportCompanyId))
        {
            System.out.println("No airportCompany with id " + airportCompanyId + " exists in the database.");
            return;
        }

        airportCompanyTable.replace(airportCompanyId, airportCompany);
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
        if (airportTable.contains(airport))
        {
            System.out.println("Airport already exists in the database.");
            return;
        }

        airportTable.put(airport.getId(), airport);
    }

    public void setAirport(Airport airport)
    {
        String airportId = airport.getId();
        if (!airportTable.containsKey(airportId))
        {
            System.out.println("No airport with id " + airportId + " exists in the database.");
            return;
        }

        airportTable.replace(airportId, airport);
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
        if (cruiseCompanyTable.contains(cruiseCompany))
        {
            System.out.println("CruiseCompany already exists in the database.");
            return;
        }

        cruiseCompanyTable.put(cruiseCompany.getId(), cruiseCompany);
    }

    public void setCruiseCompany(CruiseCompany cruiseCompany)
    {
        String cruiseCompanyId = cruiseCompany.getId();
        if (!cruiseCompanyTable.containsKey(cruiseCompanyId))
        {
            System.out.println("No cruiseCompany with id " + cruiseCompanyId + " exists in the database.");
            return;
        }

        cruiseCompanyTable.replace(cruiseCompanyId, cruiseCompany);
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
        if (itineraryTable.contains(itinerary))
        {
            System.out.println("Itinerary already exists in the database.");
            return;
        }

        itineraryTable.put(itinerary.getId(), itinerary);
    }

    public void setCruiseItinerary(CruiseItinerary itinerary)
    {
        String itineraryId = itinerary.getId();
        if (!itineraryTable.containsKey(itineraryId))
        {
            System.out.println("No itinerary with id " + itineraryId + " exists in the database.");
            return;
        }

        itineraryTable.replace(itineraryId, itinerary);
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
        if (cruiseShipTable.contains(cruiseShip))
        {
            System.out.println("CruiseShip already exists in the database.");
            return;
        }

        cruiseShipTable.put(cruiseShip.getId(), cruiseShip);
    }

    public void setCruiseShip(CruiseShip cruiseShip)
    {
        String cruiseShipId = cruiseShip.getId();
        if (!cruiseShipTable.containsKey(cruiseShipId))
        {
            System.out.println("No cruiseShip with id " + cruiseShipId + " exists in the database.");
            return;
        }

        cruiseShipTable.replace(cruiseShipId, cruiseShip);
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
        if (flightTable.contains(flight))
        {
            System.out.println("Flight already exists in the database.");
            return;
        }

        flightTable.put(flight.getId(), flight);
    }

    public void setFlight(Flight flight)
    {
        String flightId = flight.getId();
        if (!flightTable.containsKey(flightId))
        {
            System.out.println("No flight with id " + flightId + " exists in the database.");
            return;
        }

        flightTable.replace(flightId, flight);
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
        if (harborTable.contains(harbor))
        {
            System.out.println("Harbor already exists in the database.");
        }
    }

    public void setHarbor(Harbor harbor)
    {
        String harborId = harbor.getId();
        if (!harborTable.containsKey(harborId))
        {
            System.out.println("No harbor with id " + harborId + " exists in the database.");
            return;
        }

        harborTable.replace(harborId, harbor);
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
        if (trainCompanyTable.contains(trainCompany))
        {
            System.out.println("TrainCompany already exists in the database.");
            return;
        }

        trainCompanyTable.put(trainCompany.getId(), trainCompany);
    }

    public void setTrainCompany(TrainCompany trainCompany)
    {
        String trainCompanyId = trainCompany.getId();
        if (!trainCompanyTable.containsKey(trainCompanyId))
        {
            System.out.println("No trainCompany with id " + trainCompanyId + " exists in the database.");
            return;
        }

        trainCompanyTable.replace(trainCompanyId, trainCompany);
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
        if (trainTable.contains(train))
        {
            System.out.println("Train already exists in the database.");
            return;
        }

        trainTable.put(train.getId(), train);
    }

    public void setTrain(Train train)
    {
        String trainId = train.getId();
        if (!trainTable.containsKey(trainId))
        {
            System.out.println("No train with id " + trainId + " exists in the database.");
            return;
        }

        trainTable.replace(trainId, train);
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
        if (routeTable.contains(trainRoute))
        {
            System.out.println("Route already exists in the database.");
            return;
        }

        routeTable.put(trainRoute.getId(), trainRoute);
    }

    public void setTrainRoute(TrainRoute trainRoute)
    {
        String routeId = trainRoute.getId();
        if (!routeTable.containsKey(routeId))
        {
            System.out.println("No route with id " + routeId + " exists in the database.");
            return;
        }

        routeTable.replace(routeId, trainRoute);
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
        if (trainStationTable.contains(trainStation))
        {
            System.out.println("TrainStation already exists in the database.");
            return;
        }

        trainStationTable.put(trainStation.getId(), trainStation);
    }

    public void setTrainStation(TrainStation trainStation)
    {
        String trainStationId = trainStation.getId();
        if (!trainStationTable.containsKey(trainStationId))
        {
            System.out.println("No trainStation with id " + trainStationId + " exists in the database.");
            return;
        }

        trainStationTable.replace(trainStationId, trainStation);
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
        if (paymentTable.contains(payment))
        {
            System.out.println("Payment already exists in the database.");
            return;
        }

        paymentTable.put(payment.getId(), payment);
    }

    public void setPayment(Payment payment)
    {
        String paymentId = payment.getId();
        if (!paymentTable.containsKey(paymentId))
        {
            System.out.println("No payment with id " + paymentId + " exists in the database.");
            return;
        }

        paymentTable.replace(paymentId, payment);
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
        if (reservationTable.contains(reservation))
        {
            System.out.println("Reservation already exists in the database.");
            return;
        }

        reservationTable.put(reservation.getReservationNumber(), reservation);
    }

    public void setReservation(Reservation reservation)
    {
        String reservationNumber = reservation.getReservationNumber();
        if (!reservationTable.containsKey(reservationNumber))
        {
            System.out.println("No reservation with number " + reservationNumber + " exists in the database.");
            return;
        }

        reservationTable.replace(reservationNumber, reservation);
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
