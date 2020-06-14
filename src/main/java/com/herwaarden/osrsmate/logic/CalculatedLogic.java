package com.herwaarden.osrsmate.logic;

import com.herwaarden.osrsmate.dal.interfaces.IAchievementRepo;
import com.herwaarden.osrsmate.dal.interfaces.IHighscoresRepo;
import com.herwaarden.osrsmate.dal.interfaces.IQuestRepo;
import com.herwaarden.osrsmate.factories.AchievementFactory;
import com.herwaarden.osrsmate.factories.HighscoresFactory;
import com.herwaarden.osrsmate.factories.QuestFactory;
import com.herwaarden.osrsmate.models.AchievementModel;
import com.herwaarden.osrsmate.models.CharacterProgressModel;
import com.herwaarden.osrsmate.models.QuestModel;
import viewModels.CalculatedAchievements;
import viewModels.CalculatedQuests;
import viewModels.Stat;

import java.util.ArrayList;
import java.util.List;

public class CalculatedLogic {
    private QuestFactory questFactory = new QuestFactory();
    private IQuestRepo questRepo;
    private AchievementFactory achievementFactory = new AchievementFactory();
    private IAchievementRepo achievementRepo;
    private HighscoresFactory highscoresFactory = new HighscoresFactory();
    private IHighscoresRepo highscoresRepo;

    public CalculatedLogic(IQuestRepo QuestRepo, IAchievementRepo AchievementRepo, IHighscoresRepo HighscoresRepo) {
        questRepo = ((QuestRepo == null) ? questFactory.createQuestRepo() : QuestRepo);
        achievementRepo = ((AchievementRepo == null) ? achievementFactory.createAchievementRepo() : AchievementRepo);
        highscoresRepo = ((HighscoresRepo == null) ? highscoresFactory.createHighscoresRepo() : HighscoresRepo);
    }

    public List<CalculatedQuests> getQuests(String characterName){
        List<CalculatedQuests> questsToReturn = new ArrayList<>();

        List<QuestModel> questModels = questRepo.getQuests();
        CharacterProgressModel characterProgressModel = highscoresRepo.getUserScoreByUsername(characterName);

        for(QuestModel questModel : questModels){
            CalculatedQuests calculatedQuest = new CalculatedQuests();
            calculatedQuest.setAvailable(true);
            calculatedQuest.setName(questModel.getName());

            //Attack
            if(questModel.getRequiredAttack() > characterProgressModel.getAttackExp() && questModel.getRequiredAttack() != 1){
                calculatedQuest.setAvailable(false);
                Stat attackStat = new Stat();
                attackStat.setStatName("Attack");
                attackStat.setExperience(questModel.getRequiredAttack());
                attackStat.setHighEnough(false);
                calculatedQuest.getStatList().add(attackStat);
            } else if(questModel.getRequiredAttack() < characterProgressModel.getAttackExp() && questModel.getRequiredAttack() != 1){
                Stat attackStat = new Stat();
                attackStat.setStatName("Attack");
                attackStat.setExperience(questModel.getRequiredAttack());
                attackStat.setHighEnough(true);
                calculatedQuest.getStatList().add(attackStat);
            }

            //Defence
            if(questModel.getRequiredDefence() > characterProgressModel.getDefenceExp() && questModel.getRequiredDefence() != 1){
                calculatedQuest.setAvailable(false);
                Stat defenceStat = new Stat();
                defenceStat.setStatName("Defence");
                defenceStat.setExperience(questModel.getRequiredDefence());
                defenceStat.setHighEnough(false);
                calculatedQuest.getStatList().add(defenceStat);
            } else if(questModel.getRequiredAttack() < characterProgressModel.getAttackExp() && questModel.getRequiredAttack() != 1){
                Stat defenceStat = new Stat();
                defenceStat.setStatName("Defence");
                defenceStat.setExperience(questModel.getRequiredDefence());
                defenceStat.setHighEnough(true);
                calculatedQuest.getStatList().add(defenceStat);
            }

            //Strength
            if(questModel.getRequiredStrength() > characterProgressModel.getStrengthExp() && questModel.getRequiredStrength() != 1){
                calculatedQuest.setAvailable(false);
                Stat strengthStat = new Stat();
                strengthStat.setStatName("Strength");
                strengthStat.setExperience(questModel.getRequiredStrength());
                strengthStat.setHighEnough(false);
                calculatedQuest.getStatList().add(strengthStat);
            } else if(questModel.getRequiredStrength() < characterProgressModel.getStrengthExp() && questModel.getRequiredStrength() != 1){
                Stat strengthStat = new Stat();
                strengthStat.setStatName("Strength");
                strengthStat.setExperience(questModel.getRequiredStrength());
                strengthStat.setHighEnough(true);
                calculatedQuest.getStatList().add(strengthStat);
            }

            //Hitpoints
            if(questModel.getRequiredHitpoints() > characterProgressModel.getHitpointsExp() && questModel.getRequiredHitpoints() != 1){
                calculatedQuest.setAvailable(false);
                Stat hitpointsStat = new Stat();
                hitpointsStat.setStatName("Hitpoints");
                hitpointsStat.setExperience(questModel.getRequiredHitpoints());
                hitpointsStat.setHighEnough(false);
                calculatedQuest.getStatList().add(hitpointsStat);
            } else if(questModel.getRequiredHitpoints() < characterProgressModel.getHitpointsExp() && questModel.getRequiredHitpoints() != 1){
                Stat hitpointsStat = new Stat();
                hitpointsStat.setStatName("Hitpoints");
                hitpointsStat.setExperience(questModel.getRequiredHitpoints());
                hitpointsStat.setHighEnough(true);
                calculatedQuest.getStatList().add(hitpointsStat);
            }

            //Ranged
            if(questModel.getRequiredRanged() > characterProgressModel.getRangedExp() && questModel.getRequiredRanged() != 1){
                calculatedQuest.setAvailable(false);
                Stat rangedStat = new Stat();
                rangedStat.setStatName("Ranged");
                rangedStat.setExperience(questModel.getRequiredRanged());
                rangedStat.setHighEnough(false);
                calculatedQuest.getStatList().add(rangedStat);
            } else if(questModel.getRequiredRanged() < characterProgressModel.getRangedExp() && questModel.getRequiredRanged() != 1){
                Stat rangedStat = new Stat();
                rangedStat.setStatName("Ranged");
                rangedStat.setExperience(questModel.getRequiredRanged());
                rangedStat.setHighEnough(true);
                calculatedQuest.getStatList().add(rangedStat);
            }

            //Prayer
            if(questModel.getRequiredPrayer() > characterProgressModel.getPrayerExp() && questModel.getRequiredPrayer() != 1){
                calculatedQuest.setAvailable(false);
                Stat prayerStat = new Stat();
                prayerStat.setStatName("Prayer");
                prayerStat.setExperience(questModel.getRequiredPrayer());
                prayerStat.setHighEnough(false);
                calculatedQuest.getStatList().add(prayerStat);
            } else if(questModel.getRequiredPrayer() < characterProgressModel.getPrayerExp() && questModel.getRequiredPrayer() != 1){
                Stat prayerStat = new Stat();
                prayerStat.setStatName("Prayer");
                prayerStat.setExperience(questModel.getRequiredPrayer());
                prayerStat.setHighEnough(true);
                calculatedQuest.getStatList().add(prayerStat);
            }

            //Magic
            if(questModel.getRequiredMagic() > characterProgressModel.getMagicExp() && questModel.getRequiredMagic() != 1){
                calculatedQuest.setAvailable(false);
                Stat magicStat = new Stat();
                magicStat.setStatName("Magic");
                magicStat.setExperience(questModel.getRequiredMagic());
                magicStat.setHighEnough(false);
                calculatedQuest.getStatList().add(magicStat);
            } else if(questModel.getRequiredMagic() < characterProgressModel.getMagicExp() && questModel.getRequiredMagic() != 1){
                Stat magicStat = new Stat();
                magicStat.setStatName("Magic");
                magicStat.setExperience(questModel.getRequiredMagic());
                magicStat.setHighEnough(true);
                calculatedQuest.getStatList().add(magicStat);
            }

            //Cooking
            if(questModel.getRequiredCooking() > characterProgressModel.getCookingExp() && questModel.getRequiredCooking() != 1){
                calculatedQuest.setAvailable(false);
                Stat cookingStat = new Stat();
                cookingStat.setStatName("Cooking");
                cookingStat.setExperience(questModel.getRequiredCooking());
                cookingStat.setHighEnough(false);
                calculatedQuest.getStatList().add(cookingStat);
            } else if(questModel.getRequiredCooking() < characterProgressModel.getCookingExp() && questModel.getRequiredCooking() != 1){
                Stat cookingStat = new Stat();
                cookingStat.setStatName("Cooking");
                cookingStat.setExperience(questModel.getRequiredCooking());
                cookingStat.setHighEnough(true);
                calculatedQuest.getStatList().add(cookingStat);
            }

            //Woodcutting
            if(questModel.getRequiredWoodcutting() > characterProgressModel.getWoodcuttingExp() && questModel.getRequiredWoodcutting() != 1){
                calculatedQuest.setAvailable(false);
                Stat woodcuttingStat = new Stat();
                woodcuttingStat.setStatName("Woodcutting");
                woodcuttingStat.setExperience(questModel.getRequiredWoodcutting());
                woodcuttingStat.setHighEnough(false);
                calculatedQuest.getStatList().add(woodcuttingStat);
            } else if(questModel.getRequiredWoodcutting() < characterProgressModel.getWoodcuttingExp() && questModel.getRequiredWoodcutting() != 1){
                Stat woodcuttingStat = new Stat();
                woodcuttingStat.setStatName("Woodcutting");
                woodcuttingStat.setExperience(questModel.getRequiredWoodcutting());
                woodcuttingStat.setHighEnough(true);
                calculatedQuest.getStatList().add(woodcuttingStat);
            }

            //fletching
            if(questModel.getRequiredFletching() > characterProgressModel.getFletchingExp() && questModel.getRequiredFletching() != 1){
                calculatedQuest.setAvailable(false);
                Stat fletchingStat = new Stat();
                fletchingStat.setStatName("Fletching");
                fletchingStat.setExperience(questModel.getRequiredFletching());
                fletchingStat.setHighEnough(false);
                calculatedQuest.getStatList().add(fletchingStat);
            } else if(questModel.getRequiredFletching() < characterProgressModel.getFletchingExp() && questModel.getRequiredFletching() != 1){
                Stat fletchingStat = new Stat();
                fletchingStat.setStatName("Fletching");
                fletchingStat.setExperience(questModel.getRequiredFletching());
                fletchingStat.setHighEnough(true);
                calculatedQuest.getStatList().add(fletchingStat);
            }

            //Fishing
            if(questModel.getRequiredFishing() > characterProgressModel.getFishingExp() && questModel.getRequiredFishing() != 1){
                calculatedQuest.setAvailable(false);
                Stat FishingStat = new Stat();
                FishingStat.setStatName("Fishing");
                FishingStat.setExperience(questModel.getRequiredFishing());
                FishingStat.setHighEnough(false);
                calculatedQuest.getStatList().add(FishingStat);
            } else if(questModel.getRequiredFishing() < characterProgressModel.getFishingExp() && questModel.getRequiredFishing() != 1){
                Stat FishingStat = new Stat();
                FishingStat.setStatName("Fishing");
                FishingStat.setExperience(questModel.getRequiredFishing());
                FishingStat.setHighEnough(true);
                calculatedQuest.getStatList().add(FishingStat);
            }

            //Firemaking
            if(questModel.getRequiredFiremaking() > characterProgressModel.getFiremakingExp() && questModel.getRequiredFiremaking() != 1){
                calculatedQuest.setAvailable(false);
                Stat FiremakingStat = new Stat();
                FiremakingStat.setStatName("Firemaking");
                FiremakingStat.setExperience(questModel.getRequiredFiremaking());
                FiremakingStat.setHighEnough(false);
                calculatedQuest.getStatList().add(FiremakingStat);
            } else if(questModel.getRequiredFiremaking() < characterProgressModel.getFiremakingExp() && questModel.getRequiredFiremaking() != 1){
                Stat FiremakingStat = new Stat();
                FiremakingStat.setStatName("Firemaking");
                FiremakingStat.setExperience(questModel.getRequiredFiremaking());
                FiremakingStat.setHighEnough(true);
                calculatedQuest.getStatList().add(FiremakingStat);
            }

            //Crafting
            if(questModel.getRequiredCrafting() > characterProgressModel.getCraftingExp() && questModel.getRequiredCrafting() != 1){
                calculatedQuest.setAvailable(false);
                Stat CraftingStat = new Stat();
                CraftingStat.setStatName("Crafting");
                CraftingStat.setExperience(questModel.getRequiredCrafting());
                CraftingStat.setHighEnough(false);
                calculatedQuest.getStatList().add(CraftingStat);
            } else if(questModel.getRequiredCrafting() < characterProgressModel.getCraftingExp() && questModel.getRequiredCrafting() != 1){
                Stat CraftingStat = new Stat();
                CraftingStat.setStatName("Crafting");
                CraftingStat.setExperience(questModel.getRequiredCrafting());
                CraftingStat.setHighEnough(true);
                calculatedQuest.getStatList().add(CraftingStat);
            }

            //Smithing
            if(questModel.getRequiredSmithing() > characterProgressModel.getSmithingExp() && questModel.getRequiredSmithing() != 1){
                calculatedQuest.setAvailable(false);
                Stat SmithingStat = new Stat();
                SmithingStat.setStatName("Smithing");
                SmithingStat.setExperience(questModel.getRequiredSmithing());
                SmithingStat.setHighEnough(false);
                calculatedQuest.getStatList().add(SmithingStat);
            } else if(questModel.getRequiredSmithing() < characterProgressModel.getSmithingExp() && questModel.getRequiredSmithing() != 1){
                Stat SmithingStat = new Stat();
                SmithingStat.setStatName("Smithing");
                SmithingStat.setExperience(questModel.getRequiredSmithing());
                SmithingStat.setHighEnough(true);
                calculatedQuest.getStatList().add(SmithingStat);
            }

            //Mining
            if(questModel.getRequiredMining() > characterProgressModel.getMiningExp() && questModel.getRequiredMining() != 1){
                calculatedQuest.setAvailable(false);
                Stat MiningStat = new Stat();
                MiningStat.setStatName("Mining");
                MiningStat.setExperience(questModel.getRequiredMining());
                MiningStat.setHighEnough(false);
                calculatedQuest.getStatList().add(MiningStat);
            } else if(questModel.getRequiredMining() < characterProgressModel.getMiningExp() && questModel.getRequiredMining() != 1){
                Stat MiningStat = new Stat();
                MiningStat.setStatName("Mining");
                MiningStat.setExperience(questModel.getRequiredMining());
                MiningStat.setHighEnough(true);
                calculatedQuest.getStatList().add(MiningStat);
            }

            //Herblore
            if(questModel.getRequiredHerblore() > characterProgressModel.getHerbloreExp() && questModel.getRequiredHerblore() != 1){
                calculatedQuest.setAvailable(false);
                Stat HerbloreStat = new Stat();
                HerbloreStat.setStatName("Herblore");
                HerbloreStat.setExperience(questModel.getRequiredHerblore());
                HerbloreStat.setHighEnough(false);
                calculatedQuest.getStatList().add(HerbloreStat);
            } else if(questModel.getRequiredHerblore() < characterProgressModel.getHerbloreExp() && questModel.getRequiredHerblore() != 1){
                Stat HerbloreStat = new Stat();
                HerbloreStat.setStatName("Herblore");
                HerbloreStat.setExperience(questModel.getRequiredHerblore());
                HerbloreStat.setHighEnough(true);
                calculatedQuest.getStatList().add(HerbloreStat);
            }

            //Agility
            if(questModel.getRequiredAgility() > characterProgressModel.getAgilityExp() && questModel.getRequiredAgility() != 1){
                calculatedQuest.setAvailable(false);
                Stat AgilityStat = new Stat();
                AgilityStat.setStatName("Agility");
                AgilityStat.setExperience(questModel.getRequiredAgility());
                AgilityStat.setHighEnough(false);
                calculatedQuest.getStatList().add(AgilityStat);
            } else if(questModel.getRequiredAgility() < characterProgressModel.getAgilityExp() && questModel.getRequiredAgility() != 1){
                Stat AgilityStat = new Stat();
                AgilityStat.setStatName("Agility");
                AgilityStat.setExperience(questModel.getRequiredAgility());
                AgilityStat.setHighEnough(true);
                calculatedQuest.getStatList().add(AgilityStat);
            }

            //Thieving
            if(questModel.getRequiredThieving() > characterProgressModel.getThievingExp() && questModel.getRequiredThieving() != 1){
                calculatedQuest.setAvailable(false);
                Stat ThievingStat = new Stat();
                ThievingStat.setStatName("Thieving");
                ThievingStat.setExperience(questModel.getRequiredThieving());
                ThievingStat.setHighEnough(false);
                calculatedQuest.getStatList().add(ThievingStat);
            } else if(questModel.getRequiredThieving() < characterProgressModel.getThievingExp() && questModel.getRequiredThieving() != 1){
                Stat ThievingStat = new Stat();
                ThievingStat.setStatName("Thieving");
                ThievingStat.setExperience(questModel.getRequiredThieving());
                ThievingStat.setHighEnough(true);
                calculatedQuest.getStatList().add(ThievingStat);
            }

            //Slayer
            if(questModel.getRequiredSlayer() > characterProgressModel.getSlayerExp() && questModel.getRequiredSlayer() != 1){
                calculatedQuest.setAvailable(false);
                Stat SlayerStat = new Stat();
                SlayerStat.setStatName("Slayer");
                SlayerStat.setExperience(questModel.getRequiredSlayer());
                SlayerStat.setHighEnough(false);
                calculatedQuest.getStatList().add(SlayerStat);
            } else if(questModel.getRequiredSlayer() < characterProgressModel.getSlayerExp() && questModel.getRequiredSlayer() != 1){
                Stat SlayerStat = new Stat();
                SlayerStat.setStatName("Slayer");
                SlayerStat.setExperience(questModel.getRequiredSlayer());
                SlayerStat.setHighEnough(true);
                calculatedQuest.getStatList().add(SlayerStat);
            }

            //Farming
            if(questModel.getRequiredFarming() > characterProgressModel.getFarmingExp() && questModel.getRequiredFarming() != 1){
                calculatedQuest.setAvailable(false);
                Stat FarmingStat = new Stat();
                FarmingStat.setStatName("Farming");
                FarmingStat.setExperience(questModel.getRequiredFarming());
                FarmingStat.setHighEnough(false);
                calculatedQuest.getStatList().add(FarmingStat);
            } else if(questModel.getRequiredFarming() < characterProgressModel.getFarmingExp() && questModel.getRequiredFarming() != 1){
                Stat FarmingStat = new Stat();
                FarmingStat.setStatName("Farming");
                FarmingStat.setExperience(questModel.getRequiredFarming());
                FarmingStat.setHighEnough(true);
                calculatedQuest.getStatList().add(FarmingStat);
            }

            //Runecrafting
            if(questModel.getRequiredRunecrafting() > characterProgressModel.getRunecraftExp() && questModel.getRequiredRunecrafting() != 1){
                calculatedQuest.setAvailable(false);
                Stat RunecraftingStat = new Stat();
                RunecraftingStat.setStatName("Runecrafting");
                RunecraftingStat.setExperience(questModel.getRequiredRunecrafting());
                RunecraftingStat.setHighEnough(false);
                calculatedQuest.getStatList().add(RunecraftingStat);
            } else if(questModel.getRequiredRunecrafting() < characterProgressModel.getRunecraftExp() && questModel.getRequiredRunecrafting() != 1){
                Stat RunecraftingStat = new Stat();
                RunecraftingStat.setStatName("Runecrafting");
                RunecraftingStat.setExperience(questModel.getRequiredRunecrafting());
                RunecraftingStat.setHighEnough(true);
                calculatedQuest.getStatList().add(RunecraftingStat);
            }

            //Hunter
            if(questModel.getRequiredHunter() > characterProgressModel.getHunterExp() && questModel.getRequiredHunter() != 1){
                calculatedQuest.setAvailable(false);
                Stat HunterStat = new Stat();
                HunterStat.setStatName("Hunter");
                HunterStat.setExperience(questModel.getRequiredHunter());
                HunterStat.setHighEnough(false);
                calculatedQuest.getStatList().add(HunterStat);
            } else if(questModel.getRequiredHunter() < characterProgressModel.getHunterExp() && questModel.getRequiredHunter() != 1){
                Stat HunterStat = new Stat();
                HunterStat.setStatName("Hunter");
                HunterStat.setExperience(questModel.getRequiredHunter());
                HunterStat.setHighEnough(true);
                calculatedQuest.getStatList().add(HunterStat);
            }

            //Construction
            if(questModel.getRequiredConstruction() > characterProgressModel.getConstructionExp() && questModel.getRequiredConstruction() != 1){
                calculatedQuest.setAvailable(false);
                Stat ConstructionStat = new Stat();
                ConstructionStat.setStatName("Construction");
                ConstructionStat.setExperience(questModel.getRequiredConstruction());
                ConstructionStat.setHighEnough(false);
                calculatedQuest.getStatList().add(ConstructionStat);
            } else if(questModel.getRequiredConstruction() < characterProgressModel.getConstructionExp() && questModel.getRequiredConstruction() != 1){
                Stat ConstructionStat = new Stat();
                ConstructionStat.setStatName("Construction");
                ConstructionStat.setExperience(questModel.getRequiredConstruction());
                ConstructionStat.setHighEnough(true);
                calculatedQuest.getStatList().add(ConstructionStat);
            }

            questsToReturn.add(calculatedQuest);
        }
        return questsToReturn;
    }

    public List<CalculatedAchievements> getAchievements(String characterName) {
        List<CalculatedAchievements> achievementsToReturn = new ArrayList<>();

        List<AchievementModel> achievementModels = achievementRepo.getAchievements();
        CharacterProgressModel characterProgressModel = highscoresRepo.getUserScoreByUsername(characterName);

        for (AchievementModel achievementModel : achievementModels) {
            CalculatedAchievements calculatedachievement = new CalculatedAchievements();
            calculatedachievement.setAvailable(true);
            calculatedachievement.setName(achievementModel.getRegion() + achievementModel.getDifficulty());

            //Attack
            if (achievementModel.getRequiredAttack() > characterProgressModel.getAttackExp() && achievementModel.getRequiredAttack() != 1) {
                calculatedachievement.setAvailable(false);
                Stat attackStat = new Stat();
                attackStat.setStatName("Attack");
                attackStat.setExperience(achievementModel.getRequiredAttack());
                attackStat.setHighEnough(false);
                calculatedachievement.getStatList().add(attackStat);
            } else if (achievementModel.getRequiredAttack() < characterProgressModel.getAttackExp() && achievementModel.getRequiredAttack() != 1) {
                Stat attackStat = new Stat();
                attackStat.setStatName("Attack");
                attackStat.setExperience(achievementModel.getRequiredAttack());
                attackStat.setHighEnough(true);
                calculatedachievement.getStatList().add(attackStat);
            }

            //Defence
            if (achievementModel.getRequiredDefence() > characterProgressModel.getDefenceExp() && achievementModel.getRequiredDefence() != 1) {
                calculatedachievement.setAvailable(false);
                Stat defenceStat = new Stat();
                defenceStat.setStatName("Defence");
                defenceStat.setExperience(achievementModel.getRequiredDefence());
                defenceStat.setHighEnough(false);
                calculatedachievement.getStatList().add(defenceStat);
            } else if (achievementModel.getRequiredAttack() < characterProgressModel.getAttackExp() && achievementModel.getRequiredAttack() != 1) {
                Stat defenceStat = new Stat();
                defenceStat.setStatName("Defence");
                defenceStat.setExperience(achievementModel.getRequiredDefence());
                defenceStat.setHighEnough(true);
                calculatedachievement.getStatList().add(defenceStat);
            }

            //Strength
            if (achievementModel.getRequiredStrength() > characterProgressModel.getStrengthExp() && achievementModel.getRequiredStrength() != 1) {
                calculatedachievement.setAvailable(false);
                Stat strengthStat = new Stat();
                strengthStat.setStatName("Strength");
                strengthStat.setExperience(achievementModel.getRequiredStrength());
                strengthStat.setHighEnough(false);
                calculatedachievement.getStatList().add(strengthStat);
            } else if (achievementModel.getRequiredStrength() < characterProgressModel.getStrengthExp() && achievementModel.getRequiredStrength() != 1) {
                Stat strengthStat = new Stat();
                strengthStat.setStatName("Strength");
                strengthStat.setExperience(achievementModel.getRequiredStrength());
                strengthStat.setHighEnough(true);
                calculatedachievement.getStatList().add(strengthStat);
            }

            //Hitpoints
            if (achievementModel.getRequiredHitpoints() > characterProgressModel.getHitpointsExp() && achievementModel.getRequiredHitpoints() != 1) {
                calculatedachievement.setAvailable(false);
                Stat hitpointsStat = new Stat();
                hitpointsStat.setStatName("Hitpoints");
                hitpointsStat.setExperience(achievementModel.getRequiredHitpoints());
                hitpointsStat.setHighEnough(false);
                calculatedachievement.getStatList().add(hitpointsStat);
            } else if (achievementModel.getRequiredHitpoints() < characterProgressModel.getHitpointsExp() && achievementModel.getRequiredHitpoints() != 1) {
                Stat hitpointsStat = new Stat();
                hitpointsStat.setStatName("Hitpoints");
                hitpointsStat.setExperience(achievementModel.getRequiredHitpoints());
                hitpointsStat.setHighEnough(true);
                calculatedachievement.getStatList().add(hitpointsStat);
            }

            //Ranged
            if (achievementModel.getRequiredRanged() > characterProgressModel.getRangedExp() && achievementModel.getRequiredRanged() != 1) {
                calculatedachievement.setAvailable(false);
                Stat rangedStat = new Stat();
                rangedStat.setStatName("Ranged");
                rangedStat.setExperience(achievementModel.getRequiredRanged());
                rangedStat.setHighEnough(false);
                calculatedachievement.getStatList().add(rangedStat);
            } else if (achievementModel.getRequiredRanged() < characterProgressModel.getRangedExp() && achievementModel.getRequiredRanged() != 1) {
                Stat rangedStat = new Stat();
                rangedStat.setStatName("Ranged");
                rangedStat.setExperience(achievementModel.getRequiredRanged());
                rangedStat.setHighEnough(true);
                calculatedachievement.getStatList().add(rangedStat);
            }

            //Prayer
            if (achievementModel.getRequiredPrayer() > characterProgressModel.getPrayerExp() && achievementModel.getRequiredPrayer() != 1) {
                calculatedachievement.setAvailable(false);
                Stat prayerStat = new Stat();
                prayerStat.setStatName("Prayer");
                prayerStat.setExperience(achievementModel.getRequiredPrayer());
                prayerStat.setHighEnough(false);
                calculatedachievement.getStatList().add(prayerStat);
            } else if (achievementModel.getRequiredPrayer() < characterProgressModel.getPrayerExp() && achievementModel.getRequiredPrayer() != 1) {
                Stat prayerStat = new Stat();
                prayerStat.setStatName("Prayer");
                prayerStat.setExperience(achievementModel.getRequiredPrayer());
                prayerStat.setHighEnough(true);
                calculatedachievement.getStatList().add(prayerStat);
            }

            //Magic
            if (achievementModel.getRequiredMagic() > characterProgressModel.getMagicExp() && achievementModel.getRequiredMagic() != 1) {
                calculatedachievement.setAvailable(false);
                Stat magicStat = new Stat();
                magicStat.setStatName("Magic");
                magicStat.setExperience(achievementModel.getRequiredMagic());
                magicStat.setHighEnough(false);
                calculatedachievement.getStatList().add(magicStat);
            } else if (achievementModel.getRequiredMagic() < characterProgressModel.getMagicExp() && achievementModel.getRequiredMagic() != 1) {
                Stat magicStat = new Stat();
                magicStat.setStatName("Magic");
                magicStat.setExperience(achievementModel.getRequiredMagic());
                magicStat.setHighEnough(true);
                calculatedachievement.getStatList().add(magicStat);
            }

            //Cooking
            if (achievementModel.getRequiredCooking() > characterProgressModel.getCookingExp() && achievementModel.getRequiredCooking() != 1) {
                calculatedachievement.setAvailable(false);
                Stat cookingStat = new Stat();
                cookingStat.setStatName("Cooking");
                cookingStat.setExperience(achievementModel.getRequiredCooking());
                cookingStat.setHighEnough(false);
                calculatedachievement.getStatList().add(cookingStat);
            } else if (achievementModel.getRequiredCooking() < characterProgressModel.getCookingExp() && achievementModel.getRequiredCooking() != 1) {
                Stat cookingStat = new Stat();
                cookingStat.setStatName("Cooking");
                cookingStat.setExperience(achievementModel.getRequiredCooking());
                cookingStat.setHighEnough(true);
                calculatedachievement.getStatList().add(cookingStat);
            }

            //Woodcutting
            if (achievementModel.getRequiredWoodcutting() > characterProgressModel.getWoodcuttingExp() && achievementModel.getRequiredWoodcutting() != 1) {
                calculatedachievement.setAvailable(false);
                Stat woodcuttingStat = new Stat();
                woodcuttingStat.setStatName("Woodcutting");
                woodcuttingStat.setExperience(achievementModel.getRequiredWoodcutting());
                woodcuttingStat.setHighEnough(false);
                calculatedachievement.getStatList().add(woodcuttingStat);
            } else if (achievementModel.getRequiredWoodcutting() < characterProgressModel.getWoodcuttingExp() && achievementModel.getRequiredWoodcutting() != 1) {
                Stat woodcuttingStat = new Stat();
                woodcuttingStat.setStatName("Woodcutting");
                woodcuttingStat.setExperience(achievementModel.getRequiredWoodcutting());
                woodcuttingStat.setHighEnough(true);
                calculatedachievement.getStatList().add(woodcuttingStat);
            }

            //fletching
            if (achievementModel.getRequiredFletching() > characterProgressModel.getFletchingExp() && achievementModel.getRequiredFletching() != 1) {
                calculatedachievement.setAvailable(false);
                Stat fletchingStat = new Stat();
                fletchingStat.setStatName("Fletching");
                fletchingStat.setExperience(achievementModel.getRequiredFletching());
                fletchingStat.setHighEnough(false);
                calculatedachievement.getStatList().add(fletchingStat);
            } else if (achievementModel.getRequiredFletching() < characterProgressModel.getFletchingExp() && achievementModel.getRequiredFletching() != 1) {
                Stat fletchingStat = new Stat();
                fletchingStat.setStatName("Fletching");
                fletchingStat.setExperience(achievementModel.getRequiredFletching());
                fletchingStat.setHighEnough(true);
                calculatedachievement.getStatList().add(fletchingStat);
            }

            //Fishing
            if (achievementModel.getRequiredFishing() > characterProgressModel.getFishingExp() && achievementModel.getRequiredFishing() != 1) {
                calculatedachievement.setAvailable(false);
                Stat FishingStat = new Stat();
                FishingStat.setStatName("Fishing");
                FishingStat.setExperience(achievementModel.getRequiredFishing());
                FishingStat.setHighEnough(false);
                calculatedachievement.getStatList().add(FishingStat);
            } else if (achievementModel.getRequiredFishing() < characterProgressModel.getFishingExp() && achievementModel.getRequiredFishing() != 1) {
                Stat FishingStat = new Stat();
                FishingStat.setStatName("Fishing");
                FishingStat.setExperience(achievementModel.getRequiredFishing());
                FishingStat.setHighEnough(true);
                calculatedachievement.getStatList().add(FishingStat);
            }

            //Firemaking
            if (achievementModel.getRequiredFiremaking() > characterProgressModel.getFiremakingExp() && achievementModel.getRequiredFiremaking() != 1) {
                calculatedachievement.setAvailable(false);
                Stat FiremakingStat = new Stat();
                FiremakingStat.setStatName("Firemaking");
                FiremakingStat.setExperience(achievementModel.getRequiredFiremaking());
                FiremakingStat.setHighEnough(false);
                calculatedachievement.getStatList().add(FiremakingStat);
            } else if (achievementModel.getRequiredFiremaking() < characterProgressModel.getFiremakingExp() && achievementModel.getRequiredFiremaking() != 1) {
                Stat FiremakingStat = new Stat();
                FiremakingStat.setStatName("Firemaking");
                FiremakingStat.setExperience(achievementModel.getRequiredFiremaking());
                FiremakingStat.setHighEnough(true);
                calculatedachievement.getStatList().add(FiremakingStat);
            }

            //Crafting
            if (achievementModel.getRequiredCrafting() > characterProgressModel.getCraftingExp() && achievementModel.getRequiredCrafting() != 1) {
                calculatedachievement.setAvailable(false);
                Stat CraftingStat = new Stat();
                CraftingStat.setStatName("Crafting");
                CraftingStat.setExperience(achievementModel.getRequiredCrafting());
                CraftingStat.setHighEnough(false);
                calculatedachievement.getStatList().add(CraftingStat);
            } else if (achievementModel.getRequiredCrafting() < characterProgressModel.getCraftingExp() && achievementModel.getRequiredCrafting() != 1) {
                Stat CraftingStat = new Stat();
                CraftingStat.setStatName("Crafting");
                CraftingStat.setExperience(achievementModel.getRequiredCrafting());
                CraftingStat.setHighEnough(true);
                calculatedachievement.getStatList().add(CraftingStat);
            }

            //Smithing
            if (achievementModel.getRequiredSmithing() > characterProgressModel.getSmithingExp() && achievementModel.getRequiredSmithing() != 1) {
                calculatedachievement.setAvailable(false);
                Stat SmithingStat = new Stat();
                SmithingStat.setStatName("Smithing");
                SmithingStat.setExperience(achievementModel.getRequiredSmithing());
                SmithingStat.setHighEnough(false);
                calculatedachievement.getStatList().add(SmithingStat);
            } else if (achievementModel.getRequiredSmithing() < characterProgressModel.getSmithingExp() && achievementModel.getRequiredSmithing() != 1) {
                Stat SmithingStat = new Stat();
                SmithingStat.setStatName("Smithing");
                SmithingStat.setExperience(achievementModel.getRequiredSmithing());
                SmithingStat.setHighEnough(true);
                calculatedachievement.getStatList().add(SmithingStat);
            }

            //Mining
            if (achievementModel.getRequiredMining() > characterProgressModel.getMiningExp() && achievementModel.getRequiredMining() != 1) {
                calculatedachievement.setAvailable(false);
                Stat MiningStat = new Stat();
                MiningStat.setStatName("Mining");
                MiningStat.setExperience(achievementModel.getRequiredMining());
                MiningStat.setHighEnough(false);
                calculatedachievement.getStatList().add(MiningStat);
            } else if (achievementModel.getRequiredMining() < characterProgressModel.getMiningExp() && achievementModel.getRequiredMining() != 1) {
                Stat MiningStat = new Stat();
                MiningStat.setStatName("Mining");
                MiningStat.setExperience(achievementModel.getRequiredMining());
                MiningStat.setHighEnough(true);
                calculatedachievement.getStatList().add(MiningStat);
            }

            //Herblore
            if (achievementModel.getRequiredHerblore() > characterProgressModel.getHerbloreExp() && achievementModel.getRequiredHerblore() != 1) {
                calculatedachievement.setAvailable(false);
                Stat HerbloreStat = new Stat();
                HerbloreStat.setStatName("Herblore");
                HerbloreStat.setExperience(achievementModel.getRequiredHerblore());
                HerbloreStat.setHighEnough(false);
                calculatedachievement.getStatList().add(HerbloreStat);
            } else if (achievementModel.getRequiredHerblore() < characterProgressModel.getHerbloreExp() && achievementModel.getRequiredHerblore() != 1) {
                Stat HerbloreStat = new Stat();
                HerbloreStat.setStatName("Herblore");
                HerbloreStat.setExperience(achievementModel.getRequiredHerblore());
                HerbloreStat.setHighEnough(true);
                calculatedachievement.getStatList().add(HerbloreStat);
            }

            //Agility
            if (achievementModel.getRequiredAgility() > characterProgressModel.getAgilityExp() && achievementModel.getRequiredAgility() != 1) {
                calculatedachievement.setAvailable(false);
                Stat AgilityStat = new Stat();
                AgilityStat.setStatName("Agility");
                AgilityStat.setExperience(achievementModel.getRequiredAgility());
                AgilityStat.setHighEnough(false);
                calculatedachievement.getStatList().add(AgilityStat);
            } else if (achievementModel.getRequiredAgility() < characterProgressModel.getAgilityExp() && achievementModel.getRequiredAgility() != 1) {
                Stat AgilityStat = new Stat();
                AgilityStat.setStatName("Agility");
                AgilityStat.setExperience(achievementModel.getRequiredAgility());
                AgilityStat.setHighEnough(true);
                calculatedachievement.getStatList().add(AgilityStat);
            }

            //Thieving
            if (achievementModel.getRequiredThieving() > characterProgressModel.getThievingExp() && achievementModel.getRequiredThieving() != 1) {
                calculatedachievement.setAvailable(false);
                Stat ThievingStat = new Stat();
                ThievingStat.setStatName("Thieving");
                ThievingStat.setExperience(achievementModel.getRequiredThieving());
                ThievingStat.setHighEnough(false);
                calculatedachievement.getStatList().add(ThievingStat);
            } else if (achievementModel.getRequiredThieving() < characterProgressModel.getThievingExp() && achievementModel.getRequiredThieving() != 1) {
                Stat ThievingStat = new Stat();
                ThievingStat.setStatName("Thieving");
                ThievingStat.setExperience(achievementModel.getRequiredThieving());
                ThievingStat.setHighEnough(true);
                calculatedachievement.getStatList().add(ThievingStat);
            }

            //Slayer
            if (achievementModel.getRequiredSlayer() > characterProgressModel.getSlayerExp() && achievementModel.getRequiredSlayer() != 1) {
                calculatedachievement.setAvailable(false);
                Stat SlayerStat = new Stat();
                SlayerStat.setStatName("Slayer");
                SlayerStat.setExperience(achievementModel.getRequiredSlayer());
                SlayerStat.setHighEnough(false);
                calculatedachievement.getStatList().add(SlayerStat);
            } else if (achievementModel.getRequiredSlayer() < characterProgressModel.getSlayerExp() && achievementModel.getRequiredSlayer() != 1) {
                Stat SlayerStat = new Stat();
                SlayerStat.setStatName("Slayer");
                SlayerStat.setExperience(achievementModel.getRequiredSlayer());
                SlayerStat.setHighEnough(true);
                calculatedachievement.getStatList().add(SlayerStat);
            }

            //Farming
            if (achievementModel.getRequiredFarming() > characterProgressModel.getFarmingExp() && achievementModel.getRequiredFarming() != 1) {
                calculatedachievement.setAvailable(false);
                Stat FarmingStat = new Stat();
                FarmingStat.setStatName("Farming");
                FarmingStat.setExperience(achievementModel.getRequiredFarming());
                FarmingStat.setHighEnough(false);
                calculatedachievement.getStatList().add(FarmingStat);
            } else if (achievementModel.getRequiredFarming() < characterProgressModel.getFarmingExp() && achievementModel.getRequiredFarming() != 1) {
                Stat FarmingStat = new Stat();
                FarmingStat.setStatName("Farming");
                FarmingStat.setExperience(achievementModel.getRequiredFarming());
                FarmingStat.setHighEnough(true);
                calculatedachievement.getStatList().add(FarmingStat);
            }

            //Runecrafting
            if (achievementModel.getRequiredRunecrafting() > characterProgressModel.getRunecraftExp() && achievementModel.getRequiredRunecrafting() != 1) {
                calculatedachievement.setAvailable(false);
                Stat RunecraftingStat = new Stat();
                RunecraftingStat.setStatName("Runecrafting");
                RunecraftingStat.setExperience(achievementModel.getRequiredRunecrafting());
                RunecraftingStat.setHighEnough(false);
                calculatedachievement.getStatList().add(RunecraftingStat);
            } else if (achievementModel.getRequiredRunecrafting() < characterProgressModel.getRunecraftExp() && achievementModel.getRequiredRunecrafting() != 1) {
                Stat RunecraftingStat = new Stat();
                RunecraftingStat.setStatName("Runecrafting");
                RunecraftingStat.setExperience(achievementModel.getRequiredRunecrafting());
                RunecraftingStat.setHighEnough(true);
                calculatedachievement.getStatList().add(RunecraftingStat);
            }

            //Hunter
            if (achievementModel.getRequiredHunter() > characterProgressModel.getHunterExp() && achievementModel.getRequiredHunter() != 1) {
                calculatedachievement.setAvailable(false);
                Stat HunterStat = new Stat();
                HunterStat.setStatName("Hunter");
                HunterStat.setExperience(achievementModel.getRequiredHunter());
                HunterStat.setHighEnough(false);
                calculatedachievement.getStatList().add(HunterStat);
            } else if (achievementModel.getRequiredHunter() < characterProgressModel.getHunterExp() && achievementModel.getRequiredHunter() != 1) {
                Stat HunterStat = new Stat();
                HunterStat.setStatName("Hunter");
                HunterStat.setExperience(achievementModel.getRequiredHunter());
                HunterStat.setHighEnough(true);
                calculatedachievement.getStatList().add(HunterStat);
            }

            //Construction
            if (achievementModel.getRequiredConstruction() > characterProgressModel.getConstructionExp() && achievementModel.getRequiredConstruction() != 1) {
                calculatedachievement.setAvailable(false);
                Stat ConstructionStat = new Stat();
                ConstructionStat.setStatName("Construction");
                ConstructionStat.setExperience(achievementModel.getRequiredConstruction());
                ConstructionStat.setHighEnough(false);
                calculatedachievement.getStatList().add(ConstructionStat);
            } else if (achievementModel.getRequiredConstruction() < characterProgressModel.getConstructionExp() && achievementModel.getRequiredConstruction() != 1) {
                Stat ConstructionStat = new Stat();
                ConstructionStat.setStatName("Construction");
                ConstructionStat.setExperience(achievementModel.getRequiredConstruction());
                ConstructionStat.setHighEnough(true);
                calculatedachievement.getStatList().add(ConstructionStat);
            }

            achievementsToReturn.add(calculatedachievement);
        }
        return achievementsToReturn;
    }
}
