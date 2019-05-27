package oosd.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import oosd.models.board.Board;
import oosd.models.board.GameBoard;
import oosd.models.player.Player;
import oosd.models.player.Team;

/**
 * 
 * Design pattern: Factory Pattern 
 * 
 *.
 */

public abstract class BoardCreator {
	
    private Board board;

    private Team redTeam;
    private Team blueTeam;

    private Player playerOne;
    private Player playerTwo;
    
    private UnitCreator unitCreator;

    private List<Player> players;
    
    private static List<Player> playersList;
    
    
	
		
	public BoardCreator(int boardColumns, int boardRows) {
		
		board = new GameBoard(boardColumns, boardRows);
		
	    redTeam = new Team("Red");
	    blueTeam = new Team("Blue");

	    playerOne = new Player("Player One", redTeam);
	    playerTwo = new Player("Player Two", blueTeam);
	    
	    unitCreator = new UnitCreator(playerOne,playerTwo);
	    
	    players = new ArrayList<>(Arrays.asList(playerOne, playerTwo));
	    playersList = new ArrayList<>(Arrays.asList(playerOne, playerTwo));

	}
	
	public List<Player> getPlayers() {
		return players;
		
	}
	
	public Board getBoard() {
		return board;
		
	}

	public UnitCreator getunitCreator() {
		return unitCreator;
		
	}
	
	
	public static  Board getBoard(int boardtype) {
		Board board;

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
		
		board = boardCreator.getBoard();
		board.setPlayers(boardCreator.getPlayers()); 
		
		return board;
		
	}


}
