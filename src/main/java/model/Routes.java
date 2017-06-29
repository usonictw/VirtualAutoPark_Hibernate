package model;

import javax.persistence.*;

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

    @ManyToOne(targetEntity = Busses.class)
    private Busses busses;

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

    public Busses getBusses() {
        return busses;
    }

    public void setBusses(Busses busses) {
        this.busses = busses;
    }
}
