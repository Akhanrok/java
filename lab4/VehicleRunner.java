package lab4;

public class VehicleRunner {
    public static void main(String[] args) {
        Ride ride = new Ride();

        Person person = new Person();
        Person policeman = new Policeman();
        Person firefighter = new Firefighter();

        Vehicle<Person> bus = new Bus(24);
        ride.addVehicle(bus);
        System.out.println("Кількість місць у автобусі: " + bus.getMaxNumberOfSeats());
        bus.addPeople(person);
        bus.addPeople(policeman);
        bus.addPeople(firefighter);
        System.out.println("Кількість людей у автобусі: " + bus.getNumberOfPeopleInVehicle());

        Vehicle<Person> taxi = new Taxi(4);
        System.out.println("\nКількість місць у таксі: " + taxi.getMaxNumberOfSeats());
        ride.addVehicle(taxi);
        taxi.addPeople(new Person());
        taxi.addPeople(new Policeman());
        taxi.addPeople(new Firefighter());
        System.out.println("Кількість людей у таксі: " + taxi.getNumberOfPeopleInVehicle());

        Vehicle<Policeman> policeCar = new PoliceCar(1);
        System.out.println("\nКількість місць у поліцейському автомобілі: " + policeCar.getMaxNumberOfSeats());
        ride.addVehicle(policeCar);
        policeCar.addPeople(new Policeman());
        System.out.println("Кількість людей у поліцейському автомобілі: " + policeCar.getNumberOfPeopleInVehicle());

        Vehicle<Firefighter> fireTruck = new FireTruck(8);
        System.out.println("\nКількість місць у пожежній машині: " + fireTruck.getMaxNumberOfSeats());
        ride.addVehicle(fireTruck);
        for(int i = 0; i < fireTruck.getMaxNumberOfSeats(); i++) {
            fireTruck.addPeople(new Firefighter());
        }
        System.out.println("Кількість людей у пожежній машині: " + fireTruck.getNumberOfPeopleInVehicle());

        System.out.println("\nЗагальна кількість пасажирів: " + ride.getTotalOfPeople());

        System.out.println("\nВисадка пасажира із автобуса: ");
        bus.removePeople(person);
        System.out.println("Кількість місць у автобусі: " + bus.getMaxNumberOfSeats());
        System.out.println("Кількість людей у автобусі: " + bus.getNumberOfPeopleInVehicle());

        System.out.println("\nЗагальна кількість пасажирів: " + ride.getTotalOfPeople());

        //Exception: Bus is full
//        System.out.println("Кількість місць у автобусі: " + bus.getMaxNumberOfSeats());
//        for(int i = 0; i < bus.getMaxNumberOfSeats() / 3; i++) {
//            bus.addPeople(new Person());
//            bus.addPeople(new Policeman());
//            bus.addPeople(new Firefighter());
//        }

        //Exception: This person is not inside the Taxi
//        taxi.removePeople(person);
//        taxi.removePeople(person);
    }
}
