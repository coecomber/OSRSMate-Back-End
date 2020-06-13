package com.herwaarden.osrsmate.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "character")
public class CharacterModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "characterName", nullable = false)
    private String characterName;

    @Column(name = "userUID", nullable = false)
    private String userUID;

    public CharacterModel() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }
}
