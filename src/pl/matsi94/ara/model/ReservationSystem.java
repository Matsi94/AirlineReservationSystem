package pl.matsi94.ara.model;

import pl.matsi94.ara.exception.PassengerAlreadyExistsException;

import java.util.*;

public class ReservationSystem {
    private Map<String, PassengerAccount> passengers = new HashMap<>();
    private List<Reservation> reservationDataBase = new ArrayList<>();

    public void addNewPassenger(PassengerAccount passengerAccount) {
        if(passengers.containsKey(passengerAccount.getIdNumber()))
            throw new PassengerAlreadyExistsException(
                    "The passenger with this ID have an account already: " + passengerAccount.getIdNumber()
            );
            passengers.put(passengerAccount.getIdNumber(), passengerAccount);
    }

    public void addReservationToDataBase(Reservation reservation){
        reservationDataBase.add(reservation);
    }

    public List<Reservation> searchPassengersReservation(String passengeId){
        List<Reservation> passengerRes = new ArrayList<>();
        Iterator<Reservation> reservationIterator = reservationDataBase.iterator();
        while (reservationIterator.hasNext()){
            Reservation reservationDB = reservationIterator.next();
            if (reservationDB.getIdNumber().equals(passengeId)){
                passengerRes.add(reservationDB);
            }
        }
        return passengerRes;
    }

}
