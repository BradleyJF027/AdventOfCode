package year2025.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day03 {
    public static void main (String[] args) {
        part1();
        // part2();
    }

    public static void part1() {
        File inputDoc = new File("year2025/input/day03input.txt");
        int total = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputDoc))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int highest = 0;
                search:
                for (int i = 0; i < line.length(); i++) {
                    int firstDigit = line.charAt(i) - '0';
                    for (int j = i + 1; j < line.length(); j++) {
                        int secondDigit = line.charAt(j) - '0';
                        int joltage = (firstDigit * 10) + secondDigit;
                        if (joltage > highest) {
                            highest = joltage;
                            if (highest == 99) {
                                break search;
                            }
                        }
                    }
                }
                total += highest;
            }
            System.out.println("Total is: " + total);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
