import java.util.ArrayList;
import java.util.Random;

public class Team {
    public int teamSize;
    public ArrayList<BaseHero> team = new ArrayList<BaseHero>();

    public void addPeasant(int peasantAmount, String teamName){
        for (int i = 0; i < peasantAmount; i++) {
            BaseHero.heroID += 1;
            team.add(new Peasant(BaseHero.heroID, teamName));
        }
    }
    public void addPeasant(String teamName) {
        BaseHero.heroID += 1;
        team.add(new Peasant(BaseHero.heroID, teamName));
    }
    public void addCrossbowman(int crossbowmanAmount, String teamName) {
        for (int i = 0; i < crossbowmanAmount; i++) {
            BaseHero.heroID += 1;
            team.add(new Crossbowman(BaseHero.heroID, teamName));
        }
    }
    public void addMonk(int monkAmount, String teamName) {
        for (int i = 0; i < monkAmount; i++) {
            BaseHero.heroID += 1;
            team.add(new Monk(BaseHero.heroID, teamName));
        }
    }
    public void addPikeman(int pikemanAmount, String teamName) {
        for (int i = 0; i < pikemanAmount; i++) {
            BaseHero.heroID += 1;
            team.add(new Pikeman(BaseHero.heroID, teamName));
        }
    }
    public void addRobber(int robberAmount, String teamName) {
        for (int i = 0; i < robberAmount; i++) {
            BaseHero.heroID += 1;
            team.add(new Robber(BaseHero.heroID, teamName));
        }
    }
    public void addSniper(int sniperAmount, String teamName) {
        for (int i = 0; i < sniperAmount; i++) {
            BaseHero.heroID += 1;
            team.add(new Sniper(BaseHero.heroID, teamName));
        }
    }
    public void addWizard(int wizardAmount, String teamName) {
        for (int i = 0; i < wizardAmount; i++) {
            BaseHero.heroID += 1;
            team.add(new Wizard(BaseHero.heroID, teamName));
        }
    }
}

