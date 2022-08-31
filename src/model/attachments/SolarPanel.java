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
		return Constants.SUN_ENERGY_MOMENT;
	}

	public void setEnergySupply(SunEnergy energySupply) {
		this.energySupply = energySupply;
	}
	
    public Energy supplyEnergy() {
    	
    	Energy energy;
    	
		switch(Constants.SUN_ENERGY_MOMENT) {
			case AFTERNOON:
			case RAINING:
				energy = new Energy((float)0.01); 
				break;
			case MORNING:
				energy = new Energy((float)0.02);
				break;
			case MIDDAY:		
			case SUNNY:
				energy = new Energy((float)0.03);
				break;		
			case NIGHT:
			default:
				energy = new Energy(0);
				break;		
		}
		return energy;
	}
}
