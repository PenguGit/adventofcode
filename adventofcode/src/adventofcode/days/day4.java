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
                    System.out.println("Reading");
                    findXmas('X', row, letter);
                }
            }
        }
    }

    private static void findXmas(char curr, int row, int letter) {
        switch (curr) {
            case 'X' -> {
                System.out.println("X");
                checkXmas('M', row, letter);
            }
            case 'M' -> {
                System.out.println("M");
                checkXmas('A', row, letter);
            }
            case 'A' -> {
                System.out.println("A");
                checkXmas('S' , row, letter);
            }
            case 'S' -> {
                result++;
            }
            default ->
                throw new AssertionError();
        }
    }
    
    
    private static void checkXmas(char curr, int row, int letter) {
        for (int r = row - 1; r <= row + 1; r++) {
                    if (r < 0) {
                        r++;
                    } else if (r == lines.size()) {
                        break;
                    }
                    for (int c = letter - 1; c <= letter + 1; c++) {
                        if (c < 0) {
                            c++;
                        } else if (c == lines.size()) {
                            break;
                        }
                        System.out.println(r + " " + c);
                        char checkLetter = lines.get(r).charAt(c);
                        if (checkLetter == curr) {
                            findXmas(curr, row+r, letter+c);
                            return;
                        }
                    }
                }
                System.out.println("Done");
    }
}
