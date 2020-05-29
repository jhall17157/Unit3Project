import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.Scanner;

public class CheckOut {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        Garage garage = new Garage();
        File file = new File("garage.txt");
        Scanner reader = new Scanner(file);
        while(reader.hasNext()) {
                String line = reader.nextLine();
               String ticketArray [] = line.split(",");

                LocalTime time1;
                        if (!ticketArray[1].equals("null")) {
                        time1 =LocalTime.parse(ticketArray[1]);
                        } else {
                            time1 = null;
                        }
                 LocalTime time2;
            if (!ticketArray[2].equals("null")) {
                    time2 = LocalTime.parse(ticketArray[2]);
                } else {
                   time2 = null;
                }
                Ticket ticket = new Ticket(Integer.parseInt(ticketArray[0]), time1, time2);
                garage.addTicket(ticket);

        }
        System.out.println("Best Value Parking Garage ========================= \n1 – Check-Out \n2 – Lost Ticket");

        String choice = keyboard.nextLine();
        while (!choice.equals("1") && !choice.equals("2")) {
            System.out.println("Enter a valid choice");
            choice = keyboard.nextLine();
        }
        int id;
            if (choice.equals("1")) {
                System.out.println("Enter your car's Id");
                id = Integer.parseInt(keyboard.nextLine());
                Ticket ticket = garage.getTicket(id - 1);
                while(garage.getTicket(id - 1) == null) {
                    System.out.println("Try again");
                    id= Integer.parseInt(keyboard.nextLine());
                    garage.getTicket(id -1 );
//                    while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
//                        System.out.println("Enter a valid response");
//                        choice = keyboard.nextLine();
//                    }
//                    if (choice.equalsIgnoreCase("y")) {
//                        System.out.println("Receipt for ");
//                    }
                }
                ticket.setCheckOut(ticket.checkOut());
                int time = ticket.diffOfHours(ticket.getCheckIn(), ticket.getCheckOut());
                System.out.println("The amount of hours passed has been " + time);
                System.out.println("It is $5 for the first three hours and $1 per extra hour");
                garage.getMoney(time);
                System.out.println("Your total is $" + time);
                PrintWriter pw = new PrintWriter(file);
                for (int i = 0; i < garage.getLength(); i++) {
                    pw.println(garage.getTicket(i).toString());
                }
            } else {
               LostTicket lost = null;


                 do{
                    System.out.println("Enter the ID for your Vehicle");
                    id = Integer.parseInt(keyboard.nextLine());
                    for (int i = 0; i < garage.getLength(); i++) {
                        if (garage.getTicket(i).getCarId() == id) {
                            System.out.println("Car found");
                            lost = (LostTicket) garage.getTicket(i);
                            break;
                        }
                    }
                }while (lost == null);
                System.out.println("The receipt for Vehicle " + id);
                System.out.println("Lost ticket");
                Double total = lost.charge(25);
                System.out.println("$" + total);
            }
    }
}
