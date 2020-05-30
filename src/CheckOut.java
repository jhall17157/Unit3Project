import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.Scanner;

public class CheckOut {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        Garage garage = new Garage();
     //   File file = new File("garage.txt");
       // Scanner reader = new Scanner(file);
//        while(reader.hasNext()) {
//                String line = reader.nextLine();
//               String ticketArray [] = line.split(",");
//
//                LocalTime time1;
//                        if (!ticketArray[1].equals("null")) {
//                        time1 =LocalTime.parse(ticketArray[1]);
//                        } else {
//                            time1 = null;
//                        }
//                 LocalTime time2;
//            if (!ticketArray[2].equals("null")) {
//                    time2 = LocalTime.parse(ticketArray[2]);
//                } else {
//                   time2 = null;
//        }
//                TicketStrategy ticket = new RegularTicket();
//                garage.addTicket(ticket);
//
//        }


        RegularTicket  firstCar = new RegularTicket();
        RegularTicket secondCar = new RegularTicket();
        SpecialTicket specialCar = new SpecialTicket();
        LostTicket lostCar = new LostTicket();

        firstCar.setCarId(1);
        secondCar.setCarId(2);
        specialCar.setCarId(3);
        lostCar.setCarId(4);

        firstCar.setCheckIn();
        secondCar.setCheckIn();
        lostCar.setCheckIn();

        firstCar.setCheckOut();
        secondCar.setCheckOut();

        garage.addTicket(firstCar);
        garage.addTicket(secondCar);
        garage.addTicket(specialCar);
        garage.addTicket(lostCar);

        System.out.println("Best Value Parking Garage ========================= \n4 – Check-Out \n5 – Lost Ticket");

        String choice = keyboard.nextLine();
        while (!choice.equals("4") && !choice.equals("5")) {
            System.out.println("Enter a valid choice");
            choice = keyboard.nextLine();
        }
        int id;
        TicketStrategy customerTicket = TicketStrategyFactoryImp.INSTANCE.getTicketStrategy(choice);
            if (choice.equals("4")) {
                System.out.println("Enter your car's Id");
                id = Integer.parseInt(keyboard.nextLine());
                customerTicket = garage.getTicket(id - 1);
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
                customerTicket.setCheckOut();
                int time = customerTicket.getTime();
                System.out.println("The amount of hours passed has been " + time);
                System.out.println("It is $5 for the first three hours and $1 per extra hour");
                customerTicket.charge();
                System.out.println("Your total is $" + time);
               // PrintWriter pw = new PrintWriter(file);
//                for (int i = 0; i < garage.getLength(); i++) {
//                    pw.println(garage.getTicket(i).toString());
//                }
            } else {

                 do{
                    System.out.println("Enter the ID for your Vehicle");
                    id = Integer.parseInt(keyboard.nextLine());
                    for (int i = 0; i < garage.getLength(); i++) {
                        if (garage.getCarId(i + 1) == id) {
                            System.out.println("Car found");
                             customerTicket =garage.getTicket(i);
                            break;
                        }
                    }
                }while (customerTicket == null);
                System.out.println("The receipt for Vehicle " + id);
                System.out.println("Lost ticket");
                Double total = customerTicket.charge();
                System.out.println("$" + total);
            }
    }
}
