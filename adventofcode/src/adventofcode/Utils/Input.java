/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adventofcode.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author qp
 */
public class Input {

    public static ArrayList<Integer> extractNumbers(String input) {
        ArrayList<Integer> extracted = new ArrayList<>();
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            extracted.add(number);
        }
        return extracted;
    }

    public static ArrayList<String> extractRegex(String input, String regex) {
        ArrayList<String> extracted = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            extracted.add(matcher.group());
        }
        return extracted;
    }

    public static ArrayList<String> readFile(String filename) {
        String filepath = "./src/adventofcode/files/" + filename;
        ArrayList<String> readList = new ArrayList<>();
        try (BufferedReader bR = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = bR.readLine()) != null) {
                readList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readList;
    }
}
