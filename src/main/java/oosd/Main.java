package oosd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import oosd.controllers.GameController;
import oosd.controllers.MainController;
import oosd.helpers.BoardCreator;
import oosd.helpers.LargeBoardCreator;
import oosd.helpers.MediumBoardCreator;
import oosd.helpers.SmallBoardCreator;
import oosd.helpers.UnitCreator;
import oosd.models.GameEngine;
import oosd.models.board.Board;
import oosd.models.board.GameBoard;
import oosd.models.player.Player;
import oosd.models.player.Team;
import oosd.views.components.Hexagon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GRASP: information expert
 * The main program class contains configuration information about the game.
 * If a user were to change specific units on the board, they can change it here in the main class.
 */
public class Main extends Application {
    
    private final String windowTitle = "Red Alert Game GameBoard";
    private final int sceneWidth = 1200;
    private final int sceneHeight = 900;

    /**
     * Boilerplate code for JavaFX.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * GRASP: The creator
     * Creates the initialized game logic and base UI objects at the start of the program.
     *
     * @param primaryStage JavaFX primary window
     * @throws Exception if the startup dies
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	MainController mainController = new MainController(primaryStage);
    	
    	FXMLLoader loader = new FXMLLoader(MainController.class.getResource("main.fxml"));
    	loader.setController(mainController);
    	
        Pane pane = loader.load();
        Scene content = new Scene(pane, sceneWidth, sceneHeight);
        
        primaryStage.setScene(content);
        primaryStage.setTitle(windowTitle);
        primaryStage.setResizable(false);
        primaryStage.show();
    	   	
    }
    

    /**
     * Initialize game configuration data, which can be easily modified.
     * 
     * @param  int Board Type- Small =1 Medium = 2 Large 3
     *
     * @return the game engine
     */
    public static GameEngine initializeGameEngine(int boardtype) {
    	
    	BoardCreator boardCreator = new LargeBoardCreator();
    	
    	if (boardtype == 1) {
    		boardCreator = new SmallBoardCreator();		
    	}
    	if (boardtype == 2) {
    		boardCreator = new MediumBoardCreator();	
    		
    	}
    	if (boardtype == 3) {
    		boardCreator = new LargeBoardCreator();		
    	}
    	
    	    	
        return new GameEngine(boardCreator.getBoard(),boardCreator.getPlayers());
        
    }
}
