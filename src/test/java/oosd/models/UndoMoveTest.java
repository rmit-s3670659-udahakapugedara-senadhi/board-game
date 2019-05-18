package oosd.models;

import oosd.helpers.HistoryManager;
import oosd.helpers.UndoContainer;
import oosd.helpers.UnitCreator;
import oosd.models.board.Board;
import oosd.models.board.GameBoard;
import oosd.models.board.Piece;
import oosd.models.player.Player;
import oosd.models.player.Team;
import oosd.models.units.Unit;
import oosd.models.units.allied.GISoldier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UndoMoveTest {
    @Test
    void testCheckBoardExistsOnGameEngine() {
        // Act
        Board board = new GameBoard(2, 2);
        GameEngine gameEngine = new GameEngine(board, new ArrayList<>());

        // Assert
        assertNotNull(gameEngine);
        assertNotNull(gameEngine.getBoard());
    }

    @Test
    void testSetBoardSize() {
        // Arrange
        final int rows = 100;
        final int columns = 100;

        // Act
        Board board = new GameBoard(columns, rows);
        GameEngine gameEngine = new GameEngine(board, new ArrayList<>());

        // Assert
        assertEquals(gameEngine.getBoard().getRows(), rows);
        assertEquals(gameEngine.getBoard().getColumns(), columns);
        assertNotNull(gameEngine.getBoard().getPiece(columns - 1, rows - 1));
    }

    @Test
    void testSetAndGetSelectedPiece() {
        // Arrange
        Piece expectedPiece = new Piece(1, 1);
        Board board = new GameBoard(2, 2);
        GameEngine gameEngine = new GameEngine(board, new ArrayList<>());

        // Act
        gameEngine.setSelectedPiece(expectedPiece);
        Piece selectedPiece = gameEngine.getSelectedPiece();

        // Assert
        assertEquals(expectedPiece, selectedPiece);
    }



    @Test
    void testGetValidMoves() {
        // Arrange
        Player player = new Player("John Tester", new Team("Red"));
        Unit unit = new GISoldier(player);
        Board board = new GameBoard(2, 2);
        GameEngine gameEngine = new GameEngine(board, new ArrayList<>());
        Piece piece = gameEngine.getBoard().getPiece(0, 1);
        piece.setUnit(unit);

        // Act
        List<Piece> validMove = piece.getUnit().getUnitBehaviour().getValidMoves(gameEngine, piece);

        // Assert
        assertTrue(validMove.size() > 0);
    }

    @Test
    void testGetFirstTurnOnFirstPlayer() {
        // Arrange
        Board board = new GameBoard(2, 2);
        List<Player> players = new ArrayList<>();
        players.add(new Player("John Tester", new Team("Red")));
        GameEngine gameEngine = new GameEngine(board, players);

        // Act
        Player player = gameEngine.getTurn();

        // Assert
        assertNotNull(player);
    }

    @Test
    void testGetNextTurn() {
        // Arrange
        Player playerOne = new Player("Johnny Dave", new Team("Red"));
        Player playerTwo = new Player("Jane Doe", new Team("Blue"));
        List<Player> players = new ArrayList<>(Arrays.asList(playerOne, playerTwo));
        Board board = new GameBoard(2, 2);
        GameEngine gameEngine = new GameEngine(board, players);

        // Act
        Player firstTurn = gameEngine.getTurn();
        Player getFirstTurn = gameEngine.getTurn();
        Player secondTurn = gameEngine.getNextTurn();
        Player getSecondTurn = gameEngine.getTurn();
        Player thirdTurn = gameEngine.getNextTurn();
        Player getThirdTurn = gameEngine.getTurn();
        Player forthTurn = gameEngine.getNextTurn();
        Player getForthTurn = gameEngine.getTurn();

        // Assert
        assertEquals(playerOne, firstTurn);
        assertEquals(playerOne, getFirstTurn);
        assertEquals(playerTwo, getSecondTurn);
        assertEquals(playerTwo, secondTurn);
        assertEquals(playerOne, thirdTurn);
        assertEquals(playerOne, getThirdTurn);
        assertEquals(playerTwo, forthTurn);
        assertEquals(playerTwo, getForthTurn);
    }

    @Test
    void testGetPlayers() {
        // Arrange
        Player playerOne = new Player("Johnny Dave", new Team("Red"));
        Player playerTwo = new Player("Jane Doe", new Team("Blue"));
        List<Player> expectedPlayers = new ArrayList<>(Arrays.asList(playerOne, playerTwo));
        Board board = new GameBoard(2, 2);
        GameEngine gameEngine = new GameEngine(board, expectedPlayers);

        // Act
        List<Player> actualPlayers = gameEngine.getPlayers();

        // Assert
        assertEquals(expectedPlayers, actualPlayers);
        assertEquals(2, actualPlayers.size());
    }
    
    
    @Test
    void testUndoFeature() {
    	Player playerOne = new Player("Johnny Dave", new Team("Red"));
        Player playerTwo = new Player("Jane Doe", new Team("Blue"));
        List<Player> players = new ArrayList<>(Arrays.asList(playerOne, playerTwo));
        
        UnitCreator unitCreator = new UnitCreator(playerOne,playerTwo);
        
        
        Board board = new GameBoard(10, 10);        
        
        board.getPiece(0, 0).setUnit(unitCreator.makeGISoldier());
        board.getPiece(1, 0).setUnit(unitCreator.makeGISoldier());
        board.getPiece(2, 0).setUnit(unitCreator.makeGrizzlyTank());
        board.getPiece(3, 0).setUnit(unitCreator.makeGrizzlyTank());
        board.getPiece(4, 0).setUnit(unitCreator.makeHarrier());
        board.getPiece(5, 0).setUnit(unitCreator.makeHarrier());
        board.getPiece(6, 0).setUnit(unitCreator.makeGrizzlyTank());
        board.getPiece(7, 0).setUnit(unitCreator.makeGrizzlyTank());
        board.getPiece(8, 0).setUnit(unitCreator.makeGISoldier());
        board.getPiece(9, 0).setUnit(unitCreator.makeGISoldier());
        board.getPiece(0, 9).setUnit(unitCreator.makeRhinoTank());
        board.getPiece(1, 9).setUnit(unitCreator.makeRhinoTank());
        board.getPiece(2, 9).setUnit(unitCreator.makeKirovAirshipk());
        board.getPiece(3, 9).setUnit(unitCreator.makeKirovAirshipk());
        board.getPiece(4, 9).setUnit(unitCreator.makeConscript());
        board.getPiece(5, 9).setUnit(unitCreator.makeConscript());
        board.getPiece(6, 9).setUnit(unitCreator.makeKirovAirshipk());
        board.getPiece(7, 9).setUnit(unitCreator.makeKirovAirshipk());
        board.getPiece(8, 9).setUnit(unitCreator.makeRhinoTank());
        board.getPiece(9, 9).setUnit(unitCreator.makeRhinoTank());	
    	
        GameEngine gameEngine = new GameEngine(board, players);
        
        //Round 1 
        gameEngine.storeMove(playerOne, board.getPiece(0,0).getUnit(), board.getPiece(0,1));
        gameEngine.storeMove(playerTwo, board.getPiece(0,9).getUnit(), board.getPiece(0,8));
        
        //Round 2 - Undo 3 must land here
        gameEngine.storeMove(playerOne, board.getPiece(0,1).getUnit(), board.getPiece(0,2));
        gameEngine.storeMove(playerTwo, board.getPiece(0,8).getUnit(), board.getPiece(0,7));
        
        //Round 3 - Undo2 must land here
        gameEngine.storeMove(playerOne, board.getPiece(0,2).getUnit(), board.getPiece(0,3));
        gameEngine.storeMove(playerTwo, board.getPiece(0,7).getUnit(), board.getPiece(0,6));
        
        //Round 4 - Undo 1 must land here
        gameEngine.storeMove(playerOne, board.getPiece(0,3).getUnit(), board.getPiece(0,4));
        gameEngine.storeMove(playerTwo, board.getPiece(0,6).getUnit(), board.getPiece(0,5));
        
        //Round 5
        gameEngine.storeMove(playerOne, board.getPiece(0,4).getUnit(), board.getPiece(1,4));
        gameEngine.storeMove(playerTwo, board.getPiece(0,5).getUnit(), board.getPiece(1,5));
        

        UndoContainer undoContainer = gameEngine.undoLastMove();
        
        //Checking Undo1
        undoContainer = gameEngine.undoLastMove();
        
        assertEquals(undoContainer.p1movedpiece, board.getPiece(0,4));
        assertEquals(undoContainer.p2movedpiece, board.getPiece(0,5));
        
        assertEquals(undoContainer.p1removePiece, board.getPiece(1,4));
        assertEquals(undoContainer.p2removePiece, board.getPiece(1,5));
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
}
