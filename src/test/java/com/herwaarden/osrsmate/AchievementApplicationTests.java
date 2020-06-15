package com.herwaarden.osrsmate;

import com.herwaarden.osrsmate.dal.contexts.AchievementContextHibernate;
import com.herwaarden.osrsmate.dal.repositories.AchievementRepo;
import com.herwaarden.osrsmate.logic.AchievementLogic;
import com.herwaarden.osrsmate.models.AchievementModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest
class AchievementApplicationTests {

    //Tries to find the ardougne elite diary by the farming requirement of level 85
    @Test
    void TestGettingHighscoreHibernate_ShouldBeTrue() throws Exception {
        AchievementLogic achievementLogic = new AchievementLogic(new AchievementRepo(new AchievementContextHibernate()));

        List<AchievementModel> achievementModelList = achievementLogic.getAchievements();
        int listCount = achievementModelList.size();
        int initialCount = 0;
        boolean foundFarmingRequirement = false;

        for(AchievementModel achievementModel : achievementModelList){
            if(achievementModel.getRequiredFarming() == 85){
                if(initialCount < listCount){
                    foundFarmingRequirement = true;
                }
            }
        }
        assertThat(foundFarmingRequirement).isTrue();
    }

    //Tries to find the ardougne elite diary by the farming requirement of an impossible level of 345345
    @Test
    void TestGettingHighscoreHibernate_ShouldNotBeTrue() throws Exception {
        AchievementLogic achievementLogic = new AchievementLogic(new AchievementRepo(new AchievementContextHibernate()));

        List<AchievementModel> achievementModelList = achievementLogic.getAchievements();
        int listCount = achievementModelList.size();
        int initialCount = 0;
        boolean foundFarmingRequirement = false;

        for(AchievementModel achievementModel : achievementModelList){
            if(achievementModel.getRequiredFarming() == 345345){
                if(initialCount < listCount){
                    foundFarmingRequirement = true;
                }
            }
        }
        assertThat(foundFarmingRequirement).isFalse();
    }
}
