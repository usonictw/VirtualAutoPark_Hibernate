package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private int number;

    @OneToMany(mappedBy = "routes", cascade = CascadeType.ALL)
    private Set<Busses> busses = new HashSet<>();

    public Routes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

        Routes routes = (Routes) o;

        if (id != routes.id) return false;
        if (number != routes.number) return false;
        return busses != null ? busses.equals(routes.busses) : routes.busses == null;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (busses != null ? busses.hashCode() : 0);
        return result;
    }
}
