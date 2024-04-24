package TravelBookingSystem.Travel;

import TravelBookingSystem.Infrastructure.Infrastructure;
import TravelBookingSystem.Vehicle.TransportVehicle;

import java.util.ArrayList;
import java.util.Date;

public class TravelMemento
{
    private String id;
    private String companyId;
    private double price;
    private Date departureTime;
    private Date arrivalTime;
    private TransportVehicle transportVehicle;
    private ArrayList<Infrastructure> stopovers;

    public TravelMemento(String id, String companyId, double price, Date departureTime, Date arrivalTime, TransportVehicle transportVehicle, ArrayList<Infrastructure> stopovers)
    {
        this.id = id;
        this.companyId = companyId;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.transportVehicle = transportVehicle;
        this.stopovers = stopovers;
    }

    public String getId()
    {
        return id;
    }

    public double getPrice()
    {
        return price;
    }

    public String getCompanyId()
    {
        return companyId;
    }

    public Date getDepartureTime()
    {
        return departureTime;
    }

    public Date getArrivalTime()
    {
        return arrivalTime;
    }

    public ArrayList<Infrastructure> getStopovers()
    {
        return stopovers;
    }
}
