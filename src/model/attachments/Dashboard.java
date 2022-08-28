package model.attachments;

import common.BasePart;
import common.Energy;
import common.EnergyFor;
import common.PartTypes;
import common.RevolutionsPerMinute;
import model.part.Engine;
import model.yacht.Yacht;

public class Dashboard extends BasePart implements Runnable{
	
	private Yacht yacht;
	
	private int velocity;
	
	private int energyLevel;
	
	public Dashboard (Yacht yacht, PartTypes partType,int id) {
		super("Dashboard Part", partType, id);
		this.yacht = yacht;
		System.out.println("Dashboard Created");
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public void startEngine() {
		
		Engine engine = ((Engine) getYachtPartByName(PartTypes.ENGINE,0));
		
        Energy energyFromBattery = ((Battery) getYachtPartByName(PartTypes.BATTERY,4)).supplyEnergy(EnergyFor.ENGINE_START);
		
		if(energyFromBattery.getValue() == 0 ) {
			energyFromBattery = ((Battery) getYachtPartByName(PartTypes.BATTERY,5)).supplyEnergy(EnergyFor.ENGINE_START);
		}
		
		engine.start(energyFromBattery);
		       
	}
	
	public void AccelerateOrSlowDownEngine(RevolutionsPerMinute rpm) {
		
		
		Engine engine = ((Engine) getYachtPartByName(PartTypes.ENGINE,0));
		
		RevolutionsPerMinute newRPM = getVelocityLevel (engine.getCurrentRevolutionStatus(), rpm);
		
		EnergyFor energyFor = getEnergyBYRPM(newRPM);
		
		Energy energyFromBattery = ((Battery) getYachtPartByName(PartTypes.BATTERY,4)).supplyEnergy(energyFor);
		
		if(energyFromBattery.getValue() == 0 ) {
			energyFromBattery = ((Battery) getYachtPartByName(PartTypes.BATTERY,5)).supplyEnergy(energyFor);
		}
		
		engine.accelerateOrSlowDown(energyFromBattery);
						
		engine.setCurrentRevolutionStatus(newRPM);
	}
	
	public void startChargingBatteriesFromSolarPanel () {
		Energy energy1 = ((SolarPanel) getYachtPartByName(PartTypes.SOLAR_PANEL,1)).supplyEnergy();
		Energy energy2 = ((SolarPanel) getYachtPartByName(PartTypes.SOLAR_PANEL,2)).supplyEnergy();
		Energy energy3 = ((SolarPanel) getYachtPartByName(PartTypes.SOLAR_PANEL,3)).supplyEnergy();
		
		float allEnergy = energy1.getValue() + energy2.getValue() + energy3.getValue();
		
		if(allEnergy > 0) {
			
			for(int i=0; i < yacht.getAllYachtParts().size() ; i++) {
				
				BasePart part = yacht.getAllYachtParts().get(i);
				
				if(part.getPartId() == PartTypes.BATTERY  ) {
					
					float energyToAdd = 100 - ((Battery)part).getEnergyCapacity() ;
					
					if(energyToAdd <= allEnergy && allEnergy > 0) {
						
						allEnergy -= energyToAdd;

						((Battery)part).chargeBattery(new Energy(energyToAdd));
					}
					
					
				}
			}
		}		
	}
	
	private BasePart getYachtPartByName(PartTypes partType, int id) {
		
		if(yacht.getAllYachtParts().get(id).getPartId() == partType) {
		    switch(partType) {
			case BATTERY:
				return (Battery)yacht.getAllYachtParts().get(id);
			case ENGINE:
				return (Engine)yacht.getAllYachtParts().get(id);
			case SOLAR_PANEL:
				return (SolarPanel)yacht.getAllYachtParts().get(id);
			case YACHT_DASHBOARD:
				return (Dashboard)yacht.getAllYachtParts().get(id);
			default:
				return null;
		    
		    }
		}
		return null;
	}
	
	private RevolutionsPerMinute getVelocityLevel (RevolutionsPerMinute currentVelocityLevel, RevolutionsPerMinute rpm) {
		int index = 0;
		
		int currentVelocityValue = 0;
		
		int rpmVelocityValue = 0;
		
		for (RevolutionsPerMinute level : RevolutionsPerMinute.values()) {
			if (level == rpm) {
				rpmVelocityValue = index;
			}	
			if (level == currentVelocityLevel) {
				currentVelocityValue = index;
			}
			index++;
		}
		
		return currentVelocityValue < rpmVelocityValue ? rpm :  currentVelocityLevel;
		
	}
	
	private EnergyFor getEnergyBYRPM (RevolutionsPerMinute rpm) {
		
		switch (rpm) {
		case LOW:
			return EnergyFor.ENGINE_START;
		case MAX:
			return EnergyFor.ENGINE_ACCELERATE_HIGH;
		case MEDIUM:
			return EnergyFor.ENGINE_ACCELERATE_MID;
		case NONE:
			 return EnergyFor.NONE;
		case START:
			return EnergyFor.ENGINE_START;
		default:
			return EnergyFor.NONE;		
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		startEngine();
	}
}
