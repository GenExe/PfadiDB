package db;

import org.jboss.marshalling.serial.Serial;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@SequenceGenerator(name="id")
@Table(name="resource")
public class Resource implements Serializable {
    private String resId;
    private String name;
    private String info;
    private Set<Event> eventSet;

    public Resource() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @ManyToMany(mappedBy = "resourceSet")

    public Set<Event> getEventSet() {
        return eventSet;
    }

    public void setEventSet(Set<Event> eventSet) {
        this.eventSet = eventSet;
    }
}