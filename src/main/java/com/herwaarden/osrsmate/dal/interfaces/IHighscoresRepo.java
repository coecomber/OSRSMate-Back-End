package com.herwaarden.osrsmate.dal.interfaces;

import com.herwaarden.osrsmate.models.userScore;

public interface IHighscoresRepo {
    userScore getUserScoreByUsername(String username);
}
