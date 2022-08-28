package app;

import controller.AppController;

public class App {

	public static void main(String[] args) {
		initApp();
	}

	private static void initApp() {

		AppController controller = new AppController();
		controller.initController();
	}

}
