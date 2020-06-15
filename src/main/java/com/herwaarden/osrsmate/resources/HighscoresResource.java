package com.herwaarden.osrsmate.resources;

import com.herwaarden.osrsmate.dal.contexts.HighscoresContextHibernate;
import com.herwaarden.osrsmate.dal.repositories.HighscoresRepo;
import com.herwaarden.osrsmate.logic.HighscoresLogic;
import com.herwaarden.osrsmate.models.CharacterProgressModel;
import com.herwaarden.osrsmate.resources.HighscoresExceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/public/highscores")
public class HighscoresResource {

    HighscoresLogic highscoresLogic = new HighscoresLogic(new HighscoresRepo(new HighscoresContextHibernate()));

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "/getUserScoreByUsername/{username}")
    public CharacterProgressModel GetUserScoreByUsername(@PathVariable("username")String username){
        CharacterProgressModel characterProgressModelToReturn = highscoresLogic.getUserScoreByCharacterName(username);
        if(characterProgressModelToReturn == null){
            throw new NotFoundException("username: " + username);
        }
        return characterProgressModelToReturn;
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "/getUserScoresByUsername/{username}")
    public List<CharacterProgressModel> GetUserScoresByUsername(@PathVariable("username")String username){
        List<CharacterProgressModel> characterProgressModelsToReturn = highscoresLogic.getUserScoresByCharacterName(username);
        if(characterProgressModelsToReturn == null){
            throw new NotFoundException("username: " + username);
        }
        return characterProgressModelsToReturn;
    }

    @CrossOrigin(origins = {"*"})
    @PostMapping(value = "/addUser")
    public boolean AddUserScore(@RequestBody CharacterProgressModel characterProgressModel){
        return highscoresLogic.addUserScore(characterProgressModel);
    }
}