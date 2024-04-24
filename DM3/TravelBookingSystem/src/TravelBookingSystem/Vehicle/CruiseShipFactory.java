package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Vehicle.Section.Section;
import TravelBookingSystem.Vehicle.Section.SectionBuilder;

import java.util.ArrayList;

public class CruiseShipFactory implements TransportVehicleFactory
{
    private static CruiseShipFactory instance;
    private SectionBuilder sectionBuilder = new SectionBuilder();

    public static CruiseShipFactory getInstance()
    {
        if (instance == null)
            instance = new CruiseShipFactory();

        return instance;
    }

    public CruiseShip createTransportVehicle()
    {
        ArrayList<Section> sections = sectionBuilder.getSections();
        return new CruiseShip();
    }
}
