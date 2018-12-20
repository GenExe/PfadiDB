import java.util.Set;

public class ScoutGroup {
    private String id;
    private String name;
    private int ScoutsNumber;
    private Set<Leader> leaderSet;

    public ScoutGroup() {
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

    public int getScoutsNumber() {
        return ScoutsNumber;
    }

    public void setScoutsNumber(int scoutsNumber) {
        ScoutsNumber = scoutsNumber;
    }

    public Set<Leader> getLeaderSet() {
        return leaderSet;
    }

    public void setLeaderSet(Set<Leader> leaderSet) {
        this.leaderSet = leaderSet;
    }
}
