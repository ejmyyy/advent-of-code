import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day03Puzzle2 {
    public static void main(String[] args) {
        loop();
    }

    public static void loop() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("./day03-fernando/data2.txt"));
            String line = reader.readLine();

            int total = 0;
            while (line != null) {
                String elf1 = line;
                line = reader.readLine();

                String elf2 = line;
                line = reader.readLine();

                String elf3 = line;
                line = reader.readLine();


                total += process(elf1, elf2, elf3);
            }

            System.out.println("Total: " + total);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int process(String elf1, String elf2, String elf3) {

        Map<Character, Integer> duplicatedItems = new HashMap<>();

        for (int i = 0; i < elf1.length(); i++) {
            char item = elf1.charAt(i);

            checkItems(duplicatedItems, elf2, elf3, item);
        }
      

        return duplicatedItems.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static void checkItems(Map<Character, Integer> duplicatedItems, String elf2, String elf3, char item) {
        if (elf2.indexOf(item) >= 0 && elf3.indexOf(item) >= 0) {
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
