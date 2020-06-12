package com.herwaarden.osrsmate.dal.repositories;

import com.herwaarden.osrsmate.dal.interfaces.IQuestContext;
import com.herwaarden.osrsmate.models.QuestModel;

import java.util.List;

public class QuestRepo implements IQuestContext {

    private IQuestContext context;

    public QuestRepo(IQuestContext context) {
        this.context = context;
    }

    @Override
    public List<QuestModel> getQuests() {
        return context.getQuests();
    }
}
