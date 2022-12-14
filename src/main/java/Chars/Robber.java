package Chars;

import Abstract.BaseHero;

import java.util.ArrayList;

public class Robber extends BaseHero {

    public Robber(String teamName, ArrayList<BaseHero> team, int x, int y, int amount) {
        super("Robber", 8, 3, 0, new int []{2, 4}, 10, 6, 0, false, amount, teamName, team);
        super.position = new Vector2(x, y);
    }
}
