package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "busses")
public class Busses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private int id;

    @Column(name = "buses")
    private int number;

    @ManyToOne()
    @JoinColumn(name = "route_id")
    private Routes routes;

    @ManyToMany
    @JoinTable(name = "bus_driver", joinColumns = @JoinColumn(name = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id"))
    private Set<Drivers> drivers = new HashSet<>();


    public Busses() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Routes getRoutes() {
        return routes;
    }

    public void setRoutes(Routes routes) {
        this.routes = routes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Busses busses = (Busses) o;

        if (number != busses.number) return false;
        if (!routes.equals(busses.routes)) return false;
        return drivers.equals(busses.drivers);
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + routes.hashCode();
        result = 31 * result + drivers.hashCode();
        return result;
    }
}


