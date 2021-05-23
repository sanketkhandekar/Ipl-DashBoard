package codeonlycode.ipldashboard.controller;

import codeonlycode.ipldashboard.model.Team;
import codeonlycode.ipldashboard.repositry.MatchRepository;
import codeonlycode.ipldashboard.repositry.TeamRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team byTeamName = teamRepository.findByTeamName(teamName);
        byTeamName.setMatches(matchRepository.findLatestMatchesByName(teamName,4));
        return byTeamName;
    }
}
