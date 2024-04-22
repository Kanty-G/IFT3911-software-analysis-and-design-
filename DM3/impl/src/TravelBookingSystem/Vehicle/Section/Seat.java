package TravelBookingSystem.Vehicle.Section;

import java.io.Serializable;

public class Seat extends TravelSpace implements Serializable
{
    private static final long serialVersionUID = 1L;

    private int row;
    private char column;

    public Seat()
    {
    } // For Serialization

    public Seat(int row, char column)
    {
        this.row = row;
        this.column = column;
    }

    public int getRow()
    {
        return row;
    }

    public char getColumn()
    {
        return column;
    }
}