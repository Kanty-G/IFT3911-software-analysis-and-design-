package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Vehicle.Section.Section;

import java.io.Serializable;
import java.util.ArrayList;

public class Train extends TransportVehicle implements Serializable
{
    private static final long serialVersionUID = 1L;

    public Train() { } // For Serialization

    public Train(String id, ArrayList<Section> sections)
    {
        super(id, sections);
    }
}