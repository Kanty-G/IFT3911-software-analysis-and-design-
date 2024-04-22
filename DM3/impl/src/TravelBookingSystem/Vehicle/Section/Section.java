package TravelBookingSystem.Vehicle.Section;

import java.io.Serializable;
import java.util.ArrayList;

public class Section implements Serializable
{
    private static final long serialVersionUID = 1L;

    private float priceRate;
    private String sectionId;
    private ArrayList<TravelSpace> travelSpaces;

    public Section(float priceRate, String sectionId, ArrayList<TravelSpace> travelSpaces)
    {
        this.priceRate = priceRate;
        this.sectionId = sectionId;
        this.travelSpaces = travelSpaces;
    }

    public float getPriceRate()
    {
        return priceRate;
    }

    public String getSectionId()
    {
        return sectionId;
    }

    public ArrayList<TravelSpace> getTravelSpaces()
    {
        return travelSpaces;
    }
}