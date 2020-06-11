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
}
