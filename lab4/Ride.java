package lab4;

import java.util.HashSet;
import java.util.Set;

public class Ride {
    private final Set<Vehicle<? extends Person>> availableVehicles = new HashSet<>();

    public void addVehicle(Vehicle<? extends Person> vehicle) {
        availableVehicles.add(vehicle);
    }

    public int getTotalOfPeople() {
        return availableVehicles.stream()
                .map(Vehicle::getNumberOfPeopleInVehicle)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
