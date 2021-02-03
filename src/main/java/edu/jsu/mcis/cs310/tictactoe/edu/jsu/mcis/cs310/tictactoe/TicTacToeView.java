package edu.jsu.mcis.cs310.tictactoe;

import java.util.Scanner;

/**
* TicTacToeView implements a console-based View for the Tic-Tac-Toe game.
*
* @author  Jordan Johnson
* @version 1.0
*/
public class TicTacToeView {
    
    private final Scanner keyboard;
    
    /**
    * Constructor.  This version of the Tic-Tac-Toe game uses the console for
    * I/O, so a {@link Scanner} connected to standard input is initialized to
    * receive the user's input from the console keyboard.  Output will be
    * directed to standard output using the {@link System#out} output stream.
    */
    public TicTacToeView() {
        
        keyboard = new Scanner(System.in);
        
    }
    
    /**
    * Prompt the current player to enter his or her next move.  Use iXTurn to
    * display an appropriate prompt for the current player.  This method should:
    * receive the player's input (a row and column, separated by spaces), use
    * these values to initialize a new {@link TicTacToeMove} object, and then
    * return this object to the caller.
    *
    * @param  isXTurn  a Boolean representing the current player: true if X, or
    * false if O
    * @return          a {@link TicTacToeMove} value representing the player's
    * input
    * @see             TicTacToeMove
    */
    public TicTacToeMove getNextMove(boolean isXTurn) {
        
        // INSERT YOUR CODE HERE (refer to the example output on Canvas!)
        TicTacToeMove playerMove;
        Scanner playerInput = new Scanner(System.in);

        if (isXTurn == true)
        {
            System.out.println("Player 1 (X) Move:\n Enter the row and column numbers, separated by a space: ");
            String theMove = playerInput.nextLine();
            String[] parts = theMove.split(" ");
            playerMove = new TicTacToeMove(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }
        else
        {
            System.out.println("Player 2 (O) Move:\n Enter the row and column numbers, separated by a space: ");
            String theMove = playerInput.nextLine();
            String[] parts = theMove.split(" ");
            playerMove = new TicTacToeMove(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));

        }
        
        return playerMove; // this is a stub; you should remove it later!

    }
    
    /**
    * This method displays a descriptive error message if there was a problem
    * with an attempt to enter a move.  This can happen if the specified
    * location is invalid, already marked, or out of bounds.
    */
    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }
    
    /**
    * This method prints the final result of the Tic-Tac-Toe game to the
    * console: the current state, appended by an exclamation point, on a line by
    * itself.  (The result is provided as a String by the {@link TicTacToeModel}
    * class's {@link TicTacToeModel#getState()} method; this method simply
    * outputs it to the console.)
    * 
    * @param  result  the result of the game, from {@link TicTacToeModel#getState()}
    */
    public void showResult(String result) {

        System.out.println(result + "!");

    }
    
    /**
    * This method prints the current Tic-Tac-Toe game board to the console,
    * prepended by two blank lines.  (The content of the game board is provided
    * as a String by the {@link TicTacToeModel#toString()} method of the
    * {@link TicTacToeModel} class; this method simply outputs it to the
    * console.)
    *
    * @param  board  the content of the game board, from {@link TicTacToeModel#toString()}
    * @see           TicTacToeModel
    */
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }
	
}