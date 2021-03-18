/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author EQUIPO
 */
public class Utils {

    public static String loadMapAsString(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line).append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static String loadPokemonInfoAsString(int id, String path, String[] ignoredWords) {
        int builderWritings = 0;
        int lineNumber = 0;
        String lineId = ("[" + (id + 1) + "]");
        String lineId2 = ("[" + (id + 2) + "]");
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.equals(lineId)) {
                    while (!line.equals(lineId2)) {
                        line = br.readLine();
                        lineNumber++;
                        if (line != null) {
                            for (String ignoredWord : ignoredWords) {
                                int index = line.indexOf(ignoredWord);
                                if (index != -1) {
                                    int subStart = index + ignoredWord.length();
                                    int subEnd = line.length();
                                    line = line.substring(subStart, subEnd);
                                    builder.append(line).append("\n");
                                    builderWritings++;
                                }
                            }
                        } else break;
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static float parseFloat(String number) {
        try {
            return Float.parseFloat(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static int Random(int bounds, int startNumber) {
        Random rand = new Random();
        int number = rand.nextInt(bounds) + startNumber;
//        System.out.println(number);
        return number;
    }

}
