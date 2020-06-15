package com.herwaarden.osrsmate;

import com.herwaarden.osrsmate.dal.contexts.QuestContextHibernate;
import com.herwaarden.osrsmate.dal.repositories.QuestRepo;
import com.herwaarden.osrsmate.logic.QuestLogic;
import com.herwaarden.osrsmate.models.QuestModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest
public class QuestApplicationTests {

    //Tries to find the Dragon Slayer 2 quest by the magic requirement of level 75
    @Test
    void TestGettingHighscoreByCharacterNameHibernate_ShouldBeTrue() throws Exception {
        QuestLogic questLogic = new QuestLogic(new QuestRepo(new QuestContextHibernate()));

        List<QuestModel> questModelList = questLogic.getQuests();
        int listCount = questModelList.size();
        int initialCount = 0;
        boolean foundMagicRequirement = false;

        for(QuestModel questModel : questModelList){
            if(questModel.getRequiredMagic() == 75){
                if(initialCount < listCount){
                    foundMagicRequirement = true;
                }
            }
        }
        assertThat(foundMagicRequirement).isTrue();
    }

    //Tries to find the Dragon Slayer 2 quest by the impossible magic requirement of level 234652
    @Test
    void TestGettingHighscoreByCharacterNameHibernate_ShouldNotBeTrue() throws Exception {
        QuestLogic questLogic = new QuestLogic(new QuestRepo(new QuestContextHibernate()));

        List<QuestModel> questModelList = questLogic.getQuests();
        int listCount = questModelList.size();
        int initialCount = 0;
        boolean foundMagicRequirement = false;

        for(QuestModel questModel : questModelList){
            if(questModel.getRequiredMagic() == 234652){
                if(initialCount < listCount){
                    foundMagicRequirement = true;
                }
            }
        }
        assertThat(foundMagicRequirement).isFalse();
    }
}
