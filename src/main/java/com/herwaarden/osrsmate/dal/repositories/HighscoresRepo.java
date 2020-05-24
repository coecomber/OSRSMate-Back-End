package com.herwaarden.osrsmate.dal.repositories;

import com.herwaarden.osrsmate.dal.interfaces.IHighscoresContext;
import com.herwaarden.osrsmate.models.userScore;

public class HighscoresRepo implements IHighscoresContext {

    private IHighscoresContext context;

    public HighscoresRepo(IHighscoresContext context) {
        this.context = context;
    }

    @Override
    public userScore getUserScoreByUsername(String username) {
        return context.getUserScoreByUsername(username);
    }
}
