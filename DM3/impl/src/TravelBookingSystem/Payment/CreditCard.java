package TravelBookingSystem.Payment;

import java.util.Date;

public class CreditCard
{
    private final String name;
    private final String cardNumber;
    private final String cvv;
    private final Date expDate;

    public CreditCard(String name, String cardNumber, String cvv, Date expDate)
    {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expDate = expDate;
    }

    public String getName()
    {
        return name;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public String getCvv()
    {
        return cvv;
    }

    public Date getExpDate()
    {
        return expDate;
    }
}