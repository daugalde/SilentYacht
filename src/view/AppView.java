package view;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;

public class AppView {

	private JFrame frame;
	private GroupLayout layout;
	private JButton simulateBtn;
	private JComboBox<String> simulationPeriod;
	private JLabel simulationPeriodLabel;
	private JLabel battery1Label;
	private JLabel battery2Label;
	private JLabel solarPanel1Label;
	private JLabel solarPanel2Label;
	private JLabel solarPanel3Label;
	private JLabel yachtVelocityLabel;
	private JLabel yachtVelocity;
	private JLabel sunLevelLabel;
	private JLabel sunLevel;
	private JLabel titleLabel;
	private JLabel eventsLabel;    
	private JPanel panel;
	private JProgressBar batteryLevel1;
	private JProgressBar batteryLevel2;
	private JScrollPane scrollPane;
	private JTextArea loggerArea;
	private JToggleButton panelCharger1;
	private JToggleButton panelCharger3;
	private JToggleButton panelCharger2;
		
	public AppView(String title) {
		initFrameSetup(title);
		initComponents ();
		bindComponents ();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public GroupLayout getLayout() {
		return layout;
	}

	public void setLayout(GroupLayout layout) {
		this.layout = layout;
	}

	public JButton getSimulateBtn() {
		return simulateBtn;
	}

	public void setSimulateBtn(JButton simulateBtn) {
		this.simulateBtn = simulateBtn;
	}

	public JComboBox<String> getSimulationPeriod() {
		return simulationPeriod;
	}

	public void setSimulationPeriod(JComboBox<String> simulationPeriod) {
		this.simulationPeriod = simulationPeriod;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}
	
	public JLabel getSimulationLabel() {
		return simulationPeriodLabel;
	}

	public void setSimulationLabel(JLabel simulationLabel) {
		this.simulationPeriodLabel = simulationLabel;
	}

	public JLabel getBattery1Label() {
		return battery1Label;
	}

	public void setBattery1Label(JLabel battery1Label) {
		this.battery1Label = battery1Label;
	}

	public JLabel getBattery2Label() {
		return battery2Label;
	}

	public void setBattery2Label(JLabel battery2Label) {
		this.battery2Label = battery2Label;
	}

	public JLabel getSolarPanel1Label() {
		return solarPanel1Label;
	}

	public void setSolarPanel1Label(JLabel solarPanel1Label) {
		this.solarPanel1Label = solarPanel1Label;
	}

	public JLabel getSolarPanel2Label() {
		return solarPanel2Label;
	}

	public void setSolarPanel2Label(JLabel solarPanel2Label) {
		this.solarPanel2Label = solarPanel2Label;
	}

	public JLabel getSolarPanel3Label() {
		return solarPanel3Label;
	}

	public void setSolarPanel3Label(JLabel solarPanel3Label) {
		this.solarPanel3Label = solarPanel3Label;
	}

	public JLabel getYachtVelocityLabel() {
		return yachtVelocityLabel;
	}

	public void setYachtVelocityLabel(JLabel yachtVelocityLabel) {
		this.yachtVelocityLabel = yachtVelocityLabel;
	}

	public JLabel getYachtVelocity() {
		return yachtVelocity;
	}

	public void setYachtVelocity(JLabel yachtVelocity) {
		this.yachtVelocity = yachtVelocity;
	}

	public JLabel getSunLevelLabel() {
		return sunLevelLabel;
	}

	public void setSunLevelLabel(JLabel sunLevelLabel) {
		this.sunLevelLabel = sunLevelLabel;
	}

	public JLabel getSunLevel() {
		return sunLevel;
	}

	public void setSunLevel(JLabel sunLevel) {
		this.sunLevel = sunLevel;
	}

	public JLabel getEventsLabel() {
		return eventsLabel;
	}

	public void setEventsLabel(JLabel eventsLabel) {
		this.eventsLabel = eventsLabel;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JProgressBar getBatteryLevel1() {
		return batteryLevel1;
	}

	public void setBatteryLevel1(JProgressBar batteryLevel1) {
		this.batteryLevel1 = batteryLevel1;
	}

	public JProgressBar getBatteryLevel2() {
		return batteryLevel2;
	}

	public void setBatteryLevel2(JProgressBar batteryLevel2) {
		this.batteryLevel2 = batteryLevel2;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JTextArea getLoggerArea() {
		return loggerArea;
	}

	public void setLoggerArea(JTextArea loggerArea) {
		this.loggerArea = loggerArea;
	}

	public JToggleButton getPanelCharger1() {
		return panelCharger1;
	}

	public void setPanelCharger1(JToggleButton panelCharger1) {
		this.panelCharger1 = panelCharger1;
	}

	public JToggleButton getPanelCharger3() {
		return panelCharger3;
	}

	public void setPanelCharger3(JToggleButton panelCharger3) {
		this.panelCharger3 = panelCharger3;
	}

	public JToggleButton getPanelCharger2() {
		return panelCharger2;
	}

	public void setPanelCharger2(JToggleButton panelCharger2) {
		this.panelCharger2 = panelCharger2;
	}

	private void initFrameSetup(String title) {
		frame = new JFrame(title);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1080, 920);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	private void initComponents () {
		
		simulationPeriodLabel  = new JLabel("Periodo de Simulacion");
		battery1Label = new JLabel("Bateria 1");
		battery2Label = new JLabel("Bateria 2");
		solarPanel1Label = new JLabel("Panel Solar 1");
		solarPanel2Label = new JLabel("Panel Solar 2");
		solarPanel3Label = new JLabel("Panel Solar 3");
		yachtVelocityLabel = new JLabel("Velocidad Yate en Nudos");
		yachtVelocity = new JLabel("0");
		sunLevelLabel = new JLabel("Nivel de Sol");
		sunLevel = new JLabel("0");
		titleLabel = new JLabel("Simulador Yate Dashboard ");
		eventsLabel = new JLabel("Eventos");
		panel = new JPanel();
		simulateBtn = new JButton("Iniciar Simulacion");
		batteryLevel1 = new JProgressBar  ();
		batteryLevel2 = new JProgressBar  ();
		scrollPane    = new JScrollPane   ();
		loggerArea    = new JTextArea     ();
		panelCharger1 = new JToggleButton ("ON");
		panelCharger2 = new JToggleButton ("ON");
		panelCharger3 = new JToggleButton ("ON");
		simulationPeriod = new JComboBox<>(new DefaultComboBoxModel<>(new String[] { "60 segundos", "90 Segundos" }));
	}
	
	private void initPanel () {
		GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
        		panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
        		panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
	}
	
	private void initProgressBars () {
		batteryLevel1.setValue(100);
		batteryLevel2.setValue(100);
		batteryLevel1.setStringPainted(true);
		batteryLevel2.setStringPainted(true);
	}
	
	private void initToggleBtns() {
		panelCharger1.setSelected(true);
		panelCharger2.setSelected(true);
		panelCharger3.setSelected(true);
	}
	
	private void bindComponents () {
		layout = new GroupLayout(frame.getContentPane());
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		initPanel();
		initProgressBars();
		initToggleBtns();
		scrollPane.setViewportView(loggerArea);
		layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(49, 49, 49)
	                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addGap(41, 41, 41)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                                .addGroup(layout.createSequentialGroup()
	                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                                        .addComponent(simulationPeriodLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(battery1Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(battery2Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(solarPanel1Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(solarPanel2Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(solarPanel3Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(yachtVelocityLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                        .addComponent(sunLevelLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                                            .addComponent(panelCharger1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
	                                            .addComponent(panelCharger2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
	                                            .addComponent(panelCharger3, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
	                                            .addComponent(batteryLevel1, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
	                                            .addComponent(batteryLevel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                            .addComponent(simulationPeriod, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                        .addComponent(yachtVelocity, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
	                                        .addComponent(sunLevel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
	                                .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                            .addComponent(simulateBtn))
	                        .addGap(0, 0, Short.MAX_VALUE))
	                    .addComponent(scrollPane)
	                    .addComponent(eventsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addContainerGap())
	        );
		
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(43, 43, 43)
	                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addGap(20, 20, 20)
	                .addComponent(titleLabel)
	                .addGap(43, 43, 43)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(simulationPeriodLabel)
	                    .addComponent(simulationPeriod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                    .addComponent(battery1Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(batteryLevel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                    .addComponent(battery2Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(batteryLevel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(solarPanel1Label)
	                    .addComponent(panelCharger1))
	                .addGap(14, 14, 14)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(panelCharger2)
	                    .addComponent(solarPanel2Label))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(solarPanel3Label)
	                    .addComponent(panelCharger3))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(yachtVelocityLabel)
	                    .addComponent(yachtVelocity))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(sunLevelLabel)
	                    .addComponent(sunLevel))
	                .addGap(44, 44, 44)
	                .addComponent(simulateBtn)
	                .addGap(26, 26, 26)
	                .addComponent(eventsLabel)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
	                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
	                .addGap(44, 44, 44))
	        );
		
		//layout.linkSize(SwingConstants.HORIZONTAL, simulationLabel, simulateBtn);
		frame.getContentPane().setLayout(layout);
	}

	

	
}
