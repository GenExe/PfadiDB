package db;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@SequenceGenerator(name="id")
@Table(name="event")
public class Event implements Serializable {
    private String id;
    private String name;
    private String info;
    private Date startdate;
    private Date enddate;
    private Set<Resource> resourceSet;
    private Set<Invitation> invitationSet;


    public Event() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Column(name = "startdate")
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Column(name = "enddate")
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "uses",
            joinColumns = { @JoinColumn(name = "eventid") },
            inverseJoinColumns = { @JoinColumn(name = "resourceid") }
    )
    public Set<Resource> getResourceSet() {
        return resourceSet;
    }

    public void setResourceSet(Set<Resource> resourceSet) {
        this.resourceSet = resourceSet;
    }

    @OneToMany(mappedBy = "event")
    public Set<Invitation> getInvitationSet() {
        return invitationSet;
    }

    public void setInvitationSet(Set<Invitation> invitationSet) {
        this.invitationSet = invitationSet;
    }
}
