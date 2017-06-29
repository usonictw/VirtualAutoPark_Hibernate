package model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "drivers")
public class Drivers {

    @Id
    @Column(name = "driver_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @ManyToMany(targetEntity = Busses.class)
    private Set<Busses> busses = new HashSet<>();

    public Drivers() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Busses> getBusses() {
        return busses;
    }

    public void setBusses(Set<Busses> busses) {
        this.busses = busses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drivers drivers = (Drivers) o;

        if (age != drivers.age) return false;
        if (!name.equals(drivers.name)) return false;
        if (!surname.equals(drivers.surname)) return false;
        return busses.equals(drivers.busses);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        result = 31 * result + busses.hashCode();
        return result;
    }
}
