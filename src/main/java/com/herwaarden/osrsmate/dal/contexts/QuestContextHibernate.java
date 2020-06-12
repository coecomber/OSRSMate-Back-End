package com.herwaarden.osrsmate.dal.contexts;

import com.herwaarden.osrsmate.dal.interfaces.IQuestContext;
import com.herwaarden.osrsmate.models.QuestModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestContextHibernate implements IQuestContext {

    Logger logger = Logger.getLogger(HighscoresContextHibernate.class.getName());
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("OSRSMate");

    @Override
    public List<QuestModel> getQuests() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "FROM QuestModel";
        TypedQuery<QuestModel> typedQuery = entityManager.createQuery(hql, QuestModel.class);
        List<QuestModel> questModels = null;
        try {
            questModels = typedQuery.getResultList();

        }catch (Exception ex){
            String message = "Unexpected Exception in getQuests";
            logger.log(Level.SEVERE, message, ex);
        }
        finally {
            entityManager.close();
        }
        return questModels;
    }
}
