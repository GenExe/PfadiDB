import java.sql.Date;
import java.util.Set;

public class Event {
    private String id;
    private String name;
    private String info;
    private Date startdate;
    private Date enddate;
    private Set<Resource> resourceSet;
    private Set<Invitation> invitationSet;

    public Event() {
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Set<Resource> getResourceSet() {
        return resourceSet;
    }

    public void setResourceSet(Set<Resource> resourceSet) {
        this.resourceSet = resourceSet;
    }

    public Set<Invitation> getInvitationSet() {
        return invitationSet;
    }

    public void setInvitationSet(Set<Invitation> invitationSet) {
        this.invitationSet = invitationSet;
    }
}
