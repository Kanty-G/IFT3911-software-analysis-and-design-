package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Vehicle.Section.SectionBuilder;

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
        var sections = sectionBuilder.getSections();
        return new Train();
    }
}
