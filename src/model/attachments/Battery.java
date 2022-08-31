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
	
	public String chargeBattery(Energy energy) {
		float currentEnergyLevel = getEnergyCapacity() + energy.getValue();
		
		if(currentEnergyLevel > 100) {
			setEnergyCapacity(100);
			setIsCharging(false);
		}
		else {
			setEnergyCapacity(currentEnergyLevel);
		}
		return "charge battery";
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
				
				if( (getEnergyCapacity() - 0.01) < 100) {					
					setEnergyCapacity((float) (getEnergyCapacity() - 0.1));
					return new Energy ((float)0.01);
				}
				else {
					return new Energy (0);
				}
				
			case ENGINE_ACCELERATE_LOW:
				if( (getEnergyCapacity() - 0.02)< 100) {					
					setEnergyCapacity((float) (getEnergyCapacity() - 0.2));
					return new Energy ((float)0.02);
				}
				else {
					return new Energy (0);
				}
			case ENGINE_ACCELERATE_MID:
				if( (getEnergyCapacity() - 0.04)< 100) {
					setEnergyCapacity((float) (getEnergyCapacity() - 0.04));
					return new Energy ((float)0.04);
				}
				else {
					return new Energy (0);
				}
			case ENGINE_ACCELERATE_HIGH:
				if( (getEnergyCapacity() - 0.06)< 100) {
					setEnergyCapacity((float) (getEnergyCapacity() - 0.06));
					return new Energy ((float)0.06);
				}
				else {
					return new Energy (0);
				}
			default:
				return new Energy (0);			
		}
	}
}
