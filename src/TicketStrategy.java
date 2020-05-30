import java.time.LocalTime;

public interface TicketStrategy {

    Double charge();

    int getTime();

    LocalTime getCheckOut();

   void setCheckOut();

    void setCheckIn();

    LocalTime getCheckIn();
}
