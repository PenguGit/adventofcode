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

/**
 *
 * @author qp
 */
public class day2 {
    
        //The engineers are trying to figure out which reports are safe. 
        //The Red-Nosed reactor safety systems can only tolerate levels that are 
        //either gradually increasing or gradually decreasing. So, a report only 
        //counts as safe if both of the following are true:
        //The levels are either all increasing or all decreasing.
        //Any two adjacent levels differ by at least one and at most three.

    public static void runFirst() {
        String filepath = "./src/adventofcode/files/daytwoInput";
        try (BufferedReader bR = new BufferedReader(new FileReader(filepath))) {
            String line;
            int safeReports = 0;
            int unsafeReports = 0;
            while ((line = bR.readLine()) != null) {
                ArrayList<Integer> temp = Input.extractNumbers(line);
                //Check if the report is safe
                if (isSafe(temp)) {
                    safeReports++;
                } else {
                    unsafeReports++;
                }
            } //Ende While Loop zur Datei auslesen

            System.out.println("Safe Reports: " + safeReports);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Now, the same rules apply as before, except if removing a single level 
    //from an unsafe report would make it safe, the report instead counts as safe.
    
    public static void runSecond() {
        String filepath = "./src/adventofcode/files/daytwoInput";
        try (BufferedReader bR = new BufferedReader(new FileReader(filepath))) {
            String line;
            int safeReports = 0;
            int unsafeReports = 0;
            while ((line = bR.readLine()) != null) {
                //Extract all Numbers per line into an Array
                ArrayList<Integer> report = Input.extractNumbers(line);
                
                //Use isSafe to check if the report is safe or not, if not try
                //any set with one level removed
                if (!(isSafe(report))) {
                    if (isSafeWithAnyOneRemoval(report)) {
                        safeReports++; //Found one Variation that is okay
                    } else {
                        unsafeReports++; //Found none
                    }
                } else {
                    safeReports++; //Initial check was already Safe
                }
            } //Ende While Loop zur Datei auslesen
            System.out.println("Safe reports after adjusting: " + safeReports);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Take the Int Array and remove every element once and check if that produces safe
    //if any of them produce a safe output, return true
    private static boolean isSafeWithAnyOneRemoval(ArrayList<Integer> report) {
        for (int i = 0; i < report.size(); i++) {
            ArrayList<Integer> modifiedReport = new ArrayList<>(report);
            modifiedReport.remove(i);
            //feed the modified version into the isSafe
            if (isSafe(modifiedReport)) {
                return true;
            }
        }
        return false;
    }

    //Check the Conditions of Diff within 1-3 and if constantly ascending or descending
    private static boolean isSafe(ArrayList<Integer> temp) {
        boolean safe = true;
        boolean asc = false;
        boolean desc = false;
        //For Loop to compare each value to the next, but only until a single Issue is found
        for (int i = 0; (i < temp.size() - 1) && safe; i++) {
            int diff = abs(temp.get(i) - temp.get(i + 1));
            //This if checks if sequence will be ascending or descending or if its false due to having no change
            if (!asc && !desc) {
                if (temp.get(i) > temp.get(i + 1)) {
                    desc = true;
                } else if (temp.get(i) < temp.get(i + 1)) {
                    asc = true;
                } else {
                    safe = false;
                }
            }
            //This if keeps checking consequently if the conditions are stable and only acts if not
            if (asc) {
                if ((temp.get(i) > temp.get(i + 1)) || diff > 3 || diff < 1) {
                    safe = false;
                }
            } else {
                if ((temp.get(i) < temp.get(i + 1)) || diff > 3 || diff < 1) {
                    safe = false;
                }
            }
        }
        return safe;
    }
}
