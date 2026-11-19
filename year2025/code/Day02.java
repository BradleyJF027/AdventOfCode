package year2025.code;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day02 {
    public static void main (String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        File inputDoc = new File("year2025/input/day02input.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputDoc))) {
            String line = reader.readLine();
            String[] ranges = line.split(",");
            long invalidTotal = 0;

            for (String range : ranges) {
                String[] numbers = range.split("-");
                long start = Long.parseLong(numbers[0]);
                long end = Long.parseLong(numbers[1]);
                long current = start;
                while (current <= end) {
                    String number = String.valueOf(current);
                    if (number.length() % 2 == 0) {
                        int length = number.length();
                        int split = length / 2;
                        String firstHalf = number.substring(0, split);
                        String secondHalf = number.substring(split);
                        if (firstHalf.equals(secondHalf)) {
                            invalidTotal = invalidTotal + current;
                        }
                    }
                    current++;
                }
            }
            System.out.println("PART 1");
            System.out.println("The result of all invalid IDs is: " + invalidTotal + "!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void part2() {
        File inputDoc = new File("year2025/input/day02input.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputDoc))) {
            String line = reader.readLine();
            String[] ranges = line.split(",");
            long invalidTotal = 0;

            for (String range : ranges) {
                String[] numbers = range.split("-");
                long start = Long.parseLong(numbers[0]);
                long end = Long.parseLong(numbers[1]);
                long current = start;
                while (current <= end) {
                    String number = String.valueOf(current);
                    for (int patternLength = 1; patternLength <= number.length() / 2; patternLength++) {
                        if (number.length() % patternLength == 0) {
                            boolean isInvalid = true;
                            String pattern = number.substring(0, patternLength);
                            for (int i = patternLength; i < number.length(); i += patternLength) {
                                String comparison = number.substring(i, i + patternLength);
                                if (!comparison.equals(pattern)) {
                                    isInvalid = false;
                                    break;
                                }
                            }
                            if (isInvalid) {
                                invalidTotal = invalidTotal + current;
                                break;
                            }
                        }
                    }
                    current++;
                }
            }
            System.out.println("PART 2");
            System.out.println("The result of all invalid IDs is: " + invalidTotal + "!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
