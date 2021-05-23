package codeonlycode.ipldashboard.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String teamName;
    private long totalMatches;
    private long totalWins;

    @Transient
    private List<Match> matches;

    public Team() {

    }

    public Team(String teamName, long totalMatches) {
        this.teamName = teamName;
        this.totalMatches = totalMatches;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(long totalMatches) {
        this.totalMatches = totalMatches;
    }

    public long getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(long totalWins) {
        this.totalWins = totalWins;
    }

    public Long getId() {
        return id;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", totalMatches=" + totalMatches +
                ", totalWins=" + totalWins +
                '}';
    }
}
