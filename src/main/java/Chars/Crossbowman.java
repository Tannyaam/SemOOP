package Chars;

import java.util.ArrayList;

public class Crossbowman extends BaseHero{

    public Crossbowman(String teamName, ArrayList<BaseHero> team, int x, int y) {
        super("Crossbowman", 6, 3, 16, new int []{2, 3}, 10, 4, 0, false, teamName, team);
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> team) {
        if (! this.getStatus().equals("dead")) {
            for (BaseHero hero : team) {
                if (hero.getName().equals("Peasant") && hero.status.equals("stand")) {
                    this.shot++;
                    hero.setStatus("used");
                    break;
                }
            }
            if (this.shot > 0) {
                double minDistance = distance(team.get(0));
                int indexNearestHero = 0;
                for (int i = 1; i < team.size(); i++) {
                    if (minDistance > distance(team.get(i)) && (!team.get(i).status.equals("dead"))) {
                        minDistance = distance(team.get(i));
                        indexNearestHero = i;
                    }
                }
                team.get(indexNearestHero).damage(minDistance < this.getSpeed() ?
                        super.damageValue(team.get(indexNearestHero))
                        : (super.damageValue(team.get(indexNearestHero)) / 2));
                this.shot--;
            }
        }
    }
    public double distance (BaseHero hero){
        return Math.sqrt(Math.pow((this.position.x - hero.position.x), 2) + Math.pow((this.position.y - hero.position.y), 2));
    }

}
