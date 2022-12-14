package Chars;

import Abstract.BaseHero;

import java.util.ArrayList;

public class Wizard extends BaseHero {

    public Wizard(String teamName, ArrayList<BaseHero> team, int x, int y, int amount) {
        super("Wizard", 17, 12, 0, new int []{-5}, 30, 9, 0, true, amount, teamName, team);
        super.position = new Vector2(x, y);
    }
}
