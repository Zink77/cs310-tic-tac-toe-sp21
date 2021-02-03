package edu.jsu.mcis.cs310.tictactoe;

/**
* TicTacToeMove represents the row and column of a player's move in the
* Tic-Tac-Toe game.
*
* @author  Jordan Johnson
* @version 1.0
*/
public class TicTacToeMove {
    
    /**
     * The row (Y coordinate) of the move
     */
    private final int row;
    
    /**
     * The column (X coordinate) of the move
     */
    private final int col;

    /**
    * Constructor
    * 
    * @param  row  the row (Y coordinate) of the move
    * @param  col  the column (X coordinate) of the move
    */
    public TicTacToeMove(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    /**
    * Getter method for the row.
    *
    * @return  the row
    */
    public int getRow() {
        return row;
    }

    /**
    * Getter method for the column.
    *
    * @return  the column
    */
    public int getCol() {
        return col;
    }
    
}