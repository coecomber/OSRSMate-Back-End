package com.herwaarden.osrsmate.factories;

import com.herwaarden.osrsmate.dal.contexts.HighscoresContextHibernate;
import com.herwaarden.osrsmate.dal.interfaces.IHighscoresRepo;
import com.herwaarden.osrsmate.dal.repositories.HighscoresRepo;

public class HighscoresFactory {

    public IHighscoresRepo createHighscoresRepo() {
        return new HighscoresRepo(new HighscoresContextHibernate());
    }
}
