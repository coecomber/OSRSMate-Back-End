package com.herwaarden.osrsmate.logic;

import com.herwaarden.osrsmate.dal.interfaces.IAchievementRepo;
import com.herwaarden.osrsmate.factories.AchievementFactory;
import com.herwaarden.osrsmate.models.AchievementModel;

import java.util.List;

public class AchievementLogic {
    private AchievementFactory achievementFactory = new AchievementFactory();
    private IAchievementRepo achievementRepo;

    public AchievementLogic(IAchievementRepo repo) {
        achievementRepo = ((repo == null) ? achievementFactory.createAchievementRepo() : repo);
    }

    public List<AchievementModel> getAchievements(){
        return achievementRepo.getAchievements();
    }
}
