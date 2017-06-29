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

    @Column(name = "busses")
    private int number;

    @OneToMany()
    @JoinColumn(name = "route_id", referencedColumnName = "bus_id")
    Set<Routes> routes = new HashSet<>();

    @ManyToMany
    Drivers drivers;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Busses busses = (Busses) o;

        if (id != busses.id) return false;
        if (number != busses.number) return false;
        return routes != null ? routes.equals(busses.routes) : busses.routes == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + number;
        result = 31 * result + (routes != null ? routes.hashCode() : 0);
        return result;
    }
}
