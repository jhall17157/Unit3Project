import java.time.LocalTime;

public class SpecialTicket extends Ticket implements TicketStrategy {
    @Override
    public Double charge() {
        return 20.0;
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

    }

    @Override
    public LocalTime getCheckIn() {
        return checkIn();
    }


}
