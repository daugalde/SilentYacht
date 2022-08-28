package model.part;

import common.RevolutionsPerMinute;

public class Propeller {

	private RevolutionsPerMinute currentRotation = RevolutionsPerMinute.NONE;
	
	public Propeller() {
		System.out.println("Attacing New Propeller");
	}
	
	public void rotate(RevolutionsPerMinute rpm) {
		setCurrentRotation(rpm);
	}

	public RevolutionsPerMinute getCurrentRotation() {
		return currentRotation;
	}

	public void setCurrentRotation(RevolutionsPerMinute currentRotation) {
		this.currentRotation = currentRotation;
	}
}
