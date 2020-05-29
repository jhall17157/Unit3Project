import java.util.LinkedList;

public class Garage {
    private LinkedList<Ticket> garage;

    public Garage () {
        garage = new LinkedList<>();
    }

    public void addTicket(Ticket ticket) {
        garage.add(ticket);
    }
    public int getLength() {
        return garage.size();
    }
    public Ticket getTicket(int id) {
        return garage.get(id);
    }
    public LinkedList<Ticket> setGarage() {
        return garage;
    }

    public void setGarage(LinkedList<Ticket> garage) {
        this.garage = garage;
    }

//    public void lostTicket() {
//        System.out.println("Total is $25");
//        Ticket lostTicket = new Ticket();
//        lostTicket.setCarId(0);
//        garage.add(lostTicket);
//    }

    public int getMoney(int time) {
        int total;
        if (time <= 3) {
            total = 5;
        } else {
            int time2 = time - 3;
            total = time2 + 5;
        }
        return total;
    }


}
