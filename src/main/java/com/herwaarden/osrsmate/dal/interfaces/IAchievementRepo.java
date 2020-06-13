package com.herwaarden.osrsmate.dal.interfaces;

import com.herwaarden.osrsmate.models.AchievementModel;

import java.util.List;

public interface IAchievementRepo {
    List<AchievementModel> getAchievements();
}
