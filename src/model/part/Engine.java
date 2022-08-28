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
	
	public void start(Energy energy) {
		System.out.println("Here is starting engine" + energy.getValue());
		setEngineVelocity (energy);
	}
	
	public void accelerateOrSlowDown(Energy energy) {
		System.out.println("Here is starting engine" + energy.getValue());
		setEngineVelocity (energy);		
	}
	
	private void setEngineVelocity (Energy energy) {
		if(0 < energy.getValue() && energy.getValue()  <= 0.01 ) {
			setCurrentRevolutionStatus(RevolutionsPerMinute.START);
			startPropeller();
		} else if(energy.getValue()  <= 0.02) {
			setCurrentRevolutionStatus(RevolutionsPerMinute.LOW);
			startPropeller();
		}else if(energy.getValue()  <= 0.04) {
			setCurrentRevolutionStatus(RevolutionsPerMinute.MEDIUM);
			startPropeller();
		}if(energy.getValue()  <= 0.06) {
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

}
