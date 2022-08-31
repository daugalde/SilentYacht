package model.attachments;

import common.BasePart;
import common.Constants;
import common.Energy;
import common.EnergyFor;
import common.PartTypes;
import common.RevolutionsPerMinute;
import common.SunEnergy;
import model.part.Engine;
import model.yacht.Yacht;

public class Dashboard extends BasePart implements Runnable{
	
	private Yacht yacht;
	
	private int velocity;
	
	private int energyLevel;
	
	private boolean engineStarted;
	
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
	
	public boolean startEngine() {
		
		Engine engine = ((Engine) getYachtPartByName(PartTypes.ENGINE,0));		
		
        Energy energyFromBattery = ((Battery) getYachtPartByName(PartTypes.BATTERY,4)).supplyEnergy(EnergyFor.ENGINE_START);
        
        logUI ("Energy supplied by battery 1 \n"  + energyFromBattery.getValue());
        setBatteryLevel ( ((Battery) getYachtPartByName(PartTypes.BATTERY,4)).getEnergyCapacity(),1);
        logUI ("Current charge battery 1 \n"  + ((Battery) getYachtPartByName(PartTypes.BATTERY,4)).getEnergyCapacity());
        
        
		if(energyFromBattery.getValue() == 0 ) {
			energyFromBattery = ((Battery) getYachtPartByName(PartTypes.BATTERY,5)).supplyEnergy(EnergyFor.ENGINE_START);
			setBatteryLevel ( ((Battery) getYachtPartByName(PartTypes.BATTERY,4)).getEnergyCapacity(),2);
			logUI ("Energy supplied by battery 2  \n"  + energyFromBattery.getValue());
			logUI ("Current charge battery 1 \n"  + ((Battery) getYachtPartByName(PartTypes.BATTERY,4)).getEnergyCapacity());
		}
		
		boolean start =  engine.start(energyFromBattery);
		
		if(engine.isStarted()) {
			logUI ("Engine has started and running");
			setVelocityLevel (RevolutionsPerMinute.START);
		}
		
		return start;
	}
	
	public void AccelerateOrSlowDownEngine(RevolutionsPerMinute rpm) {
		
		
		Engine engine = ((Engine) getYachtPartByName(PartTypes.ENGINE,0));
		
		RevolutionsPerMinute newRPM = getVelocityLevel (engine.getCurrentRevolutionStatus(), rpm);
		
		setVelocityLevel (newRPM);
		logUI ("Engine Accelerating RPM"  + newRPM);
		
		EnergyFor energyFor = getEnergyBYRPM(newRPM);
		
		Energy energyFromBattery = ((Battery) getYachtPartByName(PartTypes.BATTERY,4)).supplyEnergy(energyFor);
		setBatteryLevel ( ((Battery) getYachtPartByName(PartTypes.BATTERY,4)).getEnergyCapacity(),1);
		logUI ("Energy from battery 1 consumed by Accelerating \n"  + energyFromBattery.getValue());
		
		if(energyFromBattery.getValue() == 0 ) {
			energyFromBattery = ((Battery) getYachtPartByName(PartTypes.BATTERY,5)).supplyEnergy(energyFor);
			setBatteryLevel ( ((Battery) getYachtPartByName(PartTypes.BATTERY,4)).getEnergyCapacity(),2);
			logUI ("Energy from battery 2 consumed by Accelerating \n"  + energyFromBattery.getValue());
		}
		
		engine.accelerateOrSlowDown(energyFromBattery);
						
		engine.setCurrentRevolutionStatus(newRPM);
	}
	
	public void startChargingBatteriesFromSolarPanel () {
		Energy energy1 = ((SolarPanel) getYachtPartByName(PartTypes.SOLAR_PANEL,1)).supplyEnergy();
		Energy energy2 = ((SolarPanel) getYachtPartByName(PartTypes.SOLAR_PANEL,2)).supplyEnergy();
		Energy energy3 = ((SolarPanel) getYachtPartByName(PartTypes.SOLAR_PANEL,3)).supplyEnergy();
		
		float allEnergy = energy1.getValue() + energy2.getValue() + energy3.getValue();
		logUI ("Supply Energy Panel 1 "  + Constants.SUN_ENERGY_MOMENT + energy1.getValue());
		logUI ("Supply Energy Panel 1 "  + Constants.SUN_ENERGY_MOMENT+ energy2.getValue());
		logUI ("Supply Energy Panel 1 "  + Constants.SUN_ENERGY_MOMENT+ energy3.getValue());
		if(allEnergy > 0) {
			
			for(int i=0; i < yacht.getAllYachtParts().size() ; i++) {
				
				BasePart part = yacht.getAllYachtParts().get(i);
				
				if(part.getPartId() == PartTypes.BATTERY  ) {
					
					float energyToAdd = ((Battery)part).getEnergyCapacity() + allEnergy  ;
					
					if(energyToAdd <= 100) {
						((Battery)part).chargeBattery(new Energy(energyToAdd));
						setBatteryLevel ( (((Battery)part)).getEnergyCapacity(),1);
						logUI ("battery current charge"  + ((Battery)part).getEnergyCapacity());
					}
					else if (energyToAdd >= 100){
						((Battery)part).chargeBattery(new Energy(100));	
						setBatteryLevel ( (((Battery)part)).getEnergyCapacity(),2);
						logUI ("battery current charge"  + ((Battery)part).getEnergyCapacity());
						energyToAdd = energyToAdd - 100;
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
		int periodTimeOption =  yacht.getView().getSimulationPeriod().getSelectedIndex() == 0 ? 60 : 90;
		for(int i = 0; i < periodTimeOption ; i++) {        	
			try {

				Thread.sleep(1000);
				
				logUI ( "Current Period Time in seconds" + i );
				
				if(i == 1) {
					Constants.SUN_ENERGY_MOMENT = SunEnergy.MORNING;
					setSunLevelView (SunEnergy.MORNING);
				}
								
				setEngineStarted(startEngine());
				
				if( i > 5 && i < 20) {
					AccelerateOrSlowDownEngine(RevolutionsPerMinute.LOW);
				}
				
				if(i > 20 && i < 25) {
					Constants.SUN_ENERGY_MOMENT = SunEnergy.SUNNY;
					setSunLevelView (SunEnergy.SUNNY);
					startChargingBatteriesFromSolarPanel ();
					AccelerateOrSlowDownEngine(RevolutionsPerMinute.MEDIUM);
				}
				
				if(i > 25 && i < 30) {
					Constants.SUN_ENERGY_MOMENT = SunEnergy.AFTERNOON;
					startChargingBatteriesFromSolarPanel ();
				}
				
				if(i > 30 && i < 60) {
					Constants.SUN_ENERGY_MOMENT = SunEnergy.NIGHT;
					startChargingBatteriesFromSolarPanel ();
				}
				
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
		
	}

	public boolean isEngineStarted() {
		return engineStarted;
	}

	public void setEngineStarted(boolean engineStarted) {
		this.engineStarted = engineStarted;
	}
	
	private void logUI ( String newLog) {
		String currentLogs = yacht.getView().getLoggerArea().getText();
		
	    yacht.getView().getLoggerArea().setText(newLog + "\n" + currentLogs );
	}
	
	private void setSunLevelView (SunEnergy sunLevel) {		
	    yacht.getView().getSunLevel().setText(sunLevel.toString());
	}
	
	private void setBatteryLevel (float level, int batteryId) {
		if(batteryId == 1) {
			yacht.getView().getBatteryLevel1().setValue((int)level);
		}
		else {
			yacht.getView().getBatteryLevel2().setValue((int)level);
		}
	}
	
	private void setVelocityLevel (RevolutionsPerMinute rpm) {
		yacht.getView().getYachtVelocity().setText(rpm.toString());
	}
}
