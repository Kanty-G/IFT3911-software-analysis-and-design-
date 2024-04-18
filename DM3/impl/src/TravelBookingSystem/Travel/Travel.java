package TravelBookingSystem.Travel;

import TravelBookingSystem.Infrastructure.Infrastructure;

import java.util.ArrayList;
import java.util.Date;

public abstract class Travel
{

    private String id;
    private Date dateArrive;
    private String heureArrivee;
    private String heureDepart;
    private Date dateDepart;
    private ArrayList<Infrastructure> escales;
    private String duree;

    public String getId()
    {
        return id;
    }
}