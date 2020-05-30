import java.time.LocalTime;

public interface TicketStrategyFactory {
    TicketStrategy getTicketStrategy (String type);
}
