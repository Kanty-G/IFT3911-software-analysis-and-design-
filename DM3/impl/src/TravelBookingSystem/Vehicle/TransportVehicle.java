package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Travel.Visitor.TravelVisitor;
import TravelBookingSystem.Travel.Visitor.Visitable;
import TravelBookingSystem.Vehicle.Section.Section;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class TransportVehicle implements Serializable, Visitable
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

    public void accept(TravelVisitor visitor)
    {
        for (Section section : sections)
        {
            section.accept(visitor);
        }
    }
}