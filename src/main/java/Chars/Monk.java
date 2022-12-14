package Chars;

import Abstract.BaseHero;

import java.util.ArrayList;

public class Monk extends BaseHero {

    public Monk(String teamName, ArrayList<BaseHero> team, int x, int y, int amount) {
        super("Monk", 12, 7, 0, new int []{-4}, 30, 5, 0, true, amount, teamName, team);
        super.position = new Vector2(x, y);
    }

    public int findInjuredHero(){
        int hpLeftoverInjuredHero = 75;
        int indexInjuredHero = -1;
        for (int i = 0; i < this.team.size(); i++) {
            if (! this.team.get(i).getStatus().equals("dead")){
                int hpLeftover = ((this.team.get(i).getCurrentHealth() % this.team.get(i).getMaxHealth()));
                if ((hpLeftover < hpLeftoverInjuredHero) && (hpLeftover != 0)){
                    hpLeftoverInjuredHero = hpLeftover;
                    indexInjuredHero = i;
                }
            }
        }
        return indexInjuredHero;
    }
    public void getHeal(int damageValue, BaseHero aim){
        if (aim.getMaxHealth() + Math.abs(damageValue * this.getAmount()) >= aim.getMaxHealth()) aim.setCurrentHealth(aim.getMaxHealth());
        else aim.setCurrentHealth(aim.getCurrentHealth() + Math.abs(damageValue * this.getAmount()));
    }
    public int findDeadHero(){
        int indexDeadHero = -1;
        int costOfDeadHero = -1;
        for (int i = 0; i < this.team.size(); i++) {
            if (this.team.get(i).getStatus().equals("dead")) {
                if (this.team.get(i).getName().equals("Robber")) {
                    indexDeadHero = i;
                    costOfDeadHero = 2;
                }
                if  (((this.team.get(i).getName().equals("Sniper")) || (this.team.get(i).getName().equals("Monk"))) && (costOfDeadHero < 3) && (this.getHeroID() != this.team.get(i).getHeroID())) {
                    indexDeadHero = i;
                    costOfDeadHero = 3;
                }
            }
        }
        return indexDeadHero;
    }

    @Override
    public void step(ArrayList<BaseHero> aimTeam) {
        if (! this.getStatus().equals("dead")) {
            int indexDeadHero = findDeadHero();
            if(indexDeadHero > -1){
                team.get(indexDeadHero).setCurrentHealth(1);
                team.get(indexDeadHero).setAmount(1);
                team.get(indexDeadHero).setStatus("stand");
            }
            else{
                int indexInjuredHero = findInjuredHero();
                if (indexInjuredHero != -1)
                    getHeal(this.damage[0], this.team.get(indexInjuredHero));
                else hit(aimTeam);
            }
        }
    }
    protected int findAim(ArrayList<BaseHero> aimTeam){
        for (int i = 0; i < aimTeam.size(); i++) {
            if ((! aimTeam.get(i).getStatus().equals("dead")) && (aimTeam.get(i).getCurrentHealth() <= Math.abs(this.getDamage()[0]))) {
                return i;
                }
            }
        return -1;
    }
    public void hit(ArrayList<BaseHero> aimTeam){
        int indexAim = findAim(aimTeam);
        if (indexAim != -1){
            getHit(this.damage[0], aimTeam.get(indexAim));
        }
    }

    @Override
    public void getHit(int damageValue, BaseHero aim) {
        int stackHP = (aim.getAmount() - 1) * aim.getMaxHealth() + aim.getCurrentHealth();
        if (Math.abs(damageValue) >= stackHP){
            aim.setAmount(0);
            aim.setCurrentHealth(0);
            aim.setStatus("dead");
        }
        else {
            stackHP = stackHP - Math.abs(damageValue);
            aim.setAmount(stackHP / aim.getMaxHealth());
            if (stackHP % aim.getMaxHealth() != 0) {
                aim.setCurrentHealth(stackHP % aim.getMaxHealth());
                aim.setAmount(stackHP / aim.getMaxHealth() + 1);
            }
            else{
                aim.setCurrentHealth(aim.getMaxHealth());
            }
        }
    }
}
