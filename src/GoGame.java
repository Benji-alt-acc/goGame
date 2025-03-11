// Version: 0.1

// NOTES -----------------------------------------------------------------------------------------------------
// patchnotes: 0.0 - initial commit
//             0.1 - added printBoard function, clearScreen function, converted getInput to while loop instead
//                   of for loops, added player turn/symbol display, updated board design (WIP)
// 
// TO DO -----------------------------------------------------------------------------------------------------
// find better crosshatch design?
// add scoring function
// add capture function
// add game over function
// -----------------------------------------------------------------------------------------------------------

import java.util.Scanner;

public class GoGame {
    // board, scanner, and int/bool variables
    static String[][] goBoard = new String[9][9];
    static Scanner scanner1 = new Scanner(System.in);
    static int moveY, moveX;
    static boolean player1 = true;
    static boolean playing = true;

    static int playerScore() {
        return 0; // placeholder
        // calculate player score
        // return player score
    }

    static boolean isCaptured() {
        return false; // placeholder
        // check if a stone is captured
        // if a stone is captured, remove stone from board
        // if a stone is captured, add score to player
    }

    static boolean isGameOver() {
        return false; // placeholder
        // check if game is over
        // if game is over, print score
        // if game is over, ask if user wants to play again
        // if user wants to play again, reset board
        // if user does not want to play again, exit game
    }

    static void printBoard() {
        System.out.println(" " + "\u001B[4m" + " 1 2 3 4 5 6 7 8 9 x" + "\u001B[0m"); // print top (x) axis
            for (int i = 0; i < goBoard.length; i++) {System.out.print((i+1) + "|"); // print left (y) axis
                for (int j = 0; j < (goBoard[i].length); j++) {
                    System.out.print(goBoard[i][j]);
                    if (j < goBoard[i].length - 1) {
                        System.out.print("-");
                    }
                }
                System.out.println();
            }
            System.out.println("y|"); // y axis label
    }



    static void getInput() {
        boolean validMove = false;
        while (!validMove) {
            System.out.println("Enter x coordinate:");
            moveX = scanner1.nextInt() - 1; // get x coordinate
            System.out.println("Enter y coordinate:");
            moveY = scanner1.nextInt() - 1; // get y coordinate

            if (moveY < 0 || moveY >= goBoard.length || moveX < 0 || moveX >= goBoard[0].length) {
                System.out.println("Out of bounds! Please choose a point from (1,1) to (9,9).");
                continue;
            }

            if ("+".equals(goBoard[moveY][moveX])) {
                goBoard[moveY][moveX] = player1 ? "X" : "O"; // player 1 is X, player 2 is O
                validMove = true;
            } else {
                System.out.println("Space occupied! Please choose an empty space.");
            }
        }
    }

    static void clearScreen() { // clear screen function
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        for (int i = 0; i < goBoard.length; i++) {
            for (int j = 0; j < goBoard[i].length; j++) {goBoard[i][j] = "+";}
        }

        while (playing) { // while loop to run game

            clearScreen();
            printBoard();

            String player = player1 ? "Player 1" : "Player 2"; // determine player
            String player_symbol = player1 ? "X" : "O"; // determine player symbol
            System.out.println(player + "'s turn (" + player_symbol + ")"); 

            getInput();

        player1 = !player1;} // switch players
        scanner1.close(); // close scanner
    }
}