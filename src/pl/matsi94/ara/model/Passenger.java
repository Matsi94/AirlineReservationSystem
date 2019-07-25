package pl.matsi94.ara.model;

import java.util.Objects;

public abstract class Passenger {
    private String firstName;
    private String lastName;
    private String idNumber;

    public Passenger(String firstName, String lastName, String idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(firstName, passenger.firstName) &&
                Objects.equals(lastName, passenger.lastName) &&
                Objects.equals(idNumber, passenger.idNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, idNumber);
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }
}
