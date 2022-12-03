import Chars.BaseHero;
import Chars.Vector2;

import java.util.ArrayList;
import java.util.Collections;

public class ConsoleView {
    public static int step = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

    public static void view() {
        String info = "";
        if (step++ == 0) System.out.println(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        else System.out.println(AnsiColors.ANSI_RED + "Step: " + step + AnsiColors.ANSI_RESET);
        System.out.print(ConsoleView.top10);
        System.out.println("Name" + String.join("",Collections.nCopies(maxNameLen - "Name".length(), " "))
                + "HeroID" + String.join("",Collections.nCopies(maxHeroIDLen - "HeroID".length(), " "))
                + "CurrentHealth" + String.join("",Collections.nCopies(maxCurrentHealthLen - "CurrentHealth".length(), " "))
                + "TeamName" + String.join("", Collections.nCopies(maxTeamNameLen - "TeamName".length(), " ")));
        for (int i = 1; i <= Main.teamSize - 1; i++) {
            info = "";
            for (int j = 1; j <= Main.teamSize; j++) {
                System.out.print(getChar(new Vector2(i, j)));
                info += heroInfo(new Vector2(i, j)) + "   ";
            }
            System.out.print("|");
            System.out.println(info);
            System.out.println(ConsoleView.mid10);
        }
        for (int j = 1; j <= Main.teamSize; j++) {
            System.out.print(getChar(new Vector2(10, j)));
        }
        System.out.print("|");
        System.out.println(info);
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(Vector2 position) {
        String str = "| ";
        for (int i = 0; i < Main.teamSize; i++) {
            if (Main.darkTeam.get(i).getPosition().isEqual(position))
                str = "|" + AnsiColors.ANSI_GREEN + Main.darkTeam.get(i).getName().charAt(0) + AnsiColors.ANSI_RESET;
            if (Main.lightTeam.get(i).getPosition().isEqual(position))
                str = "|" + AnsiColors.ANSI_BLUE + Main.lightTeam.get(i).getName().charAt(0) + AnsiColors.ANSI_RESET;
        }
        return str;
    }

    private static String heroInfo(Vector2 position) {
        String str = "";
        for (int i = 0; i < Main.teamSize; i++) {
            if (Main.darkTeam.get(i).getPosition().isEqual(position))
                str = Main.darkTeam.get(i).getName() + String.join("",Collections.nCopies(maxNameLen - Main.darkTeam.get(i).getName().length(), " "))
                        + Main.darkTeam.get(i).getHeroID() + String.join("",Collections.nCopies(maxHeroIDLen - String.valueOf(Main.darkTeam.get(i).getHeroID()).length(), " "))
                        + Main.darkTeam.get(i).getCurrentHealth() + String.join("",Collections.nCopies(maxCurrentHealthLen - String.valueOf(Main.darkTeam.get(i).getCurrentHealth()).length(), " "))
                        + Main.darkTeam.get(i).getTeamName() + String.join("", Collections.nCopies(maxTeamNameLen - Main.darkTeam.get(i).getTeamName().length(), " "));
            if (Main.lightTeam.get(i).getPosition().isEqual(position))
                str = Main.lightTeam.get(i).getName() + String.join("",Collections.nCopies(maxNameLen - Main.lightTeam.get(i).getName().length(), " "))
                        + Main.lightTeam.get(i).getHeroID() + String.join("",Collections.nCopies(maxHeroIDLen - String.valueOf(Main.lightTeam.get(i).getHeroID()).length(), " "))
                        + Main.lightTeam.get(i).getCurrentHealth() + String.join("",Collections.nCopies(maxCurrentHealthLen - String.valueOf(Main.lightTeam.get(i).getCurrentHealth()).length(), " "))
                        + Main.lightTeam.get(i).getTeamName() + String.join("", Collections.nCopies(maxTeamNameLen - Main.lightTeam.get(i).getTeamName().length(), " "));
        }
        return str;
    }

    private static final int maxNameLen = maxNameLen(Main.darkTeam, Main.lightTeam) + 1;
    private static final int maxTeamNameLen = maxTeamNameLen(Main.darkTeam, Main.lightTeam) + 1;
    private static final int maxHeroIDLen = maxHeroIDLen(Main.darkTeam, Main.lightTeam) + 1;
    private static final int maxCurrentHealthLen = maxCurrentHealthLen(Main.darkTeam, Main.lightTeam) + 1;
    public static int maxNameLen(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2){
        int maxNameLen = team1.get(0).getName().length();
        for (int i = 1; i < team1.size(); i++) {
            if (team1.get(i).getName().length() > maxNameLen){
                maxNameLen = team1.get(i).getName().length();
            }
        }
        for (int i = 1; i < team2.size(); i++) {
            if (team2.get(i).getName().length() > maxNameLen){
                maxNameLen = team2.get(i).getName().length();
            }
        }
        return maxNameLen;
    }

    public static int maxTeamNameLen(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2){
        int maxTeamNameLen = team1.get(0).getTeamName().length();
            if (team2.get(0).getTeamName().length() > maxNameLen){
                maxTeamNameLen = team2.get(0).getTeamName().length();
            }
        return maxTeamNameLen;
    }

    public static int maxHeroIDLen(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2){
        String fieldName = "HeroID";
        int maxHeroIDLen = fieldName.length();
        for (int i = 0; i < team1.size(); i++) {
            if (String.valueOf(team1.get(i).getHeroID()).length() > maxHeroIDLen){
                maxHeroIDLen = String.valueOf(team1.get(i).getHeroID()).length();
            }
        }
        for (int i = 0; i < team2.size(); i++) {
            if (String.valueOf(team2.get(i).getHeroID()).length() > maxHeroIDLen){
                maxHeroIDLen = String.valueOf(team2.get(i).getHeroID()).length();
            }
        }
        return maxHeroIDLen;
    }

    public static int maxCurrentHealthLen(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2){
        String fieldName = "CurrentHealth";
        int maxCurrentHealthLen = fieldName.length();
        for (int i = 0; i < team1.size(); i++) {
            if (String.valueOf(team1.get(i).getCurrentHealth()).length() > maxCurrentHealthLen){
                maxCurrentHealthLen = String.valueOf(team1.get(i).getCurrentHealth()).length();
            }
        }
        for (int i = 0; i < team2.size(); i++) {
            if (String.valueOf(team2.get(i).getCurrentHealth()).length() > maxCurrentHealthLen){
                maxCurrentHealthLen = String.valueOf(team2.get(i).getCurrentHealth()).length();
            }
        }
        return maxCurrentHealthLen;
    }

    /*private static void infoView(){
        for (int i = 0; i < Main.teamSize; i++) {
            for (int j = 0; j < Main.teamSize; j++) {
                if(Main.lightTeam.get(i).getPosition().isEqual(Vector2(i, j)))
            }
        }
    }*/
}