package pl.matsi94.ara.model;

public class Reservation extends Passenger{
    private Destinations destination;

    public Reservation(String firstName, String lastName, String idNumber, Destinations destination) {
        super(firstName, lastName, idNumber);
        this.destination = destination;
    }

    public Destinations getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "destination=" + destination + " " + getFirstName() + " " + getLastName() +
                '}';
    }
}
