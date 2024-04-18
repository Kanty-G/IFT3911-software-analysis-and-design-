package TravelBookingSystem.Reservation;

import TravelBookingSystem.Vehicle.Section;

import java.util.Date;

public class Reservation
{
    private final int reservationNumber;
    private String travelId;
    private String travelSpaceId;
    private Section section;
    private SeatingPreference seatingPreference;
    private Date reservationDate;
    private boolean isConfirmed = false;

    public Reservation(int reservationNumber, String travelId, String travelSpaceId, Section section, SeatingPreference seatingPreference, Date reservationDate)
    {
        this.reservationNumber = reservationNumber;
        this.travelId = travelId;
        this.travelSpaceId = travelSpaceId;
        this.section = section;
        this.seatingPreference = seatingPreference;
        this.reservationDate = reservationDate;
    }

    public int getReservationNumber()
    {
        return reservationNumber;
    }

    public String getTravelId()
    {
        return travelId;
    }

    public String getTravelSpaceId()
    {
        return travelSpaceId;
    }

    public Section getSection()
    {
        return section;
    }

    public SeatingPreference getSeatingPreference()
    {
        return seatingPreference;
    }

    public Date getReservationDate()
    {
        return reservationDate;
    }

    public boolean getIsConfirmed()
    {
        return isConfirmed;
    }

    public void Confirm()
    {
        isConfirmed = true;
    }
}