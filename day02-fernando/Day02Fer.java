import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day02Fer {
    public static void main(String[] args) throws IOException {

        Map<String, GameElement> gameElements = new HashMap<>();

        gameElements.put("A", new Rock());
        gameElements.put("B", new Paper());
        gameElements.put("C", new Scissors());

        System.out.println("Total Points: " + loop(gameElements));
    }

    public static int loop(Map<String, GameElement> gameElements) {
        BufferedReader reader;
        int total_points = 0;
        try {
            reader = new BufferedReader(new FileReader("./day02-fernando/data.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] played = line.split(" ");

                total_points += gameElements.get(played[0]).play(played[1]);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return total_points;
    }

    interface GameElement {
        int play(String element);
    }
    public static class Rock implements GameElement {
        private final int ROCK = 1;
        private final int PAPER = 2;
        private final int SCISSORS = 0;

        @Override
        public int play(String playerMove) {
            
            int points = getPoints(playerMove);
            int playerChoice = getValueOfElement(playerMove);

            // player draw
            if(ROCK == playerChoice)
                return points + 3;
            // player lose
            else if(ROCK > playerChoice)
                return points;
            // player wins
            else
                return points + 6;
        }

        public int getValueOfElement(String element) {

            if (element.equals("X"))
                return ROCK;

            if (element.equals("Y"))
                return PAPER;
            if (element.equals("Z"))
                return SCISSORS;

            return -1;

        }

        public int getPoints(String element) {

            if (element.equals("X"))
                return 1;

            if (element.equals("Y"))
                return 2;
            if (element.equals("Z"))
                return 3;

            return -1;

        }

    }

    public static class Paper implements GameElement {
        private final int ROCK = 0;
        private final int PAPER = 1;
        private final int SCISSORS = 2;

        @Override
        public int play(String element) {
            
            int points = getPoints(element);
            int elementChosed = getValueOfElement(element);

            // player draw
            if(PAPER == elementChosed)
                return points + 3;
            // player lose
            else if(PAPER > elementChosed)
                return points;
            // player wins
            else
                return points + 6;
        }

        public int getPoints(String element) {

            if (element.equals("X"))
                return 1;

            if (element.equals("Y"))
                return 2;
            if (element.equals("Z"))
                return 3;

            return -1;

        }

        public int getValueOfElement(String element) {

            if (element.equals("X"))
                return ROCK;

            if (element.equals("Y"))
                return PAPER;
            if (element.equals("Z"))
                return SCISSORS;

            return -1;

        }

    }

    public static class Scissors implements GameElement {
        private final int ROCK = 2;
        private final int PAPER = 0;
        private final int SCISSORS = 1;

        @Override
        public int play(String element) {
            
            int points = getPoints(element);
            int elementChosed = getValueOfElement(element);

            // player draw
            if(SCISSORS == elementChosed)
                return points + 3;
            // player lose
            else if(SCISSORS > elementChosed)
                return points;
            // player wins
            else
                return points + 6;
        }

        public int getPoints(String element) {

            if (element.equals("X"))
                return 1;

            if (element.equals("Y"))
                return 2;
            if (element.equals("Z"))
                return 3;

            return -1;

        }

        public int getValueOfElement(String element) {

            if (element.equals("X"))
                return ROCK;

            if (element.equals("Y"))
                return PAPER;
            if (element.equals("Z"))
                return SCISSORS;

            return -1;

        }

    }
}