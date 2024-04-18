package TravelBookingSystem.Vehicle;

public class Seat extends TravelSpace
{
    private final int row;
    private final char column;
    private final SeatType seatType;

    public Seat(int row, char column, SeatType seatType)
    {
        this.row = row;
        this.column = column;
        this.seatType = seatType;
    }

    public int getRow()
    {
        return row;
    }

    public char getColumn()
    {
        return column;
    }

    public SeatType getSeatType()
    {
        return seatType;
    }
}