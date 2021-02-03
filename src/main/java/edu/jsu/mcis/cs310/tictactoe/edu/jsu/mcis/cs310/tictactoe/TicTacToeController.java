package edu.jsu.mcis.cs310.tictactoe;

/**
* TicTacToeController implements the Controller for the Tic-Tac-Toe game.
*
* @author  Jordan Johnson
* @version 1.0
*/
public class TicTacToeController {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /**
    * Constructor.  Uses specified dimension to initialize Model and View
    * 
    * @param dimension The <em>dimension</em> (width and height) of the new
    * Tic-Tac-Toe board.
    */
    public TicTacToeController(int dimension) {

        model = new TicTacToeModel(dimension);
        view = new TicTacToeView();
        
    }
    
    /**
    * <p>Implements the main game loop, which repeats until the game is over.
    * This method should use {@link TicTacToeModel#isGameover()} to check if
    * the game is over; as long as the game is <em>not over</em>, the main loop should:</p>
    * <ol>
    * <li>Display the board using the {@link TicTacToeView#showBoard(java.lang.String)} method,</li>
    * <li>Get the next move from player using the {@link TicTacToeView#getNextMove(boolean)} method,</li>
    * <li>Attempt to make the player's mark using the {@link TicTacToeModel#makeMark(int, int)} method.</li>
    * </ol>
    * <p>If the attempt failed, the {@link TicTacToeView#showInputError()} method
    * should be called to display an error message.  The player should then be
    * prompted to enter another move until the attempt is successful.</p>
    * <p>After the game is over, use the {@link TicTacToeView#showBoard(java.lang.String)} method
    * to show the final state of the game board, and the {@link TicTacToeView#showResult(java.lang.String)} method
    * to show the final result: either X or O wins, or a tie condition.</p>
    */

    public void start() {
    
        /* MAIN LOOP (repeats until game is over) */

        // INSERT YOUR CODE HERE


        while (!model.isGameover())
        {
            view.showBoard(model.toString());
            TicTacToeMove move = view.getNextMove(model.isXTurn());
            boolean validityOfSquare = model.makeMark(move.getRow(), move.getCol());

            if (!validityOfSquare)
            {
                do
                    {
                        view.showInputError();
                        System.out.println("Please enter another coordinate: ");
                        view.showBoard(model.toString());
                        move = view.getNextMove(model.isXTurn());
                        validityOfSquare = model.makeMark(move.getRow(), move.getCol());
                    }
                while (!validityOfSquare);

            }

        }
        
        /* Display Results and Exit */

        view.showBoard(model.toString());

        view.showResult(model.getState().toString());
        
    }

}