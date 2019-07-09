package app;

import java.util.Scanner;

public class Game {
    
    private static Scanner input = new Scanner(System.in);

    public static Scanner getInput() {
        return input;
    }

    private Player player1;
    private Player player2;
    
    private Player currentPlayer;

    private Field[] board = new Field[9];

    private int[][] winStates = new int[][] {
        {1,2,3},
        {4,5,6},
        {7,8,9},

        {1,4,7},
        {2,5,8},
        {3,6,9},

        {1,5,9},
        {3,5,7}
    };

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;

        for (int i = 0; i < 9; i++) {
            board[i] = new Field(i + 1);
        }
    }

	public void play() {
        while(!isFinished()) {

            printBoard();
            System.out.println("Current player is: " + currentPlayer.getName());
            System.out.println("Choose a field:");
            
            int position = input.nextInt() - 1;
            
            if(position < 0 || position > 9) {
                System.out.println("There is no field at position " + (position + 1));
            }
            else if(board[position].setPlayer(currentPlayer)) {
                if(gameIsWon()) {
                    currentPlayer.Win();
                    break;
                }
                else {
                    switchPlayer();
                }
            } else {
                System.out.println("Field already taken, choose anothor one");
            }
            System.out.println();
        }

        System.out.println();
        printBoard();
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }

    private void switchPlayer() {
        //currentPlayer = currentPlayer == player1 ? player2 : player1;

        if(currentPlayer == player1) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i * 3 + j].toString() + " ");
            }
            System.out.println("");
        }
        System.out.println();
    }

    private boolean isFinished() {
        boolean finished = true;
        for (Field field : board) {
            if(!field.isSet()) {
                finished = false;
                break;
            }
        }
        return finished;
    }

    private boolean gameIsWon() {
        boolean gameWon = false;
        for (int[] winState : winStates) {
            if(evaluateWinState(winState)) {
                gameWon = true;
                break;
            }
        }
        return gameWon;
    }

    private boolean evaluateWinState(int[] winState) {
        boolean found = true;
        for (int field : winState) { 
            if(board[field - 1].getPlayer() != currentPlayer) {
                found = false;
                break;
            }
        }
        return found;
    }
}