package com.herwaarden.osrsmate.resources;

import com.herwaarden.osrsmate.dal.contexts.HighscoresContextHibernate;
import com.herwaarden.osrsmate.dal.repositories.HighscoresRepo;
import com.herwaarden.osrsmate.logic.HighscoresLogic;
import com.herwaarden.osrsmate.models.CharacterProgressModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/public/highscores")
public class HighscoresResource {

    HighscoresLogic highscoresLogic = new HighscoresLogic(new HighscoresRepo(new HighscoresContextHibernate()));

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "/getUserScoreByUsername/{username}")
    public CharacterProgressModel GetUserScoreByUsername(@PathVariable("username")String username){
        return highscoresLogic.getUserScoreByCharacterName(username);
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "/getUserScoresByUsername/{username}")
    public List<CharacterProgressModel> GetUserScoresByUsername(@PathVariable("username")String username){
        return highscoresLogic.getUserScoresByCharacterName(username);
    }

    @CrossOrigin(origins = {"*"})
    @PostMapping(value = "/addUser")
    public boolean AddUserScore(@RequestBody CharacterProgressModel characterProgressModel){
        return highscoresLogic.addUserScore(characterProgressModel);
    }
}