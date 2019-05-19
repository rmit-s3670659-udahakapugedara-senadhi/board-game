package oosd.helpers;

import oosd.models.board.Board;

public class SmallBoardCreator extends BoardCreator {

	public SmallBoardCreator() {
		super(6,6);
		super.getBoard().getPiece(0, 0).setUnit(super.getunitCreator().makeGISoldier());
		super.getBoard().getPiece(1, 0).setUnit(super.getunitCreator().makeGISoldier());
		super.getBoard().getPiece(2, 0).setUnit(super.getunitCreator().makeGrizzlyTank());
		super.getBoard().getPiece(3, 0).setUnit(super.getunitCreator().makeGrizzlyTank());
		super.getBoard().getPiece(4, 0).setUnit(super.getunitCreator().makeHarrier());
		super.getBoard().getPiece(5, 0).setUnit(super.getunitCreator().makeHarrier());
      
		super.getBoard().getPiece(0, 5).setUnit(super.getunitCreator().makeRhinoTank());
		super.getBoard().getPiece(1, 5).setUnit(super.getunitCreator().makeRhinoTank());
		super.getBoard().getPiece(2, 5).setUnit(super.getunitCreator().makeKirovAirshipk());
		super.getBoard().getPiece(3, 5).setUnit(super.getunitCreator().makeKirovAirshipk());
		super.getBoard().getPiece(4, 5).setUnit(super.getunitCreator().makeConscript());
        super.getBoard().getPiece(5, 5).setUnit(super.getunitCreator().makeConscript());
	}

}
