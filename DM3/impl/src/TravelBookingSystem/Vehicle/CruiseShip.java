package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Vehicle.Section.Section;

import java.io.Serializable;
import java.util.ArrayList;

public class CruiseShip extends TransportVehicle implements Serializable
{
    private static final long serialVersionUID = 1L;

    public CruiseShip() { } // For Serialization

    public CruiseShip(String id, ArrayList<Section> sections)
    {
        super(id, sections);
    }
}