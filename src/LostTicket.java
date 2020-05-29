public class LostTicket extends Ticket implements TicketStrategy  {
    @Override
    public Double charge(double total) {
        return 25.0;
    }
}
