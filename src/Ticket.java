
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Random;


public class Ticket {
    private LocalTime checkIn;
    private LocalTime checkOut;
    private int carId;

    public Ticket() {
        checkIn = null;
        carId = 0;
    }
    public Ticket(int id, LocalTime checkIn, LocalTime checkOut) {
        this.carId = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalTime checkOut) {
        this.checkOut = checkOut;
    }

    public Ticket(LocalTime checkIn, int carId) {
        this.checkIn = checkIn;
        this.carId = carId;
    }

    public void setCheckIn(LocalTime checkIn) {

        this.checkIn = checkIn;
    }
    public LocalTime getCheckIn() {
        return checkIn;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public LocalTime checkIn() {
        Random r = new Random();
        int hour =  r.nextInt((11 - 6) + 1) + 6;
        return checkIn = LocalTime.of(hour, 0);
    }
    public LocalTime checkOut() {
        Random r = new Random();
        int hour =  r.nextInt((22 - 12) + 1) + 12;

        return checkOut = LocalTime.of(hour,0);
    }
    public int diffOfHours(LocalTime checkIn, LocalTime checkOut) {
        int checkInHours = checkIn.getHour();
        int checkOutHours = checkOut.getHour();
        return checkOutHours - checkInHours;
    }
    public String toString(Ticket ticket) {
        return ticket.getCarId() + "," + ticket.getCheckIn() + "," + ticket.checkOut();
    }


}
