package com.herwaarden.osrsmate.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "quest")
public class QuestModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "requiredAttack", nullable = false)
    private int requiredAttack;

    @Column(name = "requiredDefence", nullable = false)
    private int requiredDefence;

    @Column(name = "requiredStrength", nullable = false)
    private int requiredStrength;

    @Column(name = "requiredHitpoints", nullable = false)
    private int requiredHitpoints;

    @Column(name = "requiredRanged", nullable = false)
    private int requiredRanged;

    @Column(name = "requiredPrayer", nullable = false)
    private int requiredPrayer;

    @Column(name = "requiredMagic", nullable = false)
    private int requiredMagic;

    @Column(name = "requiredCooking", nullable = false)
    private int requiredCooking;

    @Column(name = "requiredWoodcutting", nullable = false)
    private int requiredWoodcutting;

    @Column(name = "requiredFletching", nullable = false)
    private int requiredFletching;

    @Column(name = "requiredFishing", nullable = false)
    private int requiredFishing;

    @Column(name = "requiredFiremaking", nullable = false)
    private int requiredFiremaking;

    @Column(name = "requiredCrafting", nullable = false)
    private int requiredCrafting;

    @Column(name = "requiredSmithing", nullable = false)
    private int requiredSmithing;

    @Column(name = "requiredMining", nullable = false)
    private int requiredMining;

    @Column(name = "requiredHerblore", nullable = false)
    private int requiredHerblore;

    @Column(name = "requiredAgility", nullable = false)
    private int requiredAgility;

    @Column(name = "requiredThieving", nullable = false)
    private int requiredThieving;

    @Column(name = "requiredSlayer", nullable = false)
    private int requiredSlayer;

    @Column(name = "requiredFarming", nullable = false)
    private int requiredFarming;

    @Column(name = "requiredRunecrafting", nullable = false)
    private int requiredRunecrafting;

    @Column(name = "requiredHunter", nullable = false)
    private int requiredHunter;

    @Column(name = "requiredConstruction", nullable = false)
    private int requiredConstruction;

    public QuestModel(){

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

    public int getRequiredAttack() {
        return requiredAttack;
    }

    public void setRequiredAttack(int requiredAttack) {
        this.requiredAttack = requiredAttack;
    }

    public int getRequiredDefence() {
        return requiredDefence;
    }

    public void setRequiredDefence(int requiredDefence) {
        this.requiredDefence = requiredDefence;
    }

    public int getRequiredStrength() {
        return requiredStrength;
    }

    public void setRequiredStrength(int requiredStrength) {
        this.requiredStrength = requiredStrength;
    }

    public int getRequiredHitpoints() {
        return requiredHitpoints;
    }

    public void setRequiredHitpoints(int requiredHitpoints) {
        this.requiredHitpoints = requiredHitpoints;
    }

    public int getRequiredRanged() {
        return requiredRanged;
    }

    public void setRequiredRanged(int requiredRanged) {
        this.requiredRanged = requiredRanged;
    }

    public int getRequiredPrayer() {
        return requiredPrayer;
    }

    public void setRequiredPrayer(int requiredPrayer) {
        this.requiredPrayer = requiredPrayer;
    }

    public int getRequiredMagic() {
        return requiredMagic;
    }

    public void setRequiredMagic(int requiredMagic) {
        this.requiredMagic = requiredMagic;
    }

    public int getRequiredCooking() {
        return requiredCooking;
    }

    public void setRequiredCooking(int requiredCooking) {
        this.requiredCooking = requiredCooking;
    }

    public int getRequiredWoodcutting() {
        return requiredWoodcutting;
    }

    public void setRequiredWoodcutting(int requiredWoodcutting) {
        this.requiredWoodcutting = requiredWoodcutting;
    }

    public int getRequiredFletching() {
        return requiredFletching;
    }

    public void setRequiredFletching(int requiredFletching) {
        this.requiredFletching = requiredFletching;
    }

    public int getRequiredFishing() {
        return requiredFishing;
    }

    public void setRequiredFishing(int requiredFishing) {
        this.requiredFishing = requiredFishing;
    }

    public int getRequiredFiremaking() {
        return requiredFiremaking;
    }

    public void setRequiredFiremaking(int requiredFiremaking) {
        this.requiredFiremaking = requiredFiremaking;
    }

    public int getRequiredCrafting() {
        return requiredCrafting;
    }

    public void setRequiredCrafting(int requiredCrafting) {
        this.requiredCrafting = requiredCrafting;
    }

    public int getRequiredSmithing() {
        return requiredSmithing;
    }

    public void setRequiredSmithing(int requiredSmithing) {
        this.requiredSmithing = requiredSmithing;
    }

    public int getRequiredMining() {
        return requiredMining;
    }

    public void setRequiredMining(int requiredMining) {
        this.requiredMining = requiredMining;
    }

    public int getRequiredHerblore() {
        return requiredHerblore;
    }

    public void setRequiredHerblore(int requiredHerblore) {
        this.requiredHerblore = requiredHerblore;
    }

    public int getRequiredAgility() {
        return requiredAgility;
    }

    public void setRequiredAgility(int requiredAgility) {
        this.requiredAgility = requiredAgility;
    }

    public int getRequiredThieving() {
        return requiredThieving;
    }

    public void setRequiredThieving(int requiredThieving) {
        this.requiredThieving = requiredThieving;
    }

    public int getRequiredSlayer() {
        return requiredSlayer;
    }

    public void setRequiredSlayer(int requiredSlayer) {
        this.requiredSlayer = requiredSlayer;
    }

    public int getRequiredFarming() {
        return requiredFarming;
    }

    public void setRequiredFarming(int requiredFarming) {
        this.requiredFarming = requiredFarming;
    }

    public int getRequiredRunecrafting() {
        return requiredRunecrafting;
    }

    public void setRequiredRunecrafting(int requiredRunecrafting) {
        this.requiredRunecrafting = requiredRunecrafting;
    }

    public int getRequiredHunter() {
        return requiredHunter;
    }

    public void setRequiredHunter(int requiredHunter) {
        this.requiredHunter = requiredHunter;
    }

    public int getRequiredConstruction() {
        return requiredConstruction;
    }

    public void setRequiredConstruction(int requiredConstruction) {
        this.requiredConstruction = requiredConstruction;
    }
}
