package lab2;

import com.google.gson.*;

public class Person {
    private String name;
    private int age;
    private String job;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Person that = (Person) o;

        if(age != that.age) return false;
        if(!name.equals(that.name)) return false;
        return job.equals(that.job);
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Joanne";
        person.age = 44;
        person.job = "doctor";
        System.out.println("Original object: " + person);

        Gson g = new Gson();

        String toJson = g.toJson(person);
        System.out.println("Converted to json: " + toJson);
        Person fromJson = g.fromJson(toJson, Person.class);
        System.out.println("Converted from json: " + fromJson);
        System.out.println("Original object is equal to converted from json: " + person.equals(fromJson));
    }
}
