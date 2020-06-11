package com.herwaarden.osrsmate.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "characterProgress")
public class CharacterProgressModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "characterName", nullable = false)
    private String name;

    @Column(name = "OverallExp", nullable = false)
    private int overallExp;

    @Column(name = "AttackExp", nullable = false)
    private int attackExp;

    @Column(name = "DefenceExp", nullable = false)
    private int defenceExp;

    @Column(name = "StrengthExp", nullable = false)
    private int strengthExp;

    @Column(name = "HitpointsExp", nullable = false)
    private int hitpointsExp;

    @Column(name = "RangedExp", nullable = false)
    private int rangedExp;

    @Column(name = "PrayerExp", nullable = false)
    private int prayerExp;

    @Column(name = "MagicExp", nullable = false)
    private int magicExp;

    @Column(name = "CookingExp", nullable = false)
    private int cookingExp;

    @Column(name = "WoodcuttingExp", nullable = false)
    private int woodcuttingExp;

    @Column(name = "FletchingExp", nullable = false)
    private int fletchingExp;

    @Column(name = "FishingExp", nullable = false)
    private int fishingExp;

    @Column(name = "FiremakingExp", nullable = false)
    private int firemakingExp;

    @Column(name = "CraftingExp", nullable = false)
    private int craftingExp;

    @Column(name = "SmithingExp", nullable = false)
    private int smithingExp;

    @Column(name = "MiningExp", nullable = false)
    private int miningExp;

    @Column(name = "HerbloreExp", nullable = false)
    private int herbloreExp;

    @Column(name = "AgilityExp", nullable = false)
    private int agilityExp;

    @Column(name = "ThievingExp", nullable = false)
    private int thievingExp;

    @Column(name = "SlayerExp", nullable = false)
    private int slayerExp;

    @Column(name = "FarmingExp", nullable = false)
    private int farmingExp;

    @Column(name = "RunecraftExp", nullable = false)
    private int runecraftExp;

    @Column(name = "HunterExp", nullable = false)
    private int hunterExp;

    @Column(name = "ConstructionExp", nullable = false)
    private int constructionExp;



    public CharacterProgressModel(){

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

    public int getAttackExp() {
        return attackExp;
    }

    public void setAttackExp(int attackExp) {
        this.attackExp = attackExp;
    }

    public int getDefenceExp() {
        return defenceExp;
    }

    public void setDefenceExp(int defenceExp) {
        this.defenceExp = defenceExp;
    }

    public int getStrengthExp() {
        return strengthExp;
    }

    public void setStrengthExp(int strengthExp) {
        this.strengthExp = strengthExp;
    }

    public int getHitpointsExp() {
        return hitpointsExp;
    }

    public void setHitpointsExp(int hitpointsExp) {
        this.hitpointsExp = hitpointsExp;
    }

    public int getRangedExp() {
        return rangedExp;
    }

    public void setRangedExp(int rangedExp) {
        this.rangedExp = rangedExp;
    }

    public int getPrayerExp() {
        return prayerExp;
    }

    public void setPrayerExp(int prayerExp) {
        this.prayerExp = prayerExp;
    }

    public int getMagicExp() {
        return magicExp;
    }

    public void setMagicExp(int magicExp) {
        this.magicExp = magicExp;
    }

    public int getCookingExp() {
        return cookingExp;
    }

    public void setCookingExp(int cookingExp) {
        this.cookingExp = cookingExp;
    }

    public int getWoodcuttingExp() {
        return woodcuttingExp;
    }

    public void setWoodcuttingExp(int woodcuttingExp) {
        this.woodcuttingExp = woodcuttingExp;
    }

    public int getFletchingExp() {
        return fletchingExp;
    }

    public void setFletchingExp(int fletchingExp) {
        this.fletchingExp = fletchingExp;
    }

    public int getFishingExp() {
        return fishingExp;
    }

    public void setFishingExp(int fishingExp) {
        this.fishingExp = fishingExp;
    }

    public int getFiremakingExp() {
        return firemakingExp;
    }

    public void setFiremakingExp(int firemakingExp) {
        this.firemakingExp = firemakingExp;
    }

    public int getCraftingExp() {
        return craftingExp;
    }

    public void setCraftingExp(int craftingExp) {
        this.craftingExp = craftingExp;
    }

    public int getSmithingExp() {
        return smithingExp;
    }

    public void setSmithingExp(int smithingExp) {
        this.smithingExp = smithingExp;
    }

    public int getMiningExp() {
        return miningExp;
    }

    public void setMiningExp(int miningExp) {
        this.miningExp = miningExp;
    }

    public int getHerbloreExp() {
        return herbloreExp;
    }

    public void setHerbloreExp(int herbloreExp) {
        this.herbloreExp = herbloreExp;
    }

    public int getAgilityExp() {
        return agilityExp;
    }

    public void setAgilityExp(int agilityExp) {
        this.agilityExp = agilityExp;
    }

    public int getThievingExp() {
        return thievingExp;
    }

    public void setThievingExp(int thievingExp) {
        this.thievingExp = thievingExp;
    }

    public int getSlayerExp() {
        return slayerExp;
    }

    public void setSlayerExp(int slayerExp) {
        this.slayerExp = slayerExp;
    }

    public int getFarmingExp() {
        return farmingExp;
    }

    public void setFarmingExp(int farmingExp) {
        this.farmingExp = farmingExp;
    }

    public int getRunecraftExp() {
        return runecraftExp;
    }

    public void setRunecraftExp(int runecraftExp) {
        this.runecraftExp = runecraftExp;
    }

    public int getHunterExp() {
        return hunterExp;
    }

    public void setHunterExp(int hunterExp) {
        this.hunterExp = hunterExp;
    }

    public int getConstructionExp() {
        return constructionExp;
    }

    public void setConstructionExp(int constructionExp) {
        this.constructionExp = constructionExp;
    }
}
