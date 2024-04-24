package TravelBookingSystem.Payment;

import java.io.Serializable;
import java.util.Date;

public class Payment implements Serializable
{
    private String id;
    private Date date;
    private CreditCard creditCard;
    private Passenger client;

    public Payment(Date date, CreditCard creditCard, Passenger client, String id)
    {
        this.date = date;
        this.creditCard = creditCard;
        this.client = client;
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public Date getDate()
    {
        return date;
    }

    public CreditCard getCreditCard()
    {
        return creditCard;
    }

    public Passenger getClient()
    {
        return client;
    }
}