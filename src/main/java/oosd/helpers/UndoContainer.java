package oosd.helpers;

import oosd.models.board.Piece;

public class UndoContainer {
	public Piece p2removePiece, p1removePiece, p2movedpiece, p1movedpiece;
	

	public UndoContainer(Piece p2removePiece, Piece p1removePiece, Piece p2movedpiece, Piece p1movedpiece) {
		this.p2removePiece = p2removePiece;
		this.p1removePiece = p1removePiece;
        this.p2movedpiece = p2movedpiece;
        this.p1movedpiece = p1movedpiece;
	}

}
