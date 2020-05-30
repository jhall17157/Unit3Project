import java.time.LocalTime;

public enum TicketStrategyFactoryImp implements TicketStrategyFactory {
    INSTANCE;


    @Override
    public TicketStrategy getTicketStrategy(String type) {
        if (type.equals("1") || type.equals("4")) {
            return new RegularTicket();
        } else if (type.equals("2")) {
            return new SpecialTicket();
        } else if (type.equals("3")) {
             return null;
        }
        else if (type.equals("5")) {
           return new LostTicket();
        } else {
            return null;
        }
    }
}
