package oosd.helpers;

import oosd.models.board.Board;

public class MediumBoardCreator extends BoardCreator {

	public MediumBoardCreator() {
		super(8,8);
		super.getBoard().getPiece(0, 0).setUnit(super.getunitCreator().makeGISoldier());
		super.getBoard().getPiece(1, 0).setUnit(super.getunitCreator().makeGISoldier());
		super.getBoard().getPiece(2, 0).setUnit(super.getunitCreator().makeGrizzlyTank());
		super.getBoard().getPiece(3, 0).setUnit(super.getunitCreator().makeGrizzlyTank());
		super.getBoard().getPiece(4, 0).setUnit(super.getunitCreator().makeHarrier());
		super.getBoard().getPiece(5, 0).setUnit(super.getunitCreator().makeHarrier());
		super.getBoard().getPiece(6, 0).setUnit(super.getunitCreator().makeGrizzlyTank());
		super.getBoard().getPiece(7, 0).setUnit(super.getunitCreator().makeGrizzlyTank());
        
		super.getBoard().getPiece(0, 7).setUnit(super.getunitCreator().makeRhinoTank());
		super.getBoard().getPiece(1, 7).setUnit(super.getunitCreator().makeRhinoTank());
		super.getBoard().getPiece(2, 7).setUnit(super.getunitCreator().makeKirovAirshipk());
		super.getBoard().getPiece(3, 7).setUnit(super.getunitCreator().makeKirovAirshipk());
		super.getBoard().getPiece(4, 7).setUnit(super.getunitCreator().makeConscript());
		super.getBoard().getPiece(5, 7).setUnit(super.getunitCreator().makeConscript());
		super.getBoard().getPiece(6, 7).setUnit(super.getunitCreator().makeKirovAirshipk());
		super.getBoard().getPiece(7, 7).setUnit(super.getunitCreator().makeKirovAirshipk());
        	
	}

}
