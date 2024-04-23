package TravelBookingSystem.Travel;

import TravelBookingSystem.Infrastructure.Infrastructure;
import TravelBookingSystem.Vehicle.TransportVehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class TrainRoute extends Travel implements Serializable
{
    private static final long serialVersionUID = 1L;

    public TrainRoute() { } // For Serialization

    public TrainRoute(String id, String companyId, double price, Date departureTime, Date arrivalTime, TransportVehicle transportVehicle, ArrayList<Infrastructure> stopovers)
    {
        super(id, companyId, price, departureTime, arrivalTime, transportVehicle, stopovers);
    }
}