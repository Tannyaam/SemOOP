import Abstract.BaseHero;
import Chars.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int teamSize = 10;
    public static ArrayList<BaseHero> darkTeam;
    public static ArrayList<BaseHero> lightTeam;
    public static ArrayList<BaseHero> sortedAllHeroes;
    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            ConsoleView.view();
            System.out.println("Press Enter");
            scanner.nextLine();
            for (BaseHero hero: sortedAllHeroes) {
                if(hero.getTeamName().equals("lightTeam"))
                    hero.step(darkTeam);
                else hero.step(lightTeam);
            }
        }
    }

    public static void init(){
        darkTeam = new ArrayList<BaseHero>();
        lightTeam = new ArrayList<BaseHero>();
        sortedAllHeroes = new ArrayList<BaseHero>();

        int x = 1;
        int y = 1;

        for (int i = 0; i < teamSize; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> lightTeam.add(new Peasant("lightTeam", lightTeam, x++, y, 4));
                case 1 -> lightTeam.add(new Monk("lightTeam", lightTeam, x++, y, 2));
                case 2 -> lightTeam.add(new Robber("lightTeam", lightTeam, x++, y, 2));
                case 3 -> lightTeam.add(new Sniper("lightTeam", lightTeam, x++, y, 2));
            }
        }
        x = 1;
        y = 10;
        for (int i = 0; i < teamSize; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> darkTeam.add(new Peasant("darkTeam", darkTeam, x++, y, 4));
                case 1 -> darkTeam.add(new Crossbowman("darkTeam", darkTeam, x++, y, 1));
                case 2 -> darkTeam.add(new Pikeman("darkTeam", darkTeam, x++, y, 2));
                case 3 -> darkTeam.add(new Wizard("darkTeam", darkTeam, x++, y, 2));
            }
        }
        sortedAllHeroes.addAll(lightTeam);
        sortedAllHeroes.addAll(darkTeam);
        quickSort(sortedAllHeroes, 0, 19);

    }
    public static int partition (ArrayList<BaseHero> allHeroes, int start, int end)
    {
        int marker = start;
        for (int i = start; i <= end; i++ )
        {
            if ( allHeroes.get(i).getSpeed() >= allHeroes.get(end).getSpeed() )
            {
                BaseHero temp = allHeroes.get(marker); // swap
                allHeroes.set(marker, allHeroes.get(i));
                allHeroes.set(i, temp);
                marker += 1;
            }
        }
        return marker - 1;
    }
    public static void quickSort (ArrayList<BaseHero> allHeroes, int start, int end)
    {
        if (start >= end) return;
        int pivot = partition (allHeroes, start, end);
        quickSort (allHeroes, start, pivot-1);
        quickSort (allHeroes, pivot+1, end);
    }
}
