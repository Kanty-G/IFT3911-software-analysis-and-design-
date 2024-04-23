package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Vehicle.Section.Section;

import java.io.Serializable;
import java.util.ArrayList;

public class Airplane extends TransportVehicle implements Serializable
{
    private static final long serialVersionUID = 1L;

    public Airplane() { } // For Serialization

    public Airplane(String id, ArrayList<Section> sections)
    {
        super(id, sections);
    }
}