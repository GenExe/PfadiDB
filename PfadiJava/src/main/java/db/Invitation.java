package db;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@SequenceGenerator(name="id")
@Table(name="invitation")
public class Invitation implements Serializable {
    private String invitationId;
//    @Enumerated(EnumType.STRING)
//    @Column(name = "accepted")
    private String response;
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
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
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
