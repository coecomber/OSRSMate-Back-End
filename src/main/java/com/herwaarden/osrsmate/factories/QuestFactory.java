package com.herwaarden.osrsmate.factories;

import com.herwaarden.osrsmate.dal.contexts.QuestContextHibernate;
import com.herwaarden.osrsmate.dal.interfaces.IQuestRepo;
import com.herwaarden.osrsmate.dal.repositories.QuestRepo;

public class QuestFactory {

    public IQuestRepo createQuestRepo() {
        return new QuestRepo(new QuestContextHibernate());
    }
}
