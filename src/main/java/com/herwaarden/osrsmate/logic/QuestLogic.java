package com.herwaarden.osrsmate.logic;

import com.herwaarden.osrsmate.dal.interfaces.IQuestRepo;
import com.herwaarden.osrsmate.factories.QuestFactory;
import com.herwaarden.osrsmate.models.QuestModel;

import java.util.List;

public class QuestLogic {
    private QuestFactory questFactory = new QuestFactory();
    private IQuestRepo questRepo;

    public QuestLogic(IQuestRepo repo) {
        questRepo = ((repo == null) ? questFactory.createQuestRepo() : repo);
    }

    public List<QuestModel> getQuests(){
        return questRepo.getQuests();
    }
}
