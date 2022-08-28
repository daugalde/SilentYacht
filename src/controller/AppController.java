package controller;

import javax.swing.JOptionPane;

import common.Constants;
import common.PartTypes;
import model.app.AppModel;
import model.attachments.Dashboard;
import model.yacht.Yacht;
import view.AppView;

public class AppController {

	private AppModel model;

	private AppView view;

	private Yacht yacht;

	public AppController() {
		this.model = new AppModel();
		this.view = new AppView("Silent Yatch");
	}

	public AppController(AppModel model, AppView view) {
		this.setModel(model);
		this.setView(view);
	}

	public AppModel getModel() {
		return model;
	}

	public void setModel(AppModel model) {
		this.model = model;
	}

	public AppView getView() {
		return view;
	}

	public void setView(AppView view) {
		this.view = view;
	}

	public void initController() {
		// Light Dependency Injection
		yacht = new Yacht();
		
		//This can be enhanced by Adding a Configuration File for future
		yacht.addPart(PartTypes.ENGINE, Constants.MAX_ENGINE_QUANTITY);
		yacht.addPart(PartTypes.SOLAR_PANEL, Constants.MAX_PANEL_QUANTITY);
		yacht.addPart(PartTypes.BATTERY, Constants.MAX_BATTERY_QUANTITY);
		yacht.addPart(PartTypes.YACHT_DASHBOARD, Constants.MAX_YACHT_DASHBOARD_QUANTITY);
		
		addEventListeners();
		
	}
	
	public void addEventListeners() {
		
		view.getSimulateBtn().addActionListener(e -> startSimulation());
	}
	
	private void startSimulation() {
		JOptionPane.showMessageDialog(null,"Simulacion Iniciada");
		Dashboard dash = (Dashboard)yacht.FindPartById(6);
		
		dash.run();
		//Start timer for 90 seconds
	}
 
}
