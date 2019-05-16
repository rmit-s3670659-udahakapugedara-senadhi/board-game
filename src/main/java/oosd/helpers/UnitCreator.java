package oosd.helpers;

import java.util.ArrayList;
import oosd.models.player.Player;
import oosd.models.units.Unit;
import oosd.models.units.allied.*;
import oosd.models.units.soviet.*;


/**
 * 
 * Design pattern: Prototype Creator Design pattern is adopted in this class for Unit Creation.
 * 
 * Reason - Since many instances of Unit type Objects are needed for the game, having a PrototypeCreator
 * method allows to rid the repetitive initialization of the same Unit type objects,
 * but rather clones the existing Unit objects and sends back to the Creator (Main.Java).
 * 
 * Directly Coupled Classes -   Main.java and Unit.java
 *.
 */

public class UnitCreator {
	
static ArrayList<Unit> Units = new ArrayList<Unit>();
	
	GISoldier gisoldier ;
	GrizzlyTank grizzlytank;
	Harrier harrier;
	
	Conscript conscript;
	KirovAirship kirovAirship;
	RhinoTank rhinoTank;


	
	public UnitCreator(Player allied, Player soviet) {
		this.gisoldier = new GISoldier(allied) ;
		this.grizzlytank= new GrizzlyTank(allied);
		this.harrier = new Harrier(allied);
		
		this.conscript = new Conscript(soviet);
		this.kirovAirship = new KirovAirship(soviet);
		this.rhinoTank = new RhinoTank(soviet);
	
	}
	
	public UnitCreator(GISoldier gisoldier,GrizzlyTank grizzlytank,Harrier harrier,Conscript conscript,KirovAirship kirovAirship,RhinoTank rhinoTank) {
		this.gisoldier = gisoldier;
		this.grizzlytank= grizzlytank;
		this.harrier = harrier;
		
		this.conscript = conscript;
		this.kirovAirship = kirovAirship;
		this.rhinoTank = rhinoTank;
	
	}
	
	
	
	//Creating Allied Units		
	public GISoldier makeGISoldier() {
		return gisoldier.clone();

	}
	
	public GrizzlyTank makeGrizzlyTank() {
		return grizzlytank.clone();

	}
	
	public Harrier makeHarrier() {
		return harrier.clone();

	}
	
	public Unit[] makeAlliedUnitset() {
		Unit allied[] = { gisoldier.clone(),grizzlytank.clone(),harrier.clone() };
		return allied;
		
	}
	
	
	
	//Creating Soviet Units	
	public Conscript makeConscript() {
		return conscript.clone();

	}
	
	public KirovAirship makeKirovAirshipk() {
		return kirovAirship.clone();

	}
	
	public RhinoTank makeRhinoTank() {
		return rhinoTank.clone();

	}
	
	public Unit[] makeSovietUnitset() {
		Unit allied[] = { conscript.clone(),kirovAirship.clone(),rhinoTank.clone() };
		return allied;
		
	}



}
