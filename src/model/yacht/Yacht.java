package model.yacht;

import java.util.ArrayList;
import common.BasePart;
import common.PartType;
import common.PartTypes;
import model.attachments.Battery;
import model.attachments.Dashboard;
import model.attachments.SolarPanel;
import model.part.Engine;

public class Yacht implements PartType {

	private ArrayList<BasePart> allYachtParts = new ArrayList<BasePart>();

	public ArrayList<BasePart> getAllYachtParts() {
		return allYachtParts;
	}

	public Yacht() {
		
	}

	@Override
	public void addPart(PartTypes partType, int quantity) {
		
		for (int i = 0; i < quantity; i++) {
			switch (partType) {
			    case ENGINE:
				       allYachtParts.add(new Engine(this, partType, allYachtParts.size() ));
				       break;
			    case SOLAR_PANEL:
				       allYachtParts.add(new SolarPanel(this,partType, allYachtParts.size()));
				       break;
			    case BATTERY:
				       allYachtParts.add(new Battery(this, partType,allYachtParts.size()));
				       break;
			    case YACHT_DASHBOARD:
					   allYachtParts.add(new Dashboard(this, partType, allYachtParts.size()));
					   break;
			    default:

			}
		}
	}
	
	public BasePart findPartById (int id) {
		return allYachtParts.get(id);
	}

}
