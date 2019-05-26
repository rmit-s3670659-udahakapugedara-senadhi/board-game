package oosd.helpers;

import oosd.models.board.Board;

public class LargeBoardCreator extends BoardCreator {
	
	

	public LargeBoardCreator() {
		super(10,10);		
		super.getBoard().getPiece(0, 0).setUnit(super.getunitCreator().makeGISoldier());
		super.getBoard().getPiece(1, 0).setUnit(super.getunitCreator().makeGISoldier());
		super.getBoard().getPiece(2, 0).setUnit(super.getunitCreator().makeGrizzlyTank());
		super.getBoard().getPiece(3, 0).setUnit(super.getunitCreator().makeGrizzlyTank());
		super.getBoard().getPiece(4, 0).setUnit(super.getunitCreator().makeHarrier());
		super.getBoard().getPiece(5, 0).setUnit(super.getunitCreator().makeHarrier());
		super.getBoard().getPiece(6, 0).setUnit(super.getunitCreator().makeGrizzlyTank());
		super.getBoard().getPiece(7, 0).setUnit(super.getunitCreator().makeGrizzlyTank());
		super.getBoard().getPiece(8, 0).setUnit(super.getunitCreator().makeGISoldier());
        super.getBoard().getPiece(9, 0).setUnit(super.getunitCreator().makeGISoldier());
        super.getBoard().getPiece(0, 9).setUnit(super.getunitCreator().makeRhinoTank());
        super.getBoard().getPiece(1, 9).setUnit(super.getunitCreator().makeRhinoTank());
        super.getBoard().getPiece(2, 9).setUnit(super.getunitCreator().makeKirovAirshipk());
        super.getBoard().getPiece(3, 9).setUnit(super.getunitCreator().makeKirovAirshipk());
        super.getBoard().getPiece(4, 9).setUnit(super.getunitCreator().makeConscript());
        super.getBoard().getPiece(5, 9).setUnit(super.getunitCreator().makeConscript());
        super.getBoard().getPiece(6, 9).setUnit(super.getunitCreator().makeKirovAirshipk());
        super.getBoard().getPiece(7, 9).setUnit(super.getunitCreator().makeKirovAirshipk());
        super.getBoard().getPiece(8, 9).setUnit(super.getunitCreator().makeRhinoTank());
        super.getBoard().getPiece(9, 9).setUnit(super.getunitCreator().makeRhinoTank());	
	}

}
