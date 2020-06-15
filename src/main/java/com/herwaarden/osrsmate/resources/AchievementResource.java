package com.herwaarden.osrsmate.resources;

import com.herwaarden.osrsmate.dal.contexts.AchievementContextHibernate;
import com.herwaarden.osrsmate.dal.repositories.AchievementRepo;
import com.herwaarden.osrsmate.logic.AchievementLogic;
import com.herwaarden.osrsmate.models.AchievementModel;
import com.herwaarden.osrsmate.resources.HighscoresExceptions.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/public/achievement")
public class AchievementResource {

    AchievementLogic achievementLogic = new AchievementLogic(new AchievementRepo(new AchievementContextHibernate()));

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "getAchievements")
    public List<AchievementModel> GetAchievements(){
        List<AchievementModel> achievementModelsToReturn = achievementLogic.getAchievements();
        if(achievementModelsToReturn == null){
            throw new NotFoundException("quests");
        }

        return achievementModelsToReturn;
    }
}
