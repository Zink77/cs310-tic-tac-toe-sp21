package edu.jsu.mcis.cs310.tictactoe;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* TicTacToeController implements the Controller for the Tic-Tac-Toe game.
* 
* @author  Jay Snellen, III
* @version 2.0
* 
* (Instead of the Controller implementing the flow of execution in a main loop,
* as in the console version of this game, the GUI version leaves all interaction
* with the user to the View.  The Controller implements the
* {@link ActionListener} interface, so that when the user interacts with the GUI
* (by clicking a button, for example), these events can be handled by the
* Controller, in much the same way that the Controller handled user input
* returned from the View in the console version of this game.
* 
* @see ActionListener
*
*/
public class TicTacToeController implements ActionListener {

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
        view = new TicTacToeView(this, dimension);
        
    }
    
    /**
    * A "pass-through" method to allow the main class to start the GUI.
    */
    public void start() {
    
        view.start();
        
    }
    
    /**
    * This method gets the content of the indicated square from the Model and
    * returns it to the caller as a String.  This is a "pass-through" method
    * provided for the View; it allows the state of the Model to be passed to
    * the View so it can be displayed in the GUI, while leaving the Model and
    * View completely separated from one another.
    * 
    * @param row  the row (Y coordinate) of the square.
    * @param col  the column (X coordinate) of the square.
    * @return     a String representing the content of the indicated square
    */
    public String getSquareAsString(int row, int col) {
        
        return (model.getSquare(row, col).toString());
        
    }
    
    /**
    * This is the event handler for the View.  When the user interacts with the
    * View (by clicking a button, for example), the event is handled by this
    * method, which implements the ActionListener interface.
    * 
    * @param event  a reference to the GUI component which initiated the event
    */    
    @Override
    public void actionPerformed(ActionEvent event) {
        
        /* Get GUI Component Name */
        
        String name = ((Component) event.getSource()).getName();
        
        /* Parse Row and Column from Name (assumes "SquareYX" format!) */

        int row = Integer.parseInt(name.substring(6, 7));
        int col = Integer.parseInt(name.substring(7, 8));
        
        /* Add Mark to Model */

        model.makeMark(row,col);
        
        /* Update the View */

        view.updateSquares();
        
        /* Get Game State */
        
        TicTacToeState state = model.getState();
        
        /* If Game Over, Disable Squares and Show Result in Result Label */

        if (state != TicTacToeState.NONE) {

            view.disableSquares();
            view.showResult(state.toString());
            
        }
        
        /* Else, Clear Result Label */
        
        else {
            
            view.clearResult();
            
        }

    }

}