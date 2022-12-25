package lab4;

import java.util.HashSet;
import java.util.Set;

public class Vehicle <T extends Person> {
    private final Set<T> people;
    private final int maxNumberOfSeats;

    public Vehicle(int maxSeats) {
        this.maxNumberOfSeats = maxSeats;
        people = new HashSet<>(maxSeats);
    }

    public void addPeople(T person) {
        if(people.size() < maxNumberOfSeats) {
            people.add(person);
        } else {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + " is full");
        }
    }

    public void removePeople(T person) {
        if (people.contains(person)) {
            people.remove(person);
        } else {
            throw new IllegalArgumentException("This person is not inside the " + this.getClass().getSimpleName());
        }
    }

    public int getMaxNumberOfSeats() {
        return maxNumberOfSeats;
    }

    public int getNumberOfPeopleInVehicle() {
        return people.size();
    }
}

