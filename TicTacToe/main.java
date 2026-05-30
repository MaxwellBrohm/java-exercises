import java.util.Scanner;

public class main {

    public static void welcome() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Two players take turns entering X or O into a 3x3 grid.");
        System.out.println("The first player to get three in a row wins!");
        System.out.println("Enter the row (0-2) and column (0-2) for your move.");
    }

    public static void showGameBoard(char[][] array) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(" " + array[i][0] + " | " + array[i][1] + " | " + array[i][2]);
            System.out.println();
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    public static int checkForWinner(char[][] array, int player) {
        char symbol = (player == 1) ? 'X' : 'O';

        for (int i = 0; i < 3; i++) {
            if (array[i][0] == symbol && array[i][1] == symbol && array[i][2] == symbol) {
                return player;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (array[0][i] == symbol && array[1][i] == symbol && array[2][i] == symbol) {
                return player;
            }
        }

        if (array[0][0] == symbol && array[1][1] == symbol && array[2][2] == symbol) {
            return player;
        }

        if (array[0][2] == symbol && array[1][1] == symbol && array[2][0] == symbol) {
            return player;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] grid = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }

        welcome();

        int winner = 0;

        for (int turn = 1; turn <= 9; turn++) {
            int player = (turn % 2 != 0) ? 1 : 2;
            char symbol = (player == 1) ? 'X' : 'O';

            showGameBoard(grid);
            System.out.println("Player " + player + " (" + symbol + "), enter your move.");

            int row, col;
            while (true) {
                System.out.print("Row (0-2): ");
                row = scanner.nextInt();
                System.out.print("Column (0-2): ");
                col = scanner.nextInt();

                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid move. Please enter values between 0 and 2.");
                } else if (grid[row][col] != ' ') {
                    System.out.println("That spot is already taken. Try again.");
                } else {
                    break;
                }
            }

            grid[row][col] = symbol;

            winner = checkForWinner(grid, player);
            if (winner != 0) {
                showGameBoard(grid);
                System.out.println("Player " + winner + " wins!");
                scanner.close();
                return;
            }
        }

        showGameBoard(grid);
        System.out.println("It's a tie!");
        scanner.close();
    }
}