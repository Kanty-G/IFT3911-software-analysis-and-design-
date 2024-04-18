package TravelBookingSystem.User;

public class Client extends User
{
    private final String passportNumber;

    public Client(String passportNumber, String firstName, String lastName, String email)
    {
        super(firstName, lastName, email);
        this.passportNumber = passportNumber;
    }

    public String getPassportNumber()
    {
        return passportNumber;
    }
}