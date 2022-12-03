package Chars;

import java.util.ArrayList;

public class Monk extends BaseHero{

    public Monk(String teamName, int x, int y) {
        super("Monk", 12, 7, 0, new int []{-4}, 30, 5, 0, true, teamName);
        super.position = new Vector2(x, y);
    }

    public int findInjuredHero(ArrayList<BaseHero> team){
        double hpLeftoverInjuredHero = (double) team.get(0).getCurrentHealth() / (double) team.get(0).getMaxHealth();
        int indexInjuredHero = 0;
        for (int i = 1; i < team.size(); i++) {
            double hpLeftover = (double) team.get(i).getCurrentHealth() / (double) team.get(i).getMaxHealth();
            if (hpLeftover < hpLeftoverInjuredHero){
                hpLeftoverInjuredHero = hpLeftover;
                indexInjuredHero = i;
            }
        }
        return indexInjuredHero;
    }
    @Override
    public void Step(ArrayList<BaseHero> team) {
        int indexInjuredHero = findInjuredHero(team);
        int currentHPInjuredHero = team.get(indexInjuredHero).getCurrentHealth();
        int maxHPInjuredHero = team.get(indexInjuredHero).getMaxHealth();
        for (int i = 0; i < Math.abs(getDamage()[0]); i++) {
            if (currentHPInjuredHero + 1 < maxHPInjuredHero){
                currentHPInjuredHero += 1;
            }
        }
        team.get(indexInjuredHero).setCurrentHealth(currentHPInjuredHero);
    }

}
