package edu.jsu.mcis.cs310.tictactoe;

/**
* TicTacToeSquare represents the state of an individual square on a Tic-Tac-Toe
* game board, or the specified player's mark.
*
* @author  Jordan Johnson
* @version 2.0
*/
public enum TicTacToeSquare {
    
    /**
     * X
     */    
    X("X"),
    
    /**
     * O
     */
    O("O"),
    
    /**
     * Empty Square
     */
    EMPTY(" ");

    private String message;

    private TicTacToeSquare(String msg) {
        message = msg;
    }

    @Override
    public String toString() {
        return message;
    }
    
}