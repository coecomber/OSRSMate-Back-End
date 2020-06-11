package com.herwaarden.osrsmate.dal.contexts;

import com.herwaarden.osrsmate.dal.interfaces.IHighscoresContext;
import com.herwaarden.osrsmate.models.CharacterProgressModel;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HighscoresContextHibernate implements IHighscoresContext {

    Logger logger = Logger.getLogger(HighscoresContextHibernate.class.getName());
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("OSRSMate");

    @Override
    public CharacterProgressModel getUserScoreByUsername(String username) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "SELECT c FROM CharacterProgressModel c WHERE c.name = :characterName ORDER BY c.id DESC";
        TypedQuery<CharacterProgressModel> typedQuery = entityManager.createQuery(hql, CharacterProgressModel.class);
        typedQuery.setParameter("characterName", username);
        typedQuery.setMaxResults(1);
        CharacterProgressModel characterProgressModel = null;
        try {
            characterProgressModel = typedQuery.getSingleResult();
        }catch (Exception ex){
            String message = "Unexpected Exception ";
            logger.log(Level.SEVERE, message, ex);
        }
        finally {
            entityManager.close();
        }
        return characterProgressModel;
    }

    @Override
    public boolean addUserScore(CharacterProgressModel characterProgressModel) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(characterProgressModel);
            entityTransaction.commit();
        }catch (Exception ex){
            if(entityTransaction != null){
                entityTransaction.rollback();
            }
            String message = "Unexpected Exception ";
            logger.log(Level.SEVERE, message, ex);
            return false;
        }
        finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public List<CharacterProgressModel> getUserScoresByUsername(String username) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "FROM CharacterProgressModel";
        TypedQuery<CharacterProgressModel> typedQuery = entityManager.createQuery(hql, CharacterProgressModel.class);
        List<CharacterProgressModel> characterProgressModels = null;
        try {
            characterProgressModels = typedQuery.getResultList();

        }catch (Exception ex){
            String message = "Unexpected Exception ";
            logger.log(Level.SEVERE, message, ex);
        }
        finally {
            entityManager.close();
        }
        return characterProgressModels;
    }
}
