import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {

        ArrayList<BaseHero> darkTeam = new ArrayList<BaseHero>();
        ArrayList<BaseHero> lightTeam = new ArrayList<BaseHero>();

        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int charSelection = rand.nextInt(0, 4);
            switch (charSelection) {
                case 0 -> darkTeam.add(new Peasant(BaseHero.heroID, "darkTeam"));
                case 1 -> darkTeam.add(new Crossbowman(BaseHero.heroID, "darkTeam"));
                case 2 -> darkTeam.add(new Pikeman(BaseHero.heroID, "darkTeam"));
                case 3 -> darkTeam.add(new Wizard(BaseHero.heroID, "darkTeam"));
            }
        }

        for (int i = 0; i < 5; i++) {
            int charSelection = rand.nextInt(0, 4);
            switch (charSelection) {
                case 0 -> lightTeam.add(new Peasant(BaseHero.heroID, "lightTeam"));
                case 1 -> lightTeam.add(new Monk(BaseHero.heroID, "lightTeam"));
                case 2 -> lightTeam.add(new Robber(BaseHero.heroID, "lightTeam"));
                case 3 -> lightTeam.add(new Sniper(BaseHero.heroID, "lightTeam"));
            }
            BaseHero.heroID += 1;
        }

        for (BaseHero hero: darkTeam) {
            System.out.println(hero.getInfo());
        }

        darkTeam.get(0).setCurrentHealth(5);

        System.out.println("______________________________________________");

        for (BaseHero hero: darkTeam) {
            System.out.println(hero.getInfo());
        }

        System.out.println("______________________________________________");

        new Monk(0, "0").Step(darkTeam);

        for (BaseHero hero: darkTeam) {
            System.out.println(hero.getInfo());
        }
    }
}
