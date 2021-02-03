package edu.jsu.mcis.cs310.tictactoe;

/**
* TicTacToe implements the main class for the Tic-Tac-Toe game.
*
* @author  Jordan Johnson
* @version 1.0
*/
public class TicTacToe {
    
    /**
     * The default <em>dimension</em> (width and height) of the game board.  If
     * the user does not specify a different dimension for the game board, this
     * dimension is used instead.  The default dimension is currently set to 3.
     */
    public static final int DEFAULT_DIMENSION = 3;
    
    /**
    * This is the main method, which parses the <em>dimension</em> (width and
    * height) of the game board from the command line arguments, if one is
    * provided.  It then initializes, and dispatches control to, the Controller.
    * @param args the dimension of the game board, specified at the command line
    * as a single integer argument.  Must be an odd integer in the range 3 to 9.
    * @exception NumberFormatException stack trace will be printed if a non-
    * integer command-line argument is given.
    * @see NumberFormatException
    * @see TicTacToeController
    */
    public static void main(String[] args) {
        
        /* Set initial dimension of game board to the default */

        int dimension = DEFAULT_DIMENSION;
        
        /* If a valid dimension is provided as an argument, use it instead */

        if(args.length >= 1) {
            
            try {
                int arg = Integer.parseInt(args[0]);
                switch (arg) {
                    case 3: case 5: case 7: case 9:
                        dimension = arg;
                        break;
                }
            }
            catch(NumberFormatException e) { e.printStackTrace(); }
            
        }
        
        /* Initialize Controller */

        TicTacToeController controller = new TicTacToeController(dimension);
        
        /* Start Main Game Loop */
        
        controller.start();
        
    }
    
}