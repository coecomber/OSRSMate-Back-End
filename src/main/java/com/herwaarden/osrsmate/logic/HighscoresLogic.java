package com.herwaarden.osrsmate.logic;

import com.herwaarden.osrsmate.dal.interfaces.IHighscoresRepo;
import com.herwaarden.osrsmate.factories.HighscoresFactory;
import com.herwaarden.osrsmate.models.CharacterProgressModel;

import java.util.List;

public class HighscoresLogic {
    private HighscoresFactory highscoresFactory = new HighscoresFactory();
    private IHighscoresRepo highscoresRepo;

    public HighscoresLogic(IHighscoresRepo repo) {
        highscoresRepo = ((repo == null) ? highscoresFactory.createHighscoresRepo() : repo);
    }

    public CharacterProgressModel getUserScoreByCharacterName(String characterName){
        return highscoresRepo.getUserScoreByUsername(characterName);
    }

    public List<CharacterProgressModel> getUserScoresByCharacterName(String characterName){
        return highscoresRepo.getUserScoresByUsername(characterName);
    }

    public boolean addUserScore(CharacterProgressModel characterProgressModel){
        return highscoresRepo.addUserScore(characterProgressModel);
    }

}
