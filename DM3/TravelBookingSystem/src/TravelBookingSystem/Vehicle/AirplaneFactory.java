package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Vehicle.Section.Section;
import TravelBookingSystem.Vehicle.Section.SectionBuilder;

import java.util.ArrayList;

public class AirplaneFactory implements TransportVehicleFactory
{
    private static AirplaneFactory instance;
    private SectionBuilder sectionBuilder = new SectionBuilder();

    public static AirplaneFactory getInstance()
    {
        if (instance == null)
            instance = new AirplaneFactory();

        return instance;
    }

    public Airplane createTransportVehicle()
    {
        ArrayList<Section> sections = sectionBuilder.getSections();
        return new Airplane();
    }
}
