package TravelBookingSystem.Company;

import java.io.Serializable;

public class Company implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public Company() { } // For Deserialization

    public Company(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public CompanyMemento getMemento()
    {
        return new CompanyMemento(name);
    }

    public void restoreFromMemento(CompanyMemento memento)
    {
        name = memento.getName();
    }

    @Override
    public String toString()
    {
        return "Company{" + "id=" + id + ", name=" + name + '}';
    }

    public static boolean isValidId(String id)
    {
        return id != null && id.length() <= 6;
    }
}