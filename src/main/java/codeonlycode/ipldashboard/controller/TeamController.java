package codeonlycode.ipldashboard.controller;

import codeonlycode.ipldashboard.model.Match;
import codeonlycode.ipldashboard.model.Team;
import codeonlycode.ipldashboard.repositry.MatchRepository;
import codeonlycode.ipldashboard.repositry.TeamRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
        byTeamName.setMatches(matchRepository.findLatestMatchesByName(teamName, 4));
        return byTeamName;
    }

    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);
        return matchRepository.getMatchesByTeamBetweenDates
                            (teamName, startDate, endDate);
    }
}
