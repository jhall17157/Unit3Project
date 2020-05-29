public class SpecialTicket extends Ticket implements TicketStrategy {
    @Override
    public Double charge(double total) {
        return 20.0;
    }


}
