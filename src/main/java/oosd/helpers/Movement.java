package oosd.helpers;

import oosd.models.board.Piece;
import oosd.models.player.Player;
import oosd.models.units.Unit;

public class Movement {
	public Player player;
	public Unit unit;
	public Piece piece;

	public Movement(Player player, Unit unit,Piece piece) {
		this.player = player;
		this.unit = unit;
		this.piece = piece;		
	}	

}
