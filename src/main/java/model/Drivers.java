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
    @Column(name = "id_driver")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @ManyToMany
    @JoinTable(name = "drivers_buses", joinColumns = @JoinColumn(name = "id_driver"),
            inverseJoinColumns = @JoinColumn(name = "bus_id"))
    List<Busses> busses = new ArrayList<>();
}
