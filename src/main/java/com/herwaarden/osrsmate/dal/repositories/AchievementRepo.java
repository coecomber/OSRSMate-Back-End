package com.herwaarden.osrsmate.dal.repositories;

import com.herwaarden.osrsmate.dal.interfaces.IAchievementContext;
import com.herwaarden.osrsmate.models.AchievementModel;

import java.util.List;

public class AchievementRepo implements IAchievementContext {

    private IAchievementContext context;

    public AchievementRepo(IAchievementContext context) {
        this.context = context;
    }

    @Override
    public List<AchievementModel> getAchievements() {
        return context.getAchievements();
    }
}
