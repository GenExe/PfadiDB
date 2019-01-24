package db;

import javax.persistence.*;
import java.util.Set;

@Entity
@SequenceGenerator(name="id")
@Table(name="groups")
public class Group {
    private String id;
    private String name;
    private int memberCount;
    private Set<Leader> leaderSet;

    public Group() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "membercount")
    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    @ManyToMany(mappedBy = "groupSet")
    public Set<Leader> getLeaderSet() {
        return leaderSet;
    }

    public void setLeaderSet(Set<Leader> leaderSet) {
        this.leaderSet = leaderSet;
    }
}
