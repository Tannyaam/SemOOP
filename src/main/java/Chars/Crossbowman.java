package Chars;

import Abstract.BaseHero;
import Abstract.Warrior;

import java.util.ArrayList;

public class Crossbowman extends Warrior {

    public Crossbowman(String teamName, ArrayList<BaseHero> team, int x, int y) {
        super("Crossbowman", 6, 3, 16, new int []{2, 3}, 10, 4, 0, false, teamName, team);
        super.position = new Vector2(x, y);
    }

    public void getArrows(ArrayList<BaseHero> team) {
        if (! this.getStatus().equals("dead")) {
            for (BaseHero hero : team) {
                if (hero.getName().equals("Peasant") && hero.getStatus().equals("stand")) {
                    this.shot++;
                    hero.setStatus("used");
                    break;
                }
            }
        }
    }
    @Override
    public void step(ArrayList<BaseHero> team) {
        getArrows(this.team);
        BaseHero aim = findAim(team);
        if ((int) getPosition().distance(aim) <= 1) hit(aim);
        else makeStepOnMap(aim);
    }
}
