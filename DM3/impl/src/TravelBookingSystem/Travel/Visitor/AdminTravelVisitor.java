package TravelBookingSystem.Travel.Visitor;

import TravelBookingSystem.Travel.Travel;
import TravelBookingSystem.Vehicle.Section.Section;

public class AdminTravelVisitor implements TravelVisitor
{
    private String travelString = "";
    private double travelPrice = 0.0;

    public void visit(Travel travel)
    {
        travelPrice = travel.getPrice();
        travelString += travel.getDepartureInfrastructure().getId() + "-" + travel.getArrivalInfrastructure().getId();
        travelString += ":[" + travel.getCompanyId() + "]";
        travelString += travel.getId();
        travelString += "(" + travel.getDepartureTime() + "-" + travel.getArrivalTime() + ")";
    }

    public void visit(Section section)
    {
        travelString += "|" + section.getPriceRate() * travelPrice;
        travelString += "|" + section.getSectionId() + section.getAvailableSpaces();
    }

    public String getTravelString()
    {
        return travelString;
    }
}
