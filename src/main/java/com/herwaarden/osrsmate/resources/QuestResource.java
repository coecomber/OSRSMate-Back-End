package com.herwaarden.osrsmate.resources;

import com.herwaarden.osrsmate.dal.contexts.QuestContextHibernate;
import com.herwaarden.osrsmate.dal.repositories.QuestRepo;
import com.herwaarden.osrsmate.logic.QuestLogic;
import com.herwaarden.osrsmate.models.QuestModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/public/quest")
public class QuestResource {

    QuestLogic questLogic = new QuestLogic(new QuestRepo(new QuestContextHibernate()));

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "getQuests")
    public List<QuestModel> GetQuests(){
        return questLogic.getQuests();
    }
}
