package com.herwaarden.osrsmate.factories;

import com.herwaarden.osrsmate.dal.contexts.CharacterContextHibernate;
import com.herwaarden.osrsmate.dal.interfaces.ICharacterRepo;
import com.herwaarden.osrsmate.dal.repositories.CharacterRepo;

public class CharacterFactory {

    public ICharacterRepo createCharacterRepo() {
        return new CharacterRepo(new CharacterContextHibernate());
    }
}
