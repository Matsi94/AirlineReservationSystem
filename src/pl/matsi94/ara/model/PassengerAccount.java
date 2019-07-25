package pl.matsi94.ara.model;

import java.util.Objects;

public class PassengerAccount extends Passenger {
    private String login;
    private String password;

    public PassengerAccount(String firstName, String lastName, String idNumber, String login, String password) {
        super(firstName, lastName, idNumber);
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerAccount that = (PassengerAccount) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password);
    }
}
