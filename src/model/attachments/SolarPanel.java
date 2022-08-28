package model.attachments;

import common.BasePart;
import common.Constants;
import common.Energy;
import common.PartTypes;
import common.SunEnergy;
import model.yacht.Yacht;

public class SolarPanel extends BasePart {

	private Yacht yacht;
	
	private SunEnergy energySupply = Constants.SUN_ENERGY_MOMENT;
	
	private float width = 1000;

	private float height = 1000;

	public SolarPanel(Yacht yacht, PartTypes partType,int id) {
		super("SolarPanel Part", partType, id);
		this.yacht = yacht;
		System.out.println("SolarPanel Created");
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
	public SunEnergy getEnergySupply() {
		return energySupply;
	}

	public void setEnergySupply(SunEnergy energySupply) {
		this.energySupply = energySupply;
	}
	
    public Energy supplyEnergy() {
    	
    	Energy energy;
    	
		switch(energySupply) {
			case AFTERNOON:
			case RAINING:
				energy = new Energy((1/100)); 
				break;
			case MORNING:
				energy = new Energy((2/100));
				break;
			case MIDDAY:		
			case SUNNY:
				energy = new Energy((3/100));
				break;		
			case NIGHT:
			default:
				energy = new Energy(0);
				break;		
		}
		return energy;
	}
}
