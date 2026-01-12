import java.util.Scanner;

public class RockPaperScissorsGame {

    // Method to generate computer choice
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3); // 0,1,2
        if (choice == 0) return "Rock";
        if (choice == 1) return "Paper";
        return "Scissors";
    }

    // Method to find winner of a game
    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "Draw";
        }

        if ((user.equals("Rock") && computer.equals("Scissors")) ||
                (user.equals("Paper") && computer.equals("Rock")) ||
                (user.equals("Scissors") && computer.equals("Paper"))) {
            return "Player";
        }

        return "Computer";
    }

    // Method to calculate statistics and return 2D String array
    public static String[][] calculateStats(int playerWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][3];

        double playerPercentage = (playerWins * 100.0) / totalGames;
        double computerPercentage = (computerWins * 100.0) / totalGames;

        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] = String.valueOf(playerPercentage);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.valueOf(computerPercentage);

        return stats;
    }

    // Method to display game results and statistics
    public static void displayResults(String[][] gameResults, String[][] stats) {

        System.out.println("\nGame Results:");
        System.out.println("Game\tPlayer\t\tComputer\tWinner");

        for (int i = 0; i < gameResults.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                            gameResults[i][0] + "\t\t" +
                            gameResults[i][1] + "\t\t" +
                            gameResults[i][2]
            );
        }

        System.out.println("\nStatistics:");
        System.out.println("Entity\tWins\tWinning %");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(
                    stats[i][0] + "\t" +
                            stats[i][1] + "\t" +
                            stats[i][2]
            );
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int numberOfGames = input.nextInt();
        input.nextLine(); // consume newline

        String[][] gameResults = new String[numberOfGames][3];

        int playerWins = 0;
        int computerWins = 0;

        for (int i = 0; i < numberOfGames; i++) {
            System.out.print("Enter your choice (Rock/Paper/Scissors): ");
            String userChoice = input.nextLine();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("Player")) playerWins++;
            if (winner.equals("Computer")) computerWins++;

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(playerWins, computerWins, numberOfGames);
        displayResults(gameResults, stats);

        input.close();
    }
}
