import java.util.Set;

public class Group {
    private String id;
    private String name;
    private int memberCount;
    private Set<Leader> leaderSet;

    public Group() {
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

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public Set<Leader> getLeaderSet() {
        return leaderSet;
    }

    public void setLeaderSet(Set<Leader> leaderSet) {
        this.leaderSet = leaderSet;
    }
}
