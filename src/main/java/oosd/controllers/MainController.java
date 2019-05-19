package oosd.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import oosd.Main;
import oosd.helpers.Movement;
import oosd.helpers.UndoContainer;
import oosd.models.GameEngine;
import oosd.models.board.Piece;
import oosd.views.BoardView;
import oosd.views.components.BoardPane;
import oosd.views.components.Hexagon;
import oosd.views.components.SidebarPane;
import oosd.views.components.ToolbarPane;
import oosd.views.components.WindowGridPane;

/**
 * GRASP: The controller
 * Used to handle requests from other objects include the view and model.
 * Acts as a middleman that delegates tasks to other objects.
 * Cleanly separates the user interface (view) from the business objects (model)
 */
public class MainController extends Controller {
	
	@FXML
	private Stage primaryStage;
      

    @FXML
    private WindowGridPane windowGridPane;

    @FXML
    private BoardPane boardPane;

    @FXML
    private SidebarPane sidebar;

    @FXML
    private ToolbarPane toolbar;

    private BoardView boardView;
    
    private final String boardFileName = "board.fxml";
    private final String windowTitle = "OOSD Game GameBoard";
    private final int sceneWidth = 1200;
    private final int sceneHeight = 900;
    

    public MainController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        System.out.println("poop");
        
    }
    
    @FXML protected void handleSmallBoardButtonAction(ActionEvent event) throws IOException {
    	System.out.println("poop");
    	
    	
    	GameController gameController = new GameController(Main.initializeGameEngine(1));

        FXMLLoader loader = new FXMLLoader(GameController.class.getResource(boardFileName));
        loader.setController(gameController);

        Pane pane = loader.load();
        Scene content = new Scene(pane, sceneWidth, sceneHeight);

        primaryStage.setScene(content);
        primaryStage.setTitle(windowTitle);
        primaryStage.setResizable(false);
        primaryStage.show();
      
    }
    
    @FXML protected void handleMediumBoardButtonAction(ActionEvent event) throws IOException {
    	System.out.println("poop");
    	
    	GameController gameController = new GameController(Main.initializeGameEngine(2));

        FXMLLoader loader = new FXMLLoader(GameController.class.getResource(boardFileName));
        loader.setController(gameController);

        Pane pane = loader.load();
        Scene content = new Scene(pane, sceneWidth, sceneHeight);

        primaryStage.setScene(content);
        primaryStage.setTitle(windowTitle);
        primaryStage.setResizable(true);
        primaryStage.show();
        
    }
    
    @FXML protected void handleLargeBoardButtonAction(ActionEvent event) throws IOException {
    	System.out.println("poop");
    	
    	GameController gameController = new GameController(Main.initializeGameEngine(3));

        FXMLLoader loader = new FXMLLoader(GameController.class.getResource(boardFileName));
        loader.setController(gameController);

        Pane pane = loader.load();
        Scene content = new Scene(pane, sceneWidth, sceneHeight);

        primaryStage.setScene(content);
        primaryStage.setTitle(windowTitle);
        primaryStage.setResizable(true);
        primaryStage.show();
        
    }

	@Override
	void initialize() {
		
		
	}
    
   
}
