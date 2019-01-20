public class Invitation {
    private String invitationId;
    private InvResponse response;
    private Event event;
    private Leader leader;

    public Invitation() {
    }

    public String getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(String invitationId) {
        this.invitationId = invitationId;
    }

    public InvResponse getResponse() {
        return response;
    }

    public void setResponse(InvResponse response) {
        this.response = response;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }
}
