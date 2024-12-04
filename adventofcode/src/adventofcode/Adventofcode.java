/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adventofcode;

import adventofcode.days.day1;
import adventofcode.days.day2;
import adventofcode.days.day3;
import adventofcode.days.day4;

/**
 *
 * @author qp
 */
public class Adventofcode {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int day = 4;
        switch (day) {
            case 1 -> {
                System.out.println("---------------");
                System.out.println("Day 1 Output: ");
                System.out.println("---------------");
                day1.readandSort();
                System.out.println("First Half: ");
                day1.runFirst();
                System.out.println("---------------");
                System.out.println("Second Half: ");
                day1.runSecond();
            }
            case 2 -> {
                System.out.println("---------------");
                System.out.println("Day 2 Output");
                System.out.println("---------------");
                System.out.println("First Half: ");
                day2.runFirst();
                System.out.println("---------------");
                System.out.println("Second Half: ");
                day2.runSecond();
            }
            case 3 -> {
                System.out.println("---------------");
                System.out.println("Day 2 Output");
                System.out.println("---------------");
                System.out.println("First Half: ");
                day3.runFirst();
                System.out.println("---------------");
                System.out.println("Second Half: ");
                day3.runSecond();
            }
            case 4 -> {
                System.out.println("---------------");
                System.out.println("Day 2 Output");
                System.out.println("---------------");
                System.out.println("First Half: ");
                day4.runFirst();
                System.out.println("---------------");
                System.out.println("Second Half: ");
                //day4.runSecond();
            }
            default -> throw new AssertionError();
        }
    }
}
