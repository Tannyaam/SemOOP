package Abstract;

import Chars.Vector2;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class BaseHero implements BaseInterface {
    public static int IDcounter;
    private int heroID;
    protected String name;
    protected int attack;
    protected int protection;
    protected int shot;
    protected int[] damage;
    protected int maxHealth;
    protected int currentHealth;
    protected int speed;
    protected int delivery;
    protected Boolean magic;
    protected String teamName;
    protected Vector2 position;
    protected ArrayList<BaseHero> team;
    protected String status;

    public BaseHero(String name, int attack, int protection, int shot, int[] damage, int maxHealth, int speed, int delivery, Boolean magic, String teamName, ArrayList<BaseHero> team) {
        heroID = IDcounter++;
        this.name = name;
        this.attack = attack;
        this.protection = protection;
        this.shot = shot;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
        this.teamName = teamName;
        this.team = team;
        this.status = "stand";
    }
    @Override
    public String toString() {
        return  "heroID = " + heroID +
                ", attack = " + attack +
                ", protection = " + protection + 
                ", shot = " + shot + 
                ", damage = " + Arrays.toString(damage) +
                ", maxhealth = " + maxHealth +
                ", currenthealth = " + currentHealth +
                ", speed = " + speed + 
                ", delivery = " + delivery + 
                ", magic = " + magic +
                ", team = " + teamName;
    }
    @Override
    public String getInfo(){
        return  "heroID = " + heroID +
                ", name = " + name +
                ", currenthealth = " + currentHealth +
                ", team = " + teamName;
    }
    @Override
    public void step(ArrayList<BaseHero> team){
    }
    public int getCurrentHealth(){
        return currentHealth;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public int[] getDamage(){
        return damage;
    }
    public void setCurrentHealth(int health){
        this.currentHealth = health;
    }
    public Vector2 getPosition(){return position;}
    public String getName(){return name;}
    public String getTeamName() {return teamName;}
    public int getHeroID() {return heroID;}
    public int getShot() {return shot;}

    protected void setShot(int shot) {this.shot = shot;}
    public void setStatus(String status) {this.status = status;}

    protected int getProtection() {return protection;}
    protected int damageValue(BaseHero aim){
        int value = 0;
        if (this.attack - aim.getProtection() == 0) value = (this.getDamage()[0] + this.getDamage()[1])/2;
        if (this.attack - aim.getProtection() > 0) value = this.getDamage()[1];
        if (this.attack - aim.getProtection() < 0) value = this.getDamage()[0];
        return value;
    }
    public void damage(int damage, BaseHero aim){
        int aimCurrentHealth = aim.getCurrentHealth() - damage;
        if(aimCurrentHealth > 0){
            if (aimCurrentHealth > aim.maxHealth) aim.setCurrentHealth(aim.maxHealth);
            else aim.setCurrentHealth(aimCurrentHealth);
        }
        else{
            aim.status = "dead";
            aim.setCurrentHealth(0);
        }
    }

    protected int getSpeed() {return speed;}

    public String getStatus() {return status;}
    public void setPosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;
    }
    public ArrayList<BaseHero> getTeam() {return team;}
}
