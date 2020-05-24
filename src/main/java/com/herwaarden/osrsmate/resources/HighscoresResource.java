package com.herwaarden.osrsmate.resources;

import com.herwaarden.osrsmate.dal.contexts.HighscoresContextHibernate;
import com.herwaarden.osrsmate.dal.repositories.HighscoresRepo;
import com.herwaarden.osrsmate.logic.HighscoresLogic;
import com.herwaarden.osrsmate.models.userScore;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/public/highscores")
public class HighscoresResource {

    HighscoresLogic highscoresLogic = new HighscoresLogic(new HighscoresRepo(new HighscoresContextHibernate()));

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "/getUserByUsername/{username}")
    userScore getUserByUsername(@PathVariable("username")String username){
        return highscoresLogic.getUserScoreByCharacterName(username);
    }
}
