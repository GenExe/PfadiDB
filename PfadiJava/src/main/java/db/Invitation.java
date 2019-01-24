package db;

import javax.persistence.*;


@Entity
@SequenceGenerator(name="id")
@Table(name="invitation")
public class Invitation {
    private String invitationId;
    private InvResponse response;
    private Event event;
    private Leader leader;


    public Invitation() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public String getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(String invitationId) {
        this.invitationId = invitationId;
    }

    @Column(name = "accepted")
    public InvResponse getResponse() {
        return response;
    }

    public void setResponse(InvResponse response) {
        this.response = response;
    }

    @ManyToOne
    @JoinColumn(name="eventid", nullable=false)
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @ManyToOne
    @JoinColumn(name="leaderid", nullable=false)
    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }
}
