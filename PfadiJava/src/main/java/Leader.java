import java.util.Set;

public class Leader {
    private String id;
    private String name;
    private Set<Invitation> invitationSet;
    private Set<ScoutGroup> scoutGroupSet;

    public Leader() {
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

    public Set<Invitation> getInvitationSet() {
        return invitationSet;
    }

    public void setInvitationSet(Set<Invitation> invitationSet) {
        this.invitationSet = invitationSet;
    }

    public Set<ScoutGroup> getScoutGroupSet() {
        return scoutGroupSet;
    }

    public void setScoutGroupSet(Set<ScoutGroup> scoutGroupSet) {
        this.scoutGroupSet = scoutGroupSet;
    }
}
