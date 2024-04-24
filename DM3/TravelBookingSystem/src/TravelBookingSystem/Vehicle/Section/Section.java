package TravelBookingSystem.Vehicle.Section;

import TravelBookingSystem.Travel.Visitor.TravelVisitor;
import TravelBookingSystem.Travel.Visitor.Visitable;

import java.io.Serializable;
import java.util.ArrayList;

public class Section implements Serializable, Visitable
{
    private static final long serialVersionUID = 1L;

    private Category sectionCategory;
    private String sectionId;
    private float priceRate;
    private ArrayList<TravelSpace> travelSpaces;

    public Section() { } // For Serialization

    public Section(Category sectionCategory, float priceRate, String sectionId, ArrayList<TravelSpace> travelSpaces)
    {
        this.sectionCategory = sectionCategory;
        this.priceRate = priceRate;
        this.sectionId = sectionId;
        this.travelSpaces = travelSpaces;
    }

    public Category getSectionCategory()
    {
        return sectionCategory;
    }

    public String getSectionId()
    {
        return sectionId;
    }

    public float getPriceRate()
    {
        return priceRate;
    }

    public ArrayList<TravelSpace> getTravelSpaces()
    {
        return travelSpaces;
    }

    public int getAvailableSpaces()
    {
        int availableSpaces = 0;

        for (TravelSpace space : travelSpaces)
        {
            if (space.isAvailable())
            {
                availableSpaces++;
            }
        }

        return availableSpaces;
    }

    public int getTotalSpaces()
    {
        return travelSpaces.size();
    }

    public void accept(TravelVisitor visitor)
    {
        visitor.visit(this);
    }
}