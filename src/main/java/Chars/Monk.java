package Chars;

import Abstract.BaseHero;

import java.util.ArrayList;

public class Monk extends BaseHero {

    public Monk(String teamName, ArrayList<BaseHero> team, int x, int y) {
        super("Monk", 12, 7, 0, new int []{-4}, 30, 5, 0, true, teamName, team);
        super.position = new Vector2(x, y);
    }

    public int findInjuredHero(ArrayList<BaseHero> team){
        int hpLeftoverInjuredHero = team.get(0).getCurrentHealth() / team.get(0).getMaxHealth();
        int indexInjuredHero = 0;
        for (int i = 1; i < team.size(); i++) {
            if (! team.get(i).getStatus().equals("dead")){
                int hpLeftover = team.get(i).getCurrentHealth() / team.get(i).getMaxHealth();
                if (hpLeftover < hpLeftoverInjuredHero){
                    hpLeftoverInjuredHero = hpLeftover;
                    indexInjuredHero = i;
                }
            }
        }
        return indexInjuredHero;
    }
    @Override
    public void step(ArrayList<BaseHero> team) {
        if (! this.getStatus().equals("dead")) {
            int indexInjuredHero = findInjuredHero(this.team);
            this.team.get(indexInjuredHero).damage(this.getDamage()[0], this.team.get(indexInjuredHero));
        }
    }
}
