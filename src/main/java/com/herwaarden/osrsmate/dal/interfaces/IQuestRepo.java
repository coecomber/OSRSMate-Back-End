package com.herwaarden.osrsmate.dal.interfaces;

import com.herwaarden.osrsmate.models.QuestModel;

import java.util.List;

public interface IQuestRepo {
    List<QuestModel> getQuests();
}
