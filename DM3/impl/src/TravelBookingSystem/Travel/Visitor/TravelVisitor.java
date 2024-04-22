package TravelBookingSystem.Travel.Visitor;

import TravelBookingSystem.Travel.Travel;
import TravelBookingSystem.Vehicle.Section.Section;

public interface TravelVisitor
{
    void visit(Travel travel);

    void visit(Section section);
}
