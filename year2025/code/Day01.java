package year2025.code;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day01 {
    public static void main (String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        int position = 50;
        int password = 0;
        File inputDoc = new File("year2025/input/day01input.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputDoc))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                char direction = line.charAt(0);
                int distance = Integer.parseInt(line.substring(1));

                if (direction == 'L') {
                    position = position - distance;
                }
                else if (direction == 'R') {
                    position = position + distance;
                }
                else {
                    System.out.println("Something went wrong.");
                }
                position = ((position % 100) + 100) % 100;

                if (position == 0) {
                    password++;
                }
            }
            System.out.println("The Part1 password is " + password + "!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void part2() {
        int position = 50;
        int password = 0;
        File inputDoc = new File("year2025/input/day01input.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputDoc))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                char direction = line.charAt(0);
                int distance = Integer.parseInt(line.substring(1));

                if (direction == 'L') {
                    while (distance > 0) {
                        position--;
                        position = ((position % 100) + 100) % 100;
                        if (position == 0) {
                            password++;
                        }
                        distance--;
                    }
                }
                else if (direction == 'R') {
                    while (distance > 0) {
                        position++;
                        position = ((position % 100) + 100) % 100;
                        if (position == 0) {
                            password++;
                        }
                        distance--;
                    }
                }
                else {
                    System.out.println("Something went wrong.");
                }
            }
            System.out.println("The Part2 password is " + password + "!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
