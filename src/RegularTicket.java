import java.time.LocalTime;
import java.util.Random;

public class RegularTicket extends Ticket implements TicketStrategy {
    @Override
    public Double charge() {
        int diff = diffOfHours();
        if (diff < 3) {
            return 5.0 + (diff - 3);
        } else {
            return 5.0;
        }
    }

    @Override
    public int getTime() {
        return diffOfHours();
    }


    @Override
    public LocalTime getCheckOut() {
        return checkOut();
    }

    @Override
    public void setCheckOut() {
        checkOut();
    }

    @Override
    public void setCheckIn() {
        checkIn();
    }

    @Override
    public LocalTime getCheckIn() {
        return checkIn();
    }
}
