import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day01 {
    public static void main(String[] args) throws IOException {
        // READ FILE
        List<String> lines = Files.readAllLines(Paths.get("src/assets/day01.txt"));

        List<Integer> maxGroupCalories = Arrays.asList(0,0,0);
        int groupCalories = 0;
        for (String line : lines) {
            if (!line.equals("")) {
                groupCalories += Integer.parseInt(line);
            } else {
                int min = Collections.min(maxGroupCalories);
                if (min < groupCalories) {
                    maxGroupCalories.set(maxGroupCalories.indexOf(min), groupCalories);
                }
                groupCalories = 0;
            }
        }
        int sum = maxGroupCalories.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }
}