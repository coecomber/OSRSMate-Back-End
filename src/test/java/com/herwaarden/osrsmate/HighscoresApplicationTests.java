package com.herwaarden.osrsmate;

import com.herwaarden.osrsmate.dal.contexts.HighscoresContextHibernate;
import com.herwaarden.osrsmate.dal.repositories.HighscoresRepo;
import com.herwaarden.osrsmate.logic.HighscoresLogic;
import com.herwaarden.osrsmate.models.CharacterProgressModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest
class HighscoresApplicationTests {

    //This tests if we can get the characterProgress of Grey Sheep with ID 1 in the database.
    @Test
    void TestGettingHighscoresByCharacterNameHibernate_ShouldBeEqual() throws Exception {
        HighscoresLogic highscoresLogic = new HighscoresLogic(new HighscoresRepo(new HighscoresContextHibernate()));

        List<CharacterProgressModel> characterProgressModelList = highscoresLogic.getUserScoresByCharacterName("Grey Sheep");
        for(CharacterProgressModel characterProgressModel : characterProgressModelList){
            assertThat(characterProgressModel.getOverallExp()).isEqualTo(237635068);
            if(characterProgressModel.getOverallExp() == 237635068){
                System.out.println("Excaped from TestGettingHighscoresByCharacterNameHibernate because we already asserted.");
                break;
            }
        }
    }

    //This tests if we can get the characterProgress of Grey Sheep with a overall exp which never should be able to exist in the database.
    @Test
    void TestGettingHighscoresByCharacterNameHibernate_ShouldNotBeEqual() throws Exception {
        HighscoresLogic highscoresLogic = new HighscoresLogic(new HighscoresRepo(new HighscoresContextHibernate()));

        List<CharacterProgressModel> characterProgressModelList = highscoresLogic.getUserScoresByCharacterName("Grey Sheep");
        for(CharacterProgressModel characterProgressModel : characterProgressModelList){
            assertThat(characterProgressModel.getOverallExp()).isNotEqualTo(237635057);
        }
    }

    //Since this API call should retrieve the latest data point it should not return the entry in the database with id 1.
    @Test
    void TestGettingHighscoreByCharacterNameHibernate_ShouldNotBeEqual() throws Exception {
        HighscoresLogic highscoresLogic = new HighscoresLogic(new HighscoresRepo(new HighscoresContextHibernate()));

        CharacterProgressModel characterProgressModel = highscoresLogic.getUserScoreByCharacterName("Grey Sheep");
        assertThat(characterProgressModel.getOverallExp()).isNotEqualTo(237635068);
    }
}
