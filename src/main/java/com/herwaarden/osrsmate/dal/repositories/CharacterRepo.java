package com.herwaarden.osrsmate.dal.repositories;

import com.herwaarden.osrsmate.dal.interfaces.ICharacterContext;
import com.herwaarden.osrsmate.models.CharacterModel;

import java.util.List;

public class CharacterRepo implements ICharacterContext {

    private ICharacterContext context;

    public CharacterRepo(ICharacterContext context){
        this.context = context;
    }

    @Override
    public List<CharacterModel> getCharactersByUID(String UID) {
        return context.getCharactersByUID(UID);
    }

    @Override
    public CharacterModel getCharacterByCharacterName(String characterName) {
        return context.getCharacterByCharacterName(characterName);
    }
}
