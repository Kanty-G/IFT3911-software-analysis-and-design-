package TravelBookingSystem.Vehicle.Section;

import java.util.ArrayList;

public class SectionBuilder
{
    private ArrayList<Section> sections;

    public ArrayList<Section> getSections()
    {
        return sections;
    }

    public SectionBuilder WithFirstClass(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.FIRST, priceRate, "F", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder WithBusinessClass(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.BUSINESS, priceRate, "A", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder WithEconomyClass(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.ECONOMY, priceRate, "E", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder WithEconomyPremiumClass(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.ECONOMY_PREMIUM, priceRate, "P", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder WithInnerSection(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.INNER, priceRate, "I", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder WithOceanViewSection(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.OCEAN_VIEW, priceRate, "O", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder WithSuiteSection(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.SUITE, priceRate, "S", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder WithFamilySection(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.FAMILY, priceRate, "F", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder WithFamilyDeluxeSection(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.FAMILY_DELUXE, priceRate, "D", travelSpacesFactory.createTravelSpaces()));
        return this;
    }
}
