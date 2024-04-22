package TravelBookingSystem.Travel.Visitor;

import TravelBookingSystem.Travel.Travel;
import TravelBookingSystem.Vehicle.Section.Category;
import TravelBookingSystem.Vehicle.Section.Section;

public class ClientTravelVisitor implements TravelVisitor
{
    private Category sectionCategory;

    private String travelString = "";
    private double travelPrice = 0.0;

    public ClientTravelVisitor(Category sectionCategory)
    {
        this.sectionCategory = sectionCategory;
    }

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
        travelString += "|" + section.getSectionId();
        travelString += "(" + section.getAvailableSpaces() + "/" + section.getTotalSpaces() + ")";
        travelString += section.getPriceRate() * travelPrice;
    }

    public String getTravelString()
    {
        return travelString;
    }
}
