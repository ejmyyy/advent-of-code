import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day03Puzzle1 {
    public static void main(String[] args) {
        loop();
    }

    public static void loop() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("./day03-fernando/data.txt"));
            String line = reader.readLine();

            int total = 0;
            while (line != null) {
                total += process(line);
                line = reader.readLine();
            }

            System.out.println("Total: " + total);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int process(String line) {
        int sackSize = line.length();
        int compartment2Index = (sackSize / 2);
        String compartment1 = line.substring(0, compartment2Index);

        Map<Character, Integer> duplicatedItems = new HashMap<>();

        while (compartment2Index < sackSize) {
            char item = line.charAt(compartment2Index++);

            checkItems(duplicatedItems, compartment1, item);

        }

        return duplicatedItems.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static void checkItems(Map<Character, Integer> duplicatedItems, String rucksack, char item) {
        if (rucksack.indexOf(item) >= 0) {
            // a=97
            // A=65

            if (!duplicatedItems.containsKey(item)) {
                System.out.println("Repeatd: " + item);
                if (Character.isUpperCase(item)) {
                    int result = item + 27 - 'A';
                    duplicatedItems.put(item, result);
                }

                if (Character.isLowerCase(item)) {
                    int result = item + 1 - 'a';
                    duplicatedItems.put(item, result);
                }
            }

        }
    }
}
