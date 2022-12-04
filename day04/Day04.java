import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day04 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/assets/day04.txt"));
        System.out.println(first(lines));
    }

    public static int first(List<String> lines) {
        int sum = 0;
        for (String line : lines) {
            String[] splitLine = line.split(",");
            String[] splitRange1 = splitLine[0].split("-");
            String[] splitRange2 = splitLine[1].split("-");
            int num1 = Integer.parseInt(splitRange1[0]);
            int num2 = Integer.parseInt(splitRange1[1]);
            int num3 = Integer.parseInt(splitRange2[0]);
            int num4 = Integer.parseInt(splitRange2[1]);
            if (num1 <= num3 && num2 >= num4) {
                sum++;
            } else if (num1 >= num3 && num2 <= num4) {
                sum++;
            } else if (num1 <= num3 && num3 <= num2) {
                sum++;
            } else if (num1 >= num3 && num1 <= num4) {
                sum++;
            }
        }
        return sum;
    }
}
