package viewModels;

import java.util.ArrayList;
import java.util.List;

public class CalculatedAchievements {

    private String name;
    private boolean available;
    private List<Stat> statList;

    public CalculatedAchievements(String name, boolean available, List<Stat> statList) {
        this.name = name;
        this.available = available;
        this.statList = statList;
    }

    public CalculatedAchievements() {
        this.statList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Stat> getStatList() {
        return statList;
    }

    public void setStatList(List<Stat> statList) {
        this.statList = statList;
    }
}
