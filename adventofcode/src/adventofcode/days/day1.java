/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adventofcode.days;

import adventofcode.Utils.Input;
import java.io.BufferedReader;
import java.io.FileReader;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author qp
 */
public class day1 {

    private static ArrayList<Integer> firstList = new ArrayList<>();
    private static ArrayList<Integer> secondList = new ArrayList<>();

    public static void readandSort() {
        String filepath = "./src/adventofcode/files/dayoneInput";
        try (BufferedReader bR = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = bR.readLine()) != null) {
                ArrayList<Integer> temp = Input.extractNumbers(line);
                firstList.add(temp.get(0));
                secondList.add(temp.get(1));

                /* Alternative to above
                String[] templine = line.split("\\s+");
                firstList.add(Integer.valueOf(templine[0]));
                secondList.add(Integer.valueOf(templine[1]));
                 */
            }
        } catch (Exception e) {
            //Find out why there are a bunch of errors I guess?
        }
        Collections.sort(firstList);
        Collections.sort(secondList);
    }

    public static void runFirst() {
        int result = 0;
        int i = 0;
        for (Integer number : firstList) {
            int abs = abs(number - secondList.get(i));
            result += abs;
            i++;
        }
        System.out.println(result);
    }

    public static void runSecond() {
        int result = 0;
        for (Integer first : firstList) {
            int simScore = 0;
            for (Integer second : secondList) {
                if (first < second) {
                    result += first * simScore;
                    break;
                } else if (first.equals(second)) {
                    //System.out.println(first + "  " + second);
                    //System.out.println(secondList.indexOf(second));
                    simScore++;
                }
            }
        }
        System.out.println(result);
    }
}
