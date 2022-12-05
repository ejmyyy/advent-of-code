import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day02FerSol2 {
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
        private final int WIN = 2;
        private final int DRAW = 1;
        private final int LOSE = 0;

        @Override
        public int play(String playerMove) {
            
            int points = getPoints(playerMove);
            int playerChoice = getValueOfElement(playerMove);

            // player draw
            if(DRAW == playerChoice)
                return points + 3;
            // player lose
            else if(DRAW > playerChoice)
                return points;
            // player wins
            else
                return points + 6;
        }

        public int getValueOfElement(String element) {

            if (element.equals("X"))
                return LOSE;

            if (element.equals("Y"))
                return DRAW;
            if (element.equals("Z"))
                return WIN;

            return -1;

        }

        public int getPoints(String element) {
            // R = 1, P = 2, S = 3    
            // Lose R > S
            if (element.equals("X"))
                return 3;

            // Draw R = R
            if (element.equals("Y"))
                return 1;

            // Win R < P
            if (element.equals("Z"))
                return 2;

            return -1;

        }

    }

    public static class Paper implements GameElement {
        private final int WIN = 2;
        private final int DRAW = 1;
        private final int LOSE = 0;

        @Override
        public int play(String playerMove) {
            
            int points = getPoints(playerMove);
            int playerChoice = getValueOfElement(playerMove);

            // player draw
            if(DRAW == playerChoice)
                return points + 3;
            // player lose
            else if(DRAW > playerChoice)
                return points;
            // player wins
            else
                return points + 6;
        }

        public int getValueOfElement(String element) {

            if (element.equals("X"))
                return LOSE;

            if (element.equals("Y"))
                return DRAW;
            if (element.equals("Z"))
                return WIN;

            return -1;

        }

        public int getPoints(String element) {

            // R = 1, P = 2, S = 3    
            // Lose P > R
            if (element.equals("X"))
                return 1;

            // Draw P = P
            if (element.equals("Y"))
                return 2;

            // Win P < S
            if (element.equals("Z"))
                return 3;

            return -1;

        }
    }

    public static class Scissors implements GameElement {
        private final int WIN = 2;
        private final int DRAW = 1;
        private final int LOSE = 0;

        @Override
        public int play(String playerMove) {
            
            int points = getPoints(playerMove);
            int playerChoice = getValueOfElement(playerMove);

            // player draw
            if(DRAW == playerChoice)
                return points + 3;
            // player lose
            else if(DRAW > playerChoice)
                return points;
            // player wins
            else
                return points + 6;
        }

        public int getValueOfElement(String element) {

            if (element.equals("X"))
                return LOSE;

            if (element.equals("Y"))
                return DRAW;
            if (element.equals("Z"))
                return WIN;

            return -1;

        }

        public int getPoints(String element) {

            // R = 1, P = 2, S = 3    
            // Lose S > P
            if (element.equals("X"))
                return 2;

            // Draw S = S
            if (element.equals("Y"))
                return 3;

            // Win S < R
            if (element.equals("Z"))
                return 1;

            return -1;

        }

    }
}