public class Invitation {
    private String invitationId;
    private InvResponse response;
    private ScoutEvent event;
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

    public ScoutEvent getEvent() {
        return event;
    }

    public void setEvent(ScoutEvent event) {
        this.event = event;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }
}
