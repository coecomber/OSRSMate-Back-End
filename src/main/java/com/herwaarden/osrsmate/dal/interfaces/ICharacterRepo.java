package com.herwaarden.osrsmate.dal.interfaces;

import com.herwaarden.osrsmate.models.CharacterModel;

import java.util.List;

public interface ICharacterRepo {
    List<CharacterModel> getCharactersByUID(String UID);

    CharacterModel getCharacterByCharacterName(String characterName);
}
