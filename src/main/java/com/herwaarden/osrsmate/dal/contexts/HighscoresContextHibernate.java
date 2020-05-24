package com.herwaarden.osrsmate.dal.contexts;

import com.herwaarden.osrsmate.dal.interfaces.IHighscoresContext;
import com.herwaarden.osrsmate.models.userScore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class HighscoresContextHibernate implements IHighscoresContext {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("OSRSMate");

    @Override
    public userScore getUserScoreByUsername(String username) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "SELECT c FROM userScore c WHERE c.name = :characterName";
        TypedQuery<userScore> typedQuery = entityManager.createQuery(hql, userScore.class);
        typedQuery.setParameter("characterName", username);
        userScore userScore = null;
        try {
            userScore = typedQuery.getSingleResult();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            entityManager.close();
        }
        return userScore;
    }
}
