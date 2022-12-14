package Abstract;

import Chars.Vector2;

import java.util.ArrayList;

public abstract class Warrior extends BaseHero {
    public Warrior(String name, int attack, int protection, int shot, int[] damage, int maxHealth, int speed, int delivery, Boolean magic, int amount, String teamName, ArrayList<BaseHero> team) {
        super(name, attack, protection, shot, damage, maxHealth, speed, delivery, magic, amount, teamName, team);
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
            if (this.getPosition().distance(aim) < this.getSpeed()) damageVal = this.damageValue(aim);
            else damageVal = this.damageValue(aim) / 2;
            this.getHit(damageVal, aim);
            this.shot--;
        }
    }
    protected void makeStepOnMap(BaseHero aim){
        int x = this.getPosition().x;
        int y = this.getPosition().y;
        if ((y < aim.getPosition().y) && (checkPosition(x, y + 1))) {
            y = y + 1;
            this.setPosition(x, y);
        }
        else {
            if ((y > aim.getPosition().y) && (checkPosition(x, y - 1))) {
                y = y - 1;
                this.setPosition(x, y);
            }
            else {
                if ((x < aim.getPosition().x) && (checkPosition(x + 1, y))) {
                    x = x + 1;
                    this.setPosition(x, y);
                }
                else {
                    if ((x > aim.getPosition().x) && (checkPosition(x - 1, y))) {
                        x = x - 1;
                        this.setPosition(x, y);
                    }
                }
            }
        }
    }
    protected boolean checkPosition(int x, int y){
        Vector2 position = new Vector2(x, y);
        for (int i = 0; i < 10; i++) {
            if (position.isEqual(this.team.get(i).getPosition())) return false;
        }
        return true;
    }
    @Override
    public void getHit(int damageValue, BaseHero aim){
        int stackHP = (aim.amount - 1) * aim.maxHealth + aim.currentHealth;
        if (damageValue >= stackHP){
            aim.amount = 0;
            aim.currentHealth = 0;
            aim.status = "dead";
        }
        else {
            stackHP = stackHP - damageValue;
            aim.amount = stackHP / aim.maxHealth;
            if (stackHP % aim.maxHealth != 0) {
                aim.currentHealth = stackHP % aim.maxHealth;
                aim.amount = stackHP / aim.maxHealth + 1;
            }
            else{
                aim.currentHealth = aim.maxHealth;
            }
        }
    }
}
