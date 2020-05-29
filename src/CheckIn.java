import java.io.*;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Scanner;

public class CheckIn {
    public static void main(String[] args) throws IOException {
        //Setting up the garage for  close out
        File file = new File("garage.txt");
        BufferedWriter fw = new BufferedWriter(new FileWriter(file));
        RegularTicket  firstCar = new RegularTicket();
         RegularTicket secondCar = new RegularTicket();
        SpecialTicket specialCar = new SpecialTicket();
        LostTicket lostCar = new LostTicket();

        firstCar.setCarId(1);
        secondCar.setCarId(2);
        specialCar.setCarId(3);
        lostCar.setCarId(4);


        firstCar.setCheckIn(firstCar.checkIn());
        secondCar.setCheckIn(secondCar.checkIn());
        lostCar.setCheckIn(lostCar.checkIn());

        firstCar.setCheckOut(firstCar.checkOut());
        secondCar.setCheckOut(secondCar.checkOut());



        fw.write(firstCar.getCarId() + "," + firstCar.getCheckIn() + "," + firstCar.getCheckOut());
        fw.newLine();
        fw.write(secondCar.getCarId() + "," + secondCar.getCheckIn() + "," + secondCar.getCheckOut());
        fw.newLine();
        fw.write(specialCar.getCarId() + "," + specialCar.getCheckIn() + "," + specialCar.getCheckOut());
        fw.newLine();
        fw.write(lostCar.getCarId() + "," + lostCar.getCheckIn() + "," + lostCar.getCheckOut());
        fw.newLine();
        //Actual Machine

        Garage garage = new Garage();
        Scanner sr = new Scanner(file);
       garage.addTicket(firstCar);
       garage.addTicket(secondCar);
       garage.addTicket(specialCar);
       garage.addTicket(lostCar);



        System.out.println("Best Value Parking Garage ========================= \n 1 - CheckIn \n 2 - Special Event  \n 3 - Close garage");
        Scanner keyboard = new Scanner(System.in);
        String choice = keyboard.nextLine();
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
            System.out.println("Enter a valid choice");
            choice = keyboard.nextLine();
        }
        if (choice.equals("1")) {
            //Enter the ticketing information
            Ticket customerTicket = new Ticket();
            int customerId = garage.getLength() + 1;
            System.out.println("Car ID: " + customerId);
            customerTicket.setCheckIn(customerTicket.checkIn());

            LocalTime customerTime = customerTicket.getCheckIn();
            System.out.println("Check In Time: " + customerTime);
            fw.write(customerId + "," + customerTicket.getCheckIn() + "," + null);
            fw.newLine();

        } else if (choice.equals("2")){
            SpecialTicket sp = new SpecialTicket();
            int customerId = garage.getLength() + 1;
            System.out.println("Car ID: " + customerId);
            System.out.println("Receipt for vehicle" + customerId);
            System.out.println("Special Event");
            double total = sp.charge(20);
            System.out.println("$" + total);
            garage.addTicket(sp);
            fw.write(sp.getCarId() + "," + null + "," + null);
        }else {
            //close the garage
            int total = 0;
            int regularCount = 0;
            int specialCount = 0;
            int lostCount = 0;
            for (int i = 0; i < garage.getLength(); i++) {
                Ticket closeTicket = garage.getTicket(i);
                if (closeTicket.getCheckIn() == null) {
                    specialCount ++;
                    total += 20;
                } else if (closeTicket.getCheckOut() == null) {
                    total += 25;
                    lostCount ++;
                }else
                {
                    int diffTime = closeTicket.diffOfHours(closeTicket.getCheckIn(), closeTicket.getCheckOut());
                    total += garage.getMoney(diffTime);
                    regularCount ++;
                }
            }
            System.out.println("The total amount of money earned was $" + total);
            System.out.println("Timed Cars: " + regularCount + "\nSpecial Event: " + specialCount + "\nLost Ticket: " + lostCount);
        }
        fw.close();
    }
}
