package Chars;

import Abstract.BaseHero;

public class Vector2 {
    public int x;
    public int y;

    public Vector2(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isEqual(Vector2 position){
        if (position.y == y & position.x == x) return true;
        else return false;
    }

    public float distance (BaseHero hero){
        return (float) Math.sqrt(Math.pow((this.x - hero.getPosition().x), 2) + Math.pow((this.y - hero.getPosition().y), 2));
    }
}
