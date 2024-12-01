/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adventofcode.Utils;

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
}
