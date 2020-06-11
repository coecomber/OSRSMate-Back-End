package com.herwaarden.osrsmate.logic;

import com.herwaarden.osrsmate.dal.interfaces.ICharacterRepo;
import com.herwaarden.osrsmate.factories.CharacterFactory;
import com.herwaarden.osrsmate.models.CharacterModel;

import java.util.List;

public class CharacterLogic {
    private CharacterFactory characterFactory = new CharacterFactory();
    private ICharacterRepo characterRepo;

    public CharacterLogic(ICharacterRepo repo) {
        characterRepo = ((repo == null) ? characterFactory.createCharacterRepo() : repo);
    }

    public List<CharacterModel> getCharactersByUID(String UID){
        return characterRepo.getCharactersByUID(UID);
    }

    public CharacterModel getCharacterByCharacterName(String characterName){
        return characterRepo.getCharacterByCharacterName(characterName);
    }
}
