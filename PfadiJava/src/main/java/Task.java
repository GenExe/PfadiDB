import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

public class Task implements Serializable {
    private String id;
    private String name;
    private Date dueDate;
    private String info;
    private Set<Leader> leaderSet;

    public Task() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Set<Leader> getLeaderSet() {
        return leaderSet;
    }

    public void setLeaderSet(Set<Leader> leaderSet) {
        this.leaderSet = leaderSet;
    }
}
