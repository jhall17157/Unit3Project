import java.time.LocalTime;

public class LostTicket extends Ticket implements TicketStrategy  {
    @Override
    public Double charge() {
        return 25.0;
    }

    @Override
    public int getTime() {
        return 0;
    }


    @Override
    public LocalTime getCheckOut() {
        return null;
    }

    @Override
    public void setCheckOut() {

    }

    @Override
    public void setCheckIn() {
       checkIn();
    }

    @Override
    public LocalTime getCheckIn() {
        return null;
    }
}
