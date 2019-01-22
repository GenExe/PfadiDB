import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@SequenceGenerator(name="id")
@Table(name="task")
public class Task implements Serializable {
    private String id;
    private String name;
    private Date dueDate;
    private String info;
    private Set<Leader> leaderSet;

    public Task() {
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

    @Column(name = "duedate")
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @ManyToMany(mappedBy = "taskSet")
    public Set<Leader> getLeaderSet() {
        return leaderSet;
    }

    public void setLeaderSet(Set<Leader> leaderSet) {
        this.leaderSet = leaderSet;
    }
}
