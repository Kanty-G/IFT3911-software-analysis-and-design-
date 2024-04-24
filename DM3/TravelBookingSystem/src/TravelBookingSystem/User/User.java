package TravelBookingSystem.User;

public abstract class User
{
    private final String firstName;
    private final String lastName;
    private String email;

    public User(String firstName, String lastName, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    public String getEmail()
    {
        return email;
    }
}
