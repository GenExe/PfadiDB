import java.util.Set;

public class Resource {
    private String resId;
    private String name;
    private String info;
    private Set<ScoutEvent> eventSet;

    public Resource() {
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
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

    public Set<ScoutEvent> getEventSet() {
        return eventSet;
    }

    public void setEventSet(Set<ScoutEvent> eventSet) {
        this.eventSet = eventSet;
    }
}