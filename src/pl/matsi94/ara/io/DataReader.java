package pl.matsi94.ara.io;

import pl.matsi94.ara.model.Destinations;
import pl.matsi94.ara.model.PassengerAccount;
import pl.matsi94.ara.model.Reservation;

import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public PassengerAccount createNewPassengerAccount(){
        printer.printLine("First name: ");
        String firstName = scanner.nextLine();
        printer.printLine("Last name: ");
        String lastName = scanner.nextLine();
        printer.printLine("ID number: ");
        String idNumber = scanner.nextLine();
        printer.printLine("Login: ");
        String login = scanner.nextLine();
        printer.printLine("Password: ");
        String password = scanner.nextLine();
        return new PassengerAccount(firstName, lastName, idNumber, login, password);
    }

    public int getInt(){
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    public void close(){
        scanner.close();
    }

    public Reservation createNewReservation() {
        printer.printLine("Enter connection number: ");
        int connectionNumber = scanner.nextInt();
        scanner.nextLine();
        printer.printLine("First name: ");
        String firstName = scanner.nextLine();
        printer.printLine("Last name: ");
        String lastName = scanner.nextLine();
        printer.printLine("ID Number: ");
        String idNumber = scanner.nextLine();
        return new Reservation(firstName, lastName, idNumber, Destinations.values()[(connectionNumber-1)]);
    }

    public String findReservations() {
        printer.printLine("Enter Your ID number: ");
        String idNumber = scanner.nextLine();
        return idNumber;
    }
}
