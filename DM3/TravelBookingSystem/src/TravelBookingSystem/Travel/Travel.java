package TravelBookingSystem.Travel;

import TravelBookingSystem.Infrastructure.Infrastructure;
import TravelBookingSystem.Travel.Visitor.TravelVisitor;
import TravelBookingSystem.Travel.Visitor.Visitable;
import TravelBookingSystem.Vehicle.TransportVehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public abstract class Travel implements Serializable, Visitable
{
    private static final long serialVersionUID = 1L;

    private String id;
    private String companyId;
    private double price;
    private Date departureTime;
    private Date arrivalTime;
    private TransportVehicle transportVehicle;
    private ArrayList<Infrastructure> stopovers;

    public Travel() { } // For Serialization

    public Travel(String id, String companyId, double price, Date departureTime, Date arrivalTime, TransportVehicle transportVehicle, ArrayList<Infrastructure> stopovers)
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

    public Infrastructure getDepartureInfrastructure()
    {
        return stopovers.get(0);
    }

    public Infrastructure getArrivalInfrastructure()
    {
        return stopovers.get(stopovers.size() - 1);
    }

    public ArrayList<Infrastructure> getStopovers()
    {
        return stopovers;
    }

    public TravelMemento getMemento()
    {
        return new TravelMemento(id, companyId, price, departureTime, arrivalTime, transportVehicle, stopovers);
    }

    public void restoreFromMemento(TravelMemento memento)
    {
        this.id = memento.getId();
        this.companyId = memento.getCompanyId();
        this.price = memento.getPrice();
        this.departureTime = memento.getDepartureTime();
        this.arrivalTime = memento.getArrivalTime();
        this.stopovers = memento.getStopovers();
    }

    public void accept(TravelVisitor visitor)
    {
        visitor.visit(this);
        transportVehicle.accept(visitor);
    }
}