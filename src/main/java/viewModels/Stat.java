package viewModels;

public class Stat {

    private String statName;
    private int experience;
    private boolean highEnough;

    public Stat() {
        highEnough = true;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    public boolean isHighEnough() {
        return highEnough;
    }

    public void setHighEnough(boolean highEnough) {
        this.highEnough = highEnough;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
