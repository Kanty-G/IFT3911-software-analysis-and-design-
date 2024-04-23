package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Vehicle.Section.SectionBuilder;

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
        var sections = sectionBuilder.getSections();
        return new Airplane();
    }
}
