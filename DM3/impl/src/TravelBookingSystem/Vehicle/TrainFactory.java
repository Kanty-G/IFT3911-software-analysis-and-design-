package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Vehicle.Section.Section;
import TravelBookingSystem.Vehicle.Section.SectionBuilder;

import java.util.ArrayList;

public class TrainFactory implements TransportVehicleFactory
{
    private static TrainFactory instance;
    private SectionBuilder sectionBuilder = new SectionBuilder();


    public static TrainFactory getInstance()
    {
        if (instance == null)
            instance = new TrainFactory();

        return instance;
    }

    public Train createTransportVehicle()
    {
        ArrayList<Section> sections = sectionBuilder.getSections();
        return new Train();
    }
}
