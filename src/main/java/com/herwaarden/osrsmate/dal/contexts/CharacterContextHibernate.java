package com.herwaarden.osrsmate.dal.contexts;

import com.herwaarden.osrsmate.dal.interfaces.ICharacterContext;
import com.herwaarden.osrsmate.models.CharacterModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CharacterContextHibernate implements ICharacterContext {

    Logger logger = Logger.getLogger(HighscoresContextHibernate.class.getName());
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("OSRSMate");

    @Override
    public List<CharacterModel> getCharactersByUID(String UID) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "FROM CharacterModel";
        TypedQuery<CharacterModel> typedQuery = entityManager.createQuery(hql, CharacterModel.class);
        List<CharacterModel> characterModels = null;
        try {
            System.out.println("result list:");
            System.out.println(typedQuery.getResultList());
            characterModels = typedQuery.getResultList();
        }catch (Exception ex){
            String message = "Unexpected Exception in getCharacterByUID ";
            logger.log(Level.SEVERE, message, ex);
        }
        finally {
            entityManager.close();
        }
        return characterModels;
    }

    @Override
    public CharacterModel getCharacterByCharacterName(String characterName) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String hql = "SELECT c FROM CharacterModel c WHERE c.characterName = :characterName";
        TypedQuery<CharacterModel> typedQuery = entityManager.createQuery(hql, CharacterModel.class);
        typedQuery.setParameter("characterName", characterName);
        CharacterModel characterModel = null;
        try {
            characterModel = typedQuery.getSingleResult();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            entityManager.close();
        }
        return characterModel;
    }
}
