package oosd.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import oosd.models.board.Piece;
import oosd.models.player.Player;
import oosd.models.units.Unit;

public class HistoryManager {

	// manage execution and undo of Commands
	// this is the "invoker" in the Command pattern

	// using the removeLast method from HashMap interface	   
	private LinkedList<Movement> history = new LinkedList<Movement>();

	   public void store(Player player,Unit unit,Piece piece)
	   {
		  Movement movement = new Movement(player,unit,piece);
	      this.history.add(movement);
	   }

	   public UndoContainer undoLast()
	   {		   		   		     
		   
		   Piece removedPiece2 =this.history.getLast().piece;
		   removedPiece2.setUnit(null);
		   this.history.removeLast();
		   Piece removedPiece1 =this.history.getLast().piece;
		   removedPiece1.setUnit(null);
		   this.history.removeLast();
		   
		   Movement position2 = this.history.getLast();
		   Movement position1 = this.history.get(this.history.size()-2);
		   
		   Piece piece2 = position2.piece;
		   piece2.setUnit(position2.unit);
		   
		   Piece piece1 = position1.piece;
		   piece1.setUnit(position1.unit);
		   
		   UndoContainer undoContainer = new UndoContainer(removedPiece2, removedPiece1,piece2, piece1);
		   		    
		   return  undoContainer;
	   
	   }
	}


