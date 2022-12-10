package Chars;

import Abstract.BaseHero;

import java.util.ArrayList;

public class Peasant extends BaseHero {

    public Peasant(String teamName, ArrayList<BaseHero> team, int x, int y) {
        super("Peasant", 1, 1, 0, new int []{1}, 1, 3, 1, false, teamName, team);
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> team) {
        if (! this.status.equals("dead")) this.status = "stand";
    }
}
