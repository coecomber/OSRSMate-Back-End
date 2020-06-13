package com.herwaarden.osrsmate.factories;

import com.herwaarden.osrsmate.dal.contexts.AchievementContextHibernate;
import com.herwaarden.osrsmate.dal.interfaces.IAchievementRepo;
import com.herwaarden.osrsmate.dal.repositories.AchievementRepo;

public class AchievementFactory {

    public IAchievementRepo createAchievementRepo() {
        return new AchievementRepo(new AchievementContextHibernate());
    }
}
