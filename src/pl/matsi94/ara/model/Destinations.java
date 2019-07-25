package pl.matsi94.ara.model;

import pl.matsi94.ara.exception.WrongOptionException;

public enum Destinations {
    WARSAW_BERLIN(1, "Warsaw -> Berlin", 517),
    WARSAW_PARIS(2, "Warsaw -> Paris", 1367),
    WARSAW_MOSCOW(3, "Warsaw -> Moscow", 1150),
    WARSAW_KIEV(4, "Warsaw -> Kiev", 689),
    WARSAW_BARCELONA(5, "Warsaw -> Barcelona", 1864),
    WARSAW_VIENNA(6, "Warsaw -> Vienna", 556),
    WARSAW_NEWYORK(7, "Warsaw -> New York", 6854),
    WARSAW_RIODEJANEIRO(8, "Warsaw -> Rio de Janeiro", 10403),
    WARSAW_LOSANGELES(9, "Wasaw -> Los Angeles", 9636),
    WARSAW_TOKYO(10, "Wasaw -> Tokyo", 8581);

    private int value;
    private String description;
    private int distance;

    Destinations(int value, String description, int distance) {
        this.value = value;
        this.description = description;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return (value) + ". " + description;
    }

    static Destinations createFromInt(int destinationNumber) throws WrongOptionException {
        try{
            return Destinations.values()[destinationNumber-1];
        } catch (ArrayIndexOutOfBoundsException e){
            throw new WrongOptionException("No option with number: " + destinationNumber);
        }
    }
}
