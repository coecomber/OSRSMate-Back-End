package com.herwaarden.osrsmate.dal.interfaces;

import com.herwaarden.osrsmate.models.CharacterProgressModel;

import java.util.List;

public interface IHighscoresRepo {
    CharacterProgressModel getUserScoreByUsername(String username);

    boolean addUserScore(CharacterProgressModel characterProgressModel);

    List<CharacterProgressModel> getUserScoresByUsername(String username);
}
