package com.ncaapredictor.demo.web;

import com.ncaapredictor.demo.domain.Team;
import com.ncaapredictor.demo.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {
    private TeamRepository teamRepo;

    @Autowired
    public TeamController(TeamRepository teamRepo) {
        this.teamRepo = teamRepo;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/search/findByTeamName?teamName={teamName}")
    public Team getTeam(@PathVariable(value = "teamName") String teamName) {
        return teamRepo.findByTeamName(teamName);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/names")
    public List<Team> getTeamNames() {
        return teamRepo.findAll();
    }

}