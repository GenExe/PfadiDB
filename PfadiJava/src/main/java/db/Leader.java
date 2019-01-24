package db;

import javax.persistence.*;
import java.util.Set;

@Entity
@SequenceGenerator(name="id")
@Table(name="leader")
public class Leader {
    private String id;
    private String name;
    private Set<Invitation> invitationSet;
    private Set<Group> groupSet;
    private Set<Task> taskSet;

    public Leader() {
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

    @OneToMany(mappedBy = "leader")
    public Set<Invitation> getInvitationSet() {
        return invitationSet;
    }

    public void setInvitationSet(Set<Invitation> invitationSet) {
        this.invitationSet = invitationSet;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "ispartof",
            joinColumns = { @JoinColumn(name = "leaderid") },
            inverseJoinColumns = { @JoinColumn(name = "groupid") }
    )
    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "assigned",
            joinColumns = { @JoinColumn(name = "leaderid") },
            inverseJoinColumns = { @JoinColumn(name = "taskid") }
    )
    public Set<Task> getTaskSet() {
        return taskSet;
    }

    public void setTaskSet(Set<Task> taskSet) {
        this.taskSet = taskSet;
    }
}
