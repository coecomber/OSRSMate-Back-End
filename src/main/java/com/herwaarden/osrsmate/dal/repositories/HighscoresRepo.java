package com.herwaarden.osrsmate.dal.repositories;

import com.herwaarden.osrsmate.dal.interfaces.IHighscoresContext;
import com.herwaarden.osrsmate.models.CharacterProgressModel;

import java.util.List;


public class HighscoresRepo implements IHighscoresContext {

    private IHighscoresContext context;

    public HighscoresRepo(IHighscoresContext context) {
        this.context = context;
    }

    @Override
    public CharacterProgressModel getUserScoreByUsername(String username) {
        return context.getUserScoreByUsername(username);
    }

    @Override
    public boolean addUserScore(CharacterProgressModel characterProgressModel) {
        return context.addUserScore(characterProgressModel);
    }

    @Override
    public List<CharacterProgressModel> getUserScoresByUsername(String username) {
        return context.getUserScoresByUsername(username);
    }
}
