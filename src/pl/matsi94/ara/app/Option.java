package pl.matsi94.ara.app;

import pl.matsi94.ara.exception.WrongOptionException;

public enum Option {
    NEW_PASSENGER_ACCOUNT(1, "Stwórz nowe konto pasażera"),
    CHECK_CONNECTIONS(2, "Sprawdzanie połączaeń"),
    MAKE_RESERVATION(3, "Stwórz rezerwacje"),
    CHECK_YOUR_RESERVATIONS(4, "Sprawdź swoje rezerwacje"),
    EXIT(5, "Wyjście");

    private int value;
    private String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value + ". " + description;
    }

    static Option optionFromNumber(int option) throws WrongOptionException {
        try {
            return Option.values()[(option-1)];
        } catch (ArrayIndexOutOfBoundsException e){
            throw new WrongOptionException("There's no such option");
        }
    }
}
