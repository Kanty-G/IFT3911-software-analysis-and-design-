package TravelBookingSystem.Default;

public interface PricingStrategy
{

    /**
     * 
     * @param s
     * @param c
     */
    float setSectionPrice(Section s, Compagny c);

}