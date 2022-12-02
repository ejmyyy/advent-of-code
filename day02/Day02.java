import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Day02 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/assets/day02.txt"));
        System.out.println(second(lines));
        System.out.println(first(lines));
    }

    public static int second(List<String> lines) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A X", 3);
        map.put("A Y", 4);
        map.put("A Z", 8);
        map.put("B X", 1);
        map.put("B Y", 5);
        map.put("B Z", 9);
        map.put("C X", 2);
        map.put("C Y", 6);
        map.put("C Z", 7);

        int sum = 0;
        for (String line : lines) {
            sum += map.get(line);
        }
        return sum;
    }

    public static int first(List<String> lines) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A X", 4);
        map.put("A Y", 8);
        map.put("A Z", 3);
        map.put("B X", 1);
        map.put("B Y", 5);
        map.put("B Z", 9);
        map.put("C X", 7);
        map.put("C Y", 2);
        map.put("C Z", 6);

        int sum = 0;
        for (String line : lines) {
            sum += map.get(line);
        }
        return sum;
    }
}
