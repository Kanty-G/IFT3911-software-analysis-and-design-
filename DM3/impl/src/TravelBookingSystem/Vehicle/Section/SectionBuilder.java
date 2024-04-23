package TravelBookingSystem.Vehicle.Section;

import java.util.ArrayList;

public class SectionBuilder
{
    private ArrayList<Section> sections = new ArrayList<>();

    public ArrayList<Section> getSections()
    {
        return sections;
    }

    public SectionBuilder withFirstClass(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.FIRST, priceRate, "F", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder withBusinessClass(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.BUSINESS, priceRate, "A", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder withEconomyClass(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.ECONOMY, priceRate, "E", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder withEconomyPremiumClass(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.ECONOMY_PREMIUM, priceRate, "P", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder withInnerSection(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.INNER, priceRate, "I", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder withOceanViewSection(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.OCEAN_VIEW, priceRate, "O", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder withSuiteSection(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.SUITE, priceRate, "S", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder withFamilySection(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.FAMILY, priceRate, "F", travelSpacesFactory.createTravelSpaces()));
        return this;
    }

    public SectionBuilder withFamilyDeluxeSection(float priceRate, TravelSpacesFactory travelSpacesFactory)
    {
        sections.add(new Section(Category.FAMILY_DELUXE, priceRate, "D", travelSpacesFactory.createTravelSpaces()));
        return this;
    }
}
