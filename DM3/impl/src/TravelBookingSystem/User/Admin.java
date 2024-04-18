package TravelBookingSystem.User;

public class Admin extends User
{
    private String password;

    public Admin(String firstName, String lastName, String email, String password)
    {
        super(firstName, lastName, email);
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
}