package com.herwaarden.osrsmate.dal.contexts;

import com.herwaarden.osrsmate.dal.interfaces.IAchievementContext;
import com.herwaarden.osrsmate.models.AchievementModel;
import com.herwaarden.osrsmate.models.QuestModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AchievementContextHibernate implements IAchievementContext {

    Logger logger = Logger.getLogger(HighscoresContextHibernate.class.getName());
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("OSRSMate");

    @Override
    public List<AchievementModel> getAchievements() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "FROM AchievementModel";
        TypedQuery<AchievementModel> typedQuery = entityManager.createQuery(hql, AchievementModel.class);
        List<AchievementModel> achievementModels = null;
        try {
            achievementModels = typedQuery.getResultList();

        }catch (Exception ex){
            String message = "Unexpected Exception in getAchievements";
            logger.log(Level.SEVERE, message, ex);
        }
        finally {
            entityManager.close();
        }
        return achievementModels;
    }
}
