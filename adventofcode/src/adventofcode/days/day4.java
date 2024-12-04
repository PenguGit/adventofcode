/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adventofcode.days;

import adventofcode.Utils.Input;
import static java.lang.Math.abs;
import java.util.ArrayList;

/**
 *
 * @author qp
 */
public class day4 {

    private static final ArrayList<String> lines = Input.readFile("testfile");
    private static int result = 0;
    public static void runFirst() {
        for (int row = 0; row < lines.size(); row++) {
            String line = lines.get(row);
            for (int letter = 0; letter < line.length(); letter++) {
                if (line.charAt(letter) == 'X') {
                    findXmas('X', row ,letter);
                }
            }
        }
    }

    private static void findXmas(char curr, int row, int letter) {
        switch (curr) {
            case 'X' -> {
                for (int r = -1; r < 2; r ++) {
                    if (row == 0 && r == -1) {
                        System.out.println("Hi");
                        r++;
                    }
                    for(int c = -1; c < 2; c++) {
                        if(letter == 0 && c == -1) {
                            System.out.println("Ho");
                            c++;
                        }
                        char checkLetter = lines.get(row + r).charAt(letter + c) ;
                        System.out.println(checkLetter);
                    }
                }
            }
            case 'M' -> {
                
            }
            case 'A' -> {
                
            }
            case 'S' -> {
                result++;
            }
            default -> throw new AssertionError();
        }
    }
}
