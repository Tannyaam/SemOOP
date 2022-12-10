package Abstract;

import Chars.Vector2;

import java.util.ArrayList;

public abstract class Warrior extends BaseHero {
    public Warrior(String name, int attack, int protection, int shot, int[] damage, int maxHealth, int speed, int delivery, Boolean magic, String teamName, ArrayList<BaseHero> team) {
        super(name, attack, protection, shot, damage, maxHealth, speed, delivery, magic, teamName, team);
    }
    protected BaseHero findAim(ArrayList<BaseHero> team){
        float minDistance = Float.MAX_VALUE;
        int indexNearestHero = 0;
        for (int i = 0; i < team.size(); i++) {
            if (! team.get(i).getStatus().equals("dead")) {
                float distance = getPosition().distance(team.get(i));
                if (minDistance > distance) {
                    minDistance = distance;
                    indexNearestHero = i;
                }
            }
        }
        return team.get(indexNearestHero);
    }
    protected void hit(BaseHero aim){
        int damageVal;
        if (this.shot > 0) {
            if (this.getPosition().distance(aim) < this.getSpeed()) damageVal = damageValue(aim);
            else damageVal = damageValue(aim) / 2;

            damage(damageVal, aim);
            this.shot--;
        }
    }
    protected void makeStepOnMap(BaseHero aim){
        int x = this.getPosition().x;
        int y = this.getPosition().y;
        if ((y < aim.getPosition().y) && (checkPosition(x, y + 1, aim.getTeam()))) {
            y = y + 1;
            this.setPosition(x, y);
        }
        else {
            if ((y > aim.getPosition().y) && (checkPosition(x, y - 1, aim.getTeam()))) {
                y = y - 1;
                this.setPosition(x, y);
            } else {
                if ((x < aim.getPosition().x) && (checkPosition(x + 1, y, aim.getTeam()))) {
                    x = x + 1;
                    this.setPosition(x, y);
                } else {
                    if ((x > aim.getPosition().x) && (checkPosition(x - 1, y, aim.getTeam()))) {
                        x = x - 1;
                        this.setPosition(x, y);
                    }
                }
            }
        }
    }
    protected boolean checkPosition(int x, int y, ArrayList<BaseHero> aimTeam){
        Vector2 position = new Vector2(x, y);
        for (int i = 0; i < 10; i++) {
            //if (position.isEqual(aimTeam.get(i).getPosition()) || position.isEqual(this.team.get(i).getPosition())) return false;
            if (position.isEqual(this.team.get(i).getPosition())) return false;
        }
        return true;
    }
}
