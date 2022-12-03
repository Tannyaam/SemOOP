import Chars.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int teamSize = 10;
    public static ArrayList<BaseHero> darkTeam;
    public static ArrayList<BaseHero> lightTeam;
    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);
        while (true){
            ConsoleView.view();
            System.out.println("Press Enter");
            scanner.nextLine();
        }
    }

    public static void init(){
        darkTeam = new ArrayList<BaseHero>();
        lightTeam = new ArrayList<BaseHero>();

        int x = 1;
        int y = 1;

        for (int i = 0; i < teamSize; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> lightTeam.add(new Peasant("lightTeam", x++, y));
                case 1 -> lightTeam.add(new Monk("lightTeam", x++, y));
                case 2 -> lightTeam.add(new Robber("lightTeam", x++, y));
                case 3 -> lightTeam.add(new Sniper("lightTeam", x++, y));
            }
        }

        x = 1;
        y = 10;

        for (int i = 0; i < teamSize; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> darkTeam.add(new Peasant("darkTeam", x++, y));
                case 1 -> darkTeam.add(new Crossbowman("darkTeam", x++, y));
                case 2 -> darkTeam.add(new Pikeman("darkTeam", x++, y));
                case 3 -> darkTeam.add(new Wizard("darkTeam", x++, y));
            }
        }
    }
}
