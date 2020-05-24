package com.herwaarden.osrsmate.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "characterProgress")
public class userScore implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "characterName", nullable = false)
    private String name;

    @Column(name = "OverallExp", nullable = false)
    private int overallExp;

    public userScore(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOverallExp() {
        return overallExp;
    }

    public void setOverallExp(int overallExp) {
        this.overallExp = overallExp;
    }
}
