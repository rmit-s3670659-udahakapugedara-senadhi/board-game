package oosd.helpers;

import oosd.models.board.Piece;
import oosd.models.player.Player;
import oosd.models.units.Unit;

/**
 * Design Pattern - Command Design Pattern - Acts as the Momento in Momento Design Pattern
 * Stores the current movement state of the board.
 */

public class Movement {
	public Player player;
	public Unit unit;
	public Piece piece;

	public Movement(Player player, Unit unit,Piece piece) {
		this.player = player;
		this.unit = unit;
		this.piece = piece;		
	}	
	
	public Player getPlayer() {
		return this.player;	
	}
	
	public Unit getUnit() {
		return this.unit;	
	}
	
	public Piece getPiece() {
		return this.piece;	
	}

}
