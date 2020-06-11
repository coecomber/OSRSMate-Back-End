package com.herwaarden.osrsmate.resources;

import com.herwaarden.osrsmate.dal.contexts.CharacterContextHibernate;
import com.herwaarden.osrsmate.dal.repositories.CharacterRepo;
import com.herwaarden.osrsmate.logic.CharacterLogic;
import com.herwaarden.osrsmate.models.CharacterModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/public/character")
public class CharacterResource {

    CharacterLogic characterLogic = new CharacterLogic(new CharacterRepo(new CharacterContextHibernate()));

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "/getCharactersByUserUID/{UID}")
    public List<CharacterModel> GetCharactersByUserUID(@PathVariable("UID")String uid){
        return characterLogic.getCharactersByUID(uid);
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "/getCharacterByCharacterName/{characterName}")
    public CharacterModel GetCharacterByCharacterName(@PathVariable("characterName")String characterName){
        return characterLogic.getCharacterByCharacterName(characterName);
    }
}
