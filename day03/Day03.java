import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day03 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/assets/day03.txt"));
        System.out.println(first(lines));
        System.out.println(second(lines));
    }

    public static int first(List<String> lines) {
        int sum = 0;
        for (String line : lines) {
            List<Character> first = line.substring(0, line.length() / 2).chars().mapToObj(c -> (char) c).toList();
            List<Character> second = line.substring(line.length() / 2).chars().mapToObj(c -> (char) c).toList();
            for (Character ch : first) {
                if (second.contains(ch)) {
                    if (Character.isLowerCase(ch)) sum += ch - 96;
                    else if (Character.isUpperCase(ch)) sum += ch - 38;
                    break;
                }
            }
        }

        return sum;
    }

    public static int second(List<String> lines) {
        int sum = 0;
        int counter = 0;
        List<List<Character>> groups = new ArrayList<>();
        for (String line : lines) {
            if (counter < 3) {
                List<Character> charsLine = line.chars().mapToObj(c -> (char) c).toList();
                groups.add(charsLine);
                counter++;
            }
            if (counter == 3) {
                for (Character ch : groups.get(0)) {
                    if (groups.get(1).contains(ch) && groups.get(2).contains(ch)) {
                        if (Character.isLowerCase(ch)) sum += ch - 96;
                        else if (Character.isUpperCase(ch)) sum += ch - 38;
                        break;
                    }
                }
                counter = 0;
                groups.clear();
            }
        }

        return sum;
    }
}
