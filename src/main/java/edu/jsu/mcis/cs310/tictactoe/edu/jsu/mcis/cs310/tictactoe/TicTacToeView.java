package edu.jsu.mcis.cs310.tictactoe;

import java.awt.*;
import javax.swing.*;

/**
* TicTacToeView implements a GUI-based View for the Tic-Tac-Toe game.
*
* @author  Jay Snellen, III
* @version 2.0
* 
* This version of the Tic-Tac-Toe game uses a GUI for I/O, so the View
* implements a JPanel containing all GUI elements and containers.  This JPanel
* is added later to a JFrame window, after it has been initialized by the
* constructor.
*/
public class TicTacToeView extends JPanel {
    
    private final TicTacToeController controller;

    private JButton[][] board;
    private JPanel squaresPanel;
    private JLabel resultLabel;

    /**
    * Constructor.
    * 
    * @param controller  a reference to the Controller
    * @param dimension   The <em>dimension</em> (width and height) of the new
    * Tic-Tac-Toe board.
    */
    public TicTacToeView(TicTacToeController controller, int dimension) {

        this.controller = controller;
        
        /* Initialize GUI Elements and Containers */

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));        
        board = new JButton[dimension][dimension];
        squaresPanel = new JPanel(new GridLayout(dimension,dimension));
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        
        /* Create Button Array */
        
        for (int i = 0; i < dimension; ++i) {
            
            for (int j = 0; j < dimension; ++j) {
                
                board[i][j] = new JButton(); 
                board[i][j].addActionListener(controller);
                board[i][j].setName("Square" + i + j); // Assign button names
                board[i][j].setPreferredSize(new Dimension(64,64));
                squaresPanel.add(board[i][j]);
                
            }
            
        }
        
        /* Add Panels to GUI */

        this.add(squaresPanel);
        this.add(resultLabel);
        
        /* Display Greeting in Result Panel */
        
        resultLabel.setText("Welcome to Tic-Tac-Toe!");

    }
    
    /**
    * This method initializes the Tic-Tac-Toe user interface window.  It creates
    * and initializes a new JFrame, adds the TicTacToeView to it, and makes it
    * visible to the user.
    */
    public void start() {
        
        JFrame win = new JFrame("Tic-Tac-Toe");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        win.add(this);
        win.pack();
        win.setVisible(true);
        
    }
        
    /**
    * This method updates the squares of the GUI to reflect the current state of
    * the game board.  Instead of updating the squares one at a time, as the
    * players make their marks, the GUI is updated all at once.  This method
    * should: iterate through the two-dimensional JButton array, and on each
    * JButton object, invoke its {@link JButton#setEnabled} method to enable the
    * button, and its {@link JButton#setText} method to set the button text to
    * the mark that is currently within the corresponding square.  To get this
    * mark as a String, use the {@link TicTacToeController#getSquareAsString}
    * method.
    * 
    * @see         TicTacToeController
    * @see         JButton
    */
    public void updateSquares() {

        // INSERT YOUR CODE HERE

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j].setEnabled(true);
                board[i][j].setText(controller.getSquareAsString(i,j));
            }
        }

    }
    
    /**
    * This method disables the buttons in the user interface, so that after the
    * game is over, no further moves can be made.  This method should: iterate
    * through the two-dimensional JButton array, and on each JButton object,
    * invoke its {@link JButton#setEnabled} method to disable the button,
    * preventing any further clicks to be registered on the button.
    */
    public void disableSquares() {
    
        // INSERT YOUR CODE HERE
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j].setEnabled(false);
            }
        }

    }

        
    /**
    * This method updates the result label to display the final result of the
    * game, or any other message specified by the caller.
    * 
    * @param message  the message to be displayed
    */
    public void showResult(String message) {
        
        resultLabel.setText(message);
        
    }
    
    /**
    * This method clears the current contents of the result label.
    */
    public void clearResult() {
        
        resultLabel.setText(" ");
        
    }

}