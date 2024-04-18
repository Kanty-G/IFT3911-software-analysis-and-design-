package TravelBookingSystem.Vehicle;

public class Section
{

    private final Category category;
    private int priceRate;
    private double price;
    private final String sectionId;

    public Section(Category category, int priceRate, double price, String sectionId)
    {
        this.category = category;
        this.priceRate = priceRate;
        this.price = price;
        this.sectionId = sectionId;
    }

    public Category getCategory()
    {
        return category;
    }

    public int getPriceRate()
    {
        return priceRate;
    }

    public double getPrice()
    {
        return price;
    }

    public String getSectionId()
    {
        return sectionId;
    }
}