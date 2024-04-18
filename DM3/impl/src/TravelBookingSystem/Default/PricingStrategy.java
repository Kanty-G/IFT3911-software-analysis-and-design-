package TravelBookingSystem.Default;

import TravelBookingSystem.Company.Company;
import TravelBookingSystem.Vehicle.Section;

public interface PricingStrategy
{

    /**
     * 
     * @param s
     * @param c
     */
    float setSectionPrice(Section s, Company c);

}