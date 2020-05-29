import java.time.LocalTime;
import java.util.Random;

public class RegularTicket extends Ticket implements TicketStrategy {
    @Override
    public Double charge(double total) {
        return total;
    }
}
