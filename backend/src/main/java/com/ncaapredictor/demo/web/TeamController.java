package com.ncaapredictor.demo.web;

import com.ncaapredictor.demo.domain.Team;
import com.ncaapredictor.demo.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/team")
public class TeamController {
    private TeamRepository teamRepo;

    @Autowired
    public TeamController(TeamRepository teamRepo) {
        this.teamRepo = teamRepo;
    }

   
    public Team getTeam(@PathVariable(value = "teamName") String teamName) {
        return teamRepo.findByTeamName(teamName);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/names")
    public List<Team> getTeamNames() {
        return teamRepo.findAll();
    }

}