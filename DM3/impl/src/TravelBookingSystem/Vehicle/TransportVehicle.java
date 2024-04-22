package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Vehicle.Section.Section;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class TransportVehicle implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;
    private ArrayList<Section> sections = new ArrayList<>();

    public TransportVehicle() { } // For Serialization

    public TransportVehicle(String id, ArrayList<Section> sections)
    {
        this.id = id;
        this.sections = sections;
    }

    public String getId()
    {
        return id;
    }

    public ArrayList<Section> getSections()
    {
        return sections;
    }
}