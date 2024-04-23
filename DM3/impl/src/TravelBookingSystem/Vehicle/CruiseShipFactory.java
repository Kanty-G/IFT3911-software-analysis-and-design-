package TravelBookingSystem.Vehicle;

import TravelBookingSystem.Vehicle.Section.SectionBuilder;

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
        var sections = sectionBuilder.getSections();
        return new CruiseShip();
    }
}
