/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adventofcode.days;

import adventofcode.Utils.Input;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author qp
 */
public class day3 {

    // Only use the cases of mul(x,y)  xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
    public static void runFirst() {
        String filepath = "./src/adventofcode/files/daythreeInput";
        int result = 0;
        try (BufferedReader bR = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = bR.readLine()) != null) {
                ArrayList<String> temp = Input.extractRegex(line, "(mul\\((\\d+,\\d+)\\)))");
                //Check if the report is safe
                for (String mul : temp) {
                    String[] split = mul.split(",");
                    result += Integer.valueOf(split[0]) * Integer.valueOf(split[1]);
                }
            } //Ende While Loop zur Datei auslesen
            System.out.println("The Multiplied Numbers together add up to: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runSecond() {
        String filepath = "./src/adventofcode/files/daythreeInput";
        int result = 0;
        boolean enabled = true;
        try (BufferedReader bR = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = bR.readLine()) != null) {
                ArrayList<String> temp = Input.extractRegex(line, "mul\\((\\d+,\\d+)\\)|(do\\(\\))|(don't\\(\\))");
                for (String mul : temp) {
                    switch (mul) {
                        case "do()" -> {
                            enabled = true;
                        }
                        case "don't()" -> {
                            enabled = false;
                        }
                        default -> {
                            if (enabled) {
                                //We know there is only 2 Numbers so we can just calculate it without checking how many are in there
                                ArrayList<Integer> numbers = Input.extractNumbers(mul);
                                result += numbers.get(0) * numbers.get(1);
                            }
                        }
                    }
                }
            } //Ende While Loop zur Datei auslesen
            System.out.println("The Multiplied Numbers, when considering do() and don't(), together add up to: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
