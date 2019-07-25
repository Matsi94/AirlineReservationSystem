package pl.matsi94.ara.app;

import pl.matsi94.ara.exception.PassengerAlreadyExistsException;
import pl.matsi94.ara.exception.WrongOptionException;
import pl.matsi94.ara.io.ConsolePrinter;
import pl.matsi94.ara.io.DataReader;
import pl.matsi94.ara.model.Destinations;
import pl.matsi94.ara.model.PassengerAccount;
import pl.matsi94.ara.model.Reservation;
import pl.matsi94.ara.model.ReservationSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

public class AppControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);

    private ReservationSystem reservationSystem = new ReservationSystem();
    private Reservation reservation;

    void controlLoop(){
        Option option;

        do {
            printOptions();
            option = getOption();
            switch (option){
                case NEW_PASSENGER_ACCOUNT:
                    addPassengerAccount();
                    break;
                case CHECK_CONNECTIONS:
                    printConnections();
                    break;
                case MAKE_RESERVATION:
                    makeReservation();
                    break;
                case CHECK_YOUR_RESERVATIONS:
                    checkReservations();
                    break;
                case EXIT:
                    exit();
                    break;
                    default:
                        printer.printLine("There is no such option, please enter again.");
            }

        } while (option != Option.EXIT);
    }

    private void checkReservations() {
        List<Reservation> myReservations = new ArrayList<>();
        myReservations = reservationSystem.searchPassengersReservation(dataReader.findReservations());
        Iterator<Reservation> reservationIterator = myReservations.iterator();
        while (reservationIterator.hasNext()){
            printer.printLine(reservationIterator.next().toString());
        }
    }

    private void makeReservation() {
        printConnections();
        Reservation reservation = dataReader.createNewReservation();
        reservationSystem.addReservationToDataBase(reservation);
    }

    private void printConnections() {
        printer.printLine("Our connections:");
        for (Destinations destinations: Destinations.values()) {
            printer.printLine(destinations.toString());
        }
    }

    private void exit() {
        dataReader.close();
        printer.printLine("Program is closing...");
    }

    private void addPassengerAccount() {
        PassengerAccount passengerAccount = dataReader.createNewPassengerAccount();
        try {
            reservationSystem.addNewPassenger(passengerAccount);
        } catch (PassengerAlreadyExistsException e){
            printer.printLine(e.getMessage());
        }
    }

    private void printOptions(){
        printer.printLine("Choose option");
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private Option getOption(){
        boolean optionValid = false;
        Option option = null;
        try {
            option = Option.optionFromNumber(dataReader.getInt());
            optionValid = true;
        } catch (WrongOptionException e){
            printer.printLine(e.getMessage() + ", enter number one more time.");
        } catch (InputMismatchException e){
            printer.printLine("Entered value is not a number, please try again.");
        }
        return  option;
    }
}
