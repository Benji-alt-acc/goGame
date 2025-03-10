import java.util.Scanner;

public class GoGame {
    // board, scanner, and int/bool variables
    static String[][] goBoard = new String[9][9];
    static Scanner scanner1 = new Scanner(System.in);
    static int moveY, moveX;
    static boolean player1 = true;
    static boolean playing = true;

    static void getInput() {
        System.out.println("Please enter x coordinate:");
        moveX = scanner1.nextInt(); // get x coordinate (SIMILAR TO stdio.readInt())
        System.out.println("Please enter y coordinate:");
        moveY = scanner1.nextInt(); // get y coordinate

        if (moveY < 0 || moveY >= goBoard.length || moveX < 0 || moveX >= goBoard[0].length) {
            System.out.println("Out of bounds! Please choose a valid space from (0,0) to (8,8).");
            getInput();
        }

        if (player1 && "-".equals(goBoard[moveY][moveX])) 
            {goBoard[moveY][moveX] = "X";} // player 1 is X
            else if (player1 && !"-".equals(goBoard[moveY][moveX])) {
                System.out.println("Space occupied! Please choose an empty space.");
                getInput();
            }
        else if (!player1 && "-".equals(goBoard[moveY][moveX]))
            {goBoard[moveY][moveX] = "O";} // player 2 is O
            else if (!player1 && !"-".equals(goBoard[moveY][moveX])) {
                System.out.println("Space occupied! Please choose an empty space.");
                getInput();
            }
    }

    public static void main(String[] args) {

        for (int i = 0; i < goBoard.length; i++) {
            for (int j = 0; j < goBoard[i].length; j++) {goBoard[i][j] = "-";}
        }

        while (playing) { // while loop to continue game
            System.out.println("  0 1 2 3 4 5 6 7 8 x"); // print top (y) axis
            for (int i = 0; i < goBoard.length; i++) {System.out.print(i + " "); // print left (x) axis
                for (int j = 0; j < goBoard[i].length; j++) {System.out.print(goBoard[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("y");
            getInput();

        player1 = !player1;} // switch players
        scanner1.close(); // close scanner
    }
}
