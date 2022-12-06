import Chars.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int teamSize = 10;
    public static ArrayList<BaseHero> darkTeam;
    public static ArrayList<BaseHero> lightTeam;
    public static ArrayList<BaseHero> warriorsDT;
    public static ArrayList<BaseHero> magiciansDT;
    public static ArrayList<BaseHero> peasantsDT;
    public static ArrayList<BaseHero> warriorsWT;
    public static ArrayList<BaseHero> magiciansWT;
    public static ArrayList<BaseHero> peasantsWT;
    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);
        while (true){
            ConsoleView.view();
            System.out.println("Press Enter");
            scanner.nextLine();
            warriorsDT.forEach(n -> n.step(lightTeam));
            warriorsWT.forEach(n -> n.step(darkTeam));
            magiciansDT.forEach(n -> n.step(darkTeam));
            magiciansWT.forEach(n -> n.step(lightTeam));
            peasantsDT.forEach(n -> n.step(darkTeam));
            peasantsWT.forEach(n -> n.step(lightTeam));
        }
    }

    public static void init(){
        darkTeam = new ArrayList<BaseHero>();
        lightTeam = new ArrayList<BaseHero>();
        peasantsDT = new ArrayList<BaseHero>();
        peasantsWT = new ArrayList<BaseHero>();
        magiciansDT = new ArrayList<BaseHero>();
        magiciansWT = new ArrayList<BaseHero>();
        warriorsDT = new ArrayList<BaseHero>();
        warriorsWT = new ArrayList<BaseHero>();

        int x = 1;
        int y = 1;

        for (int i = 0; i < teamSize; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> lightTeam.add(new Peasant("lightTeam", lightTeam, x++, y));
                case 1 -> lightTeam.add(new Monk("lightTeam", lightTeam, x++, y));
                case 2 -> lightTeam.add(new Robber("lightTeam", lightTeam, x++, y));
                case 3 -> lightTeam.add(new Sniper("lightTeam", lightTeam, x++, y));
            }
        }

        x = 1;
        y = 10;

        for (int i = 0; i < teamSize; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> darkTeam.add(new Peasant("darkTeam", darkTeam, x++, y));
                case 1 -> darkTeam.add(new Crossbowman("darkTeam", darkTeam, x++, y));
                case 2 -> darkTeam.add(new Pikeman("darkTeam", darkTeam, x++, y));
                case 3 -> darkTeam.add(new Wizard("darkTeam", darkTeam, x++, y));
            }
        }
        distributionByType(darkTeam, peasantsDT, magiciansDT, warriorsDT);
        distributionByType(lightTeam, peasantsWT, magiciansWT, warriorsWT);
    }
    public static void distributionByType(ArrayList<BaseHero> team, ArrayList<BaseHero> groupOfPeasants, ArrayList<BaseHero> groupOfMagicians, ArrayList<BaseHero> groupOfWarriors){
        for (BaseHero hero: team) {
            if (hero.getName().equals("Peasant")) groupOfPeasants.add(hero);
            else {
                if (hero.getName().equals("Monk")) groupOfMagicians.add(hero);
                else groupOfWarriors.add(hero);
            }
        }
    }
}
