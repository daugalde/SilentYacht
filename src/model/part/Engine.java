package model.part;

import java.util.ArrayList;

import common.BasePart;
import common.Energy;
import common.PartTypes;
import common.RevolutionsPerMinute;
import model.yacht.Yacht;

public class Engine extends BasePart {
	
	private int velocity = 0;
		
	private RevolutionsPerMinute currentRevolutionStatus;
	
	private float width = 1000;

	private float height = 1000;
	
	private boolean isStarted;
	
	private ArrayList<Propeller> propellers = new ArrayList<Propeller> ();
	
	private Yacht yacht;

	public Engine(Yacht yacht, PartTypes partType,int id) {
		super("Engine Part",partType, id);
		this.yacht= yacht;
		attachPropellersToBlock();
		System.out.println("Engine Created");
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

	public ArrayList<Propeller> getPropellers() {
		return propellers;
	}
	
	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public RevolutionsPerMinute getCurrentRevolutionStatus() {
		return currentRevolutionStatus;
	}

	public void setCurrentRevolutionStatus(RevolutionsPerMinute currentRevolutionStatus) {
		this.currentRevolutionStatus = currentRevolutionStatus;
	}
	
	private void attachPropellersToBlock() {
		propellers.add(new Propeller());
		propellers.add(new Propeller());
	}
	
	private void startPropeller() {
		for (int i = 0; i < propellers.size(); i++) {
			propellers.get(i).rotate(getCurrentRevolutionStatus());
		}
	}
	
	public boolean start(Energy energy) {
		
		if(!isStarted()) {
			setStarted(true);
		}

		setEngineVelocity (energy);
		
		return isStarted();
	}
	
	public boolean stop() {
		setStarted(false);
		setEngineVelocity (new Energy (0));
		return isStarted();
	}
	
	public void accelerateOrSlowDown(Energy energy) {
		
		if(isStarted()) {
			setEngineVelocity (energy);		
		}
		else {
			setEngineVelocity (new Energy(0));	
		}
	}
	
	private void setEngineVelocity (Energy energy) {
		if (energy.getValue() == 0) {
			setCurrentRevolutionStatus(RevolutionsPerMinute.NONE);
			setStarted(false);
			setAccelerating(false);
		}else if(energy.getValue()  <= 0.01 ) {
			setAccelerating(true);
			setCurrentRevolutionStatus(RevolutionsPerMinute.START);
			startPropeller();
		} else if(energy.getValue()  <= 0.02) {
			setAccelerating(true);
			setCurrentRevolutionStatus(RevolutionsPerMinute.LOW);
			startPropeller();
		}else if(energy.getValue()  <= 0.04) {
			setAccelerating(true);
			setCurrentRevolutionStatus(RevolutionsPerMinute.MEDIUM);
			startPropeller();
		}if(energy.getValue()  <= 0.06) {
			setAccelerating(true);
			setCurrentRevolutionStatus(RevolutionsPerMinute.MAX);
			startPropeller();
		}
	}

	public Yacht getYacht() {
		return yacht;
	}

	public void setYacht(Yacht yacht) {
		this.yacht = yacht;
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}

	
	public boolean isAccelerating() {
		return currentRevolutionStatus != RevolutionsPerMinute.START && currentRevolutionStatus != RevolutionsPerMinute.NONE ;
	}
	

	public void setAccelerating(boolean isAccelerating) {
	}

}
