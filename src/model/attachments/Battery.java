package model.attachments;

import common.BasePart;
import common.Constants;
import common.Energy;
import common.EnergyFor;
import common.PartTypes;
import model.yacht.Yacht;

public class Battery extends BasePart {
	
	private Yacht yacht;
	
	// 0 to 100 %
	private float energyCapacity = Constants.LEVEL_BATTERY_CHARGE;
	
	private boolean isCharging = false;
	
	public Battery (Yacht yacht, PartTypes partType,int id) {
		super("Batery", partType, id);
		this.yacht = yacht;
		System.out.println("Battery Created");
	}

	public float getEnergyCapacity() {
		return energyCapacity;
	}

	private void setEnergyCapacity(float energyCapacity) {
		this.energyCapacity = energyCapacity;
	}
	
	public void chargeBattery(Energy energy) {
		float currentEnergyLevel = getEnergyCapacity() + energy.getValue();
		
		if(currentEnergyLevel > 100) {
			setEnergyCapacity(100);
			setIsCharging(false);
		}
		else {
			setEnergyCapacity(currentEnergyLevel);
		}
		
	}

	public boolean getIsCharging() {
		return isCharging;
	}

	private void setIsCharging(boolean isCharging) {
		this.isCharging = isCharging;
	}
	
	public Energy supplyEnergy (EnergyFor energyFor) {		
		
		switch(energyFor){
			case ENGINE_START:
				if((getEnergyCapacity() - (1/100) ) < 0) {
					setEnergyCapacity(getEnergyCapacity() - (1/100));
					return new Energy ((1/100));
				}
				else {
					return new Energy (0);
				}
			case ENGINE_ACCELERATE_LOW:
				if((getEnergyCapacity() - (2/100) ) < 0) {
					setEnergyCapacity(getEnergyCapacity() - (2/100));
					return new Energy ((2/100));
				}
				else {
					return new Energy (0);
				}
			case ENGINE_ACCELERATE_MID:
				if((getEnergyCapacity() - (4/100) ) < 0) {
					setEnergyCapacity(getEnergyCapacity() - (4/100));
					return new Energy ((4/100));
				}
				else {
					return new Energy (0);
				}
			case ENGINE_ACCELERATE_HIGH:
				if((getEnergyCapacity() - (6/100) ) < 0) {
					setEnergyCapacity(getEnergyCapacity() - (6/100));
					return new Energy ((6/100));
				}
				else {
					return new Energy (0);
				}
			default:
				return new Energy (0);			
		}
	}
}
