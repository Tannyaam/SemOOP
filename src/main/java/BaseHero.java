import java.util.ArrayList;
import java.util.Arrays;

public abstract class BaseHero implements BaseInterface{
    protected static int heroID = 1;
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

    public BaseHero(int heroID, int attack, int protection, int shot, int[] damage, int maxHealth, int speed, int delivery, Boolean magic, String teamName) {
        this.heroID = heroID;
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
    public void Step(ArrayList<BaseHero> team){

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

}
