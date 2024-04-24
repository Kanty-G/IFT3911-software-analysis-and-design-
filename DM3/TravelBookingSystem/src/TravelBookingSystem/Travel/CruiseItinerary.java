package TravelBookingSystem.Travel;

import TravelBookingSystem.Infrastructure.Infrastructure;
import TravelBookingSystem.Vehicle.TransportVehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class CruiseItinerary extends Travel implements Serializable
{
    private static final long serialVersionUID = 1L;

    public CruiseItinerary() { } // For Serialization

    public CruiseItinerary(String id, String companyId, double price, Date departureTime, Date arrivalTime, TransportVehicle transportVehicle, ArrayList<Infrastructure> stopovers)
    {
        super(id, companyId, price, departureTime, arrivalTime, transportVehicle, stopovers);
    }
}