package com.ncaapredictor.demo.repo;



import com.ncaapredictor.demo.domain.Team;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "Tourney_Teams", path = "team")
@CrossOrigin(origins = "http://localhost:3000")
public interface TeamRepository extends MongoRepository<Team, String> {

    
    Team findByTeamName(@Param("teamName") String teamName);


}