package com.herwaarden.osrsmate.logic;

import com.herwaarden.osrsmate.dal.interfaces.IHighscoresRepo;
import com.herwaarden.osrsmate.factories.HighscoresFactory;
import com.herwaarden.osrsmate.models.userScore;

public class HighscoresLogic {
    private HighscoresFactory highscoresFactory = new HighscoresFactory();
    private IHighscoresRepo highscoresRepo;

    public HighscoresLogic(IHighscoresRepo repo) {
        highscoresRepo = ((repo == null) ? highscoresFactory.createHighscoresRepo() : repo);
    }

    public userScore getUserScoreByCharacterName(String characterName){
        return highscoresRepo.getUserScoreByUsername(characterName);
    }
}
