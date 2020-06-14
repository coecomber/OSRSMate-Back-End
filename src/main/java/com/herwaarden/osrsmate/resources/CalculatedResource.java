package com.herwaarden.osrsmate.resources;

import com.herwaarden.osrsmate.dal.contexts.AchievementContextHibernate;
import com.herwaarden.osrsmate.dal.contexts.HighscoresContextHibernate;
import com.herwaarden.osrsmate.dal.contexts.QuestContextHibernate;
import com.herwaarden.osrsmate.dal.repositories.AchievementRepo;
import com.herwaarden.osrsmate.dal.repositories.HighscoresRepo;
import com.herwaarden.osrsmate.dal.repositories.QuestRepo;
import com.herwaarden.osrsmate.logic.CalculatedLogic;
import org.springframework.web.bind.annotation.*;
import viewModels.CalculatedAchievements;
import viewModels.CalculatedQuests;

import java.util.List;

@RestController
@RequestMapping(value = "api/public/calculated")
public class CalculatedResource {

    CalculatedLogic calculatedLogic = new CalculatedLogic(
            new QuestRepo(new QuestContextHibernate()),
            new AchievementRepo(new AchievementContextHibernate()),
            new HighscoresRepo(new HighscoresContextHibernate())
    );

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "/getQuestsByCharacterName/{characterName}")
    public List<CalculatedQuests> GetQuestsByCharacterName(@PathVariable("characterName")String characterName){
        return calculatedLogic.getQuests(characterName);
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "/getAchievementsByCharacterName/{characterName}")
    public List<CalculatedAchievements> GetAchievementsByCharacterName(@PathVariable("characterName")String characterName){
        return calculatedLogic.getAchievements(characterName);
    }
}
