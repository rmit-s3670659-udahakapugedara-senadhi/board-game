package oosd.models.units.allied;

import oosd.models.player.Player;
import oosd.models.units.Unit;
import oosd.models.units.behaviour.LinearUnitBehaviour;
import oosd.models.units.behaviour.UnitBehaviour;
import oosd.models.units.soviet.KirovAirship;
import oosd.models.units.soviet.RhinoTank;

import java.util.Arrays;
import java.util.List;

public class GISoldier extends Allied implements Cloneable {
    public GISoldier(Player player) {
        super(player);
    }

    public List<Class<? extends Unit>> getWinnables() {
        return Arrays.asList(KirovAirship.class, RhinoTank.class);
    }

    public String getName() {
        return "GI Soldier";
    }

    public String getImage() {
        return "gi_soldier";
    }

    public UnitBehaviour getUnitBehaviour() {
        return new LinearUnitBehaviour(2);
    }
    
    public GISoldier clone() {
    	GISoldier clone = null;
        try {
			clone = (GISoldier) super.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
        
        return clone;
      }
    
}
