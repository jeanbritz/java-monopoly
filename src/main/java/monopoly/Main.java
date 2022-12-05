package monopoly;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;

import javax.swing.UIManager;

import monopoly.controller.Banker;
import monopoly.view.Frontend;

public class Main implements UncaughtExceptionHandler {
	private static Banker banker;
	private static Frontend fe;

	private Main() {

	}

	public void init() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			banker = new Banker();
			fe = new Frontend(banker);
		} catch (Exception e) {
			AppLogger.severe(e.getMessage(), e);
			Asset.showErrorMessage("Error has occurred, check the logs \n" + e.getMessage());
		}

		Thread bankerThread = new Thread(banker);
		bankerThread.setName("The Banker");
		bankerThread.start();

		// Start up frontend
		Thread feThread = new Thread(fe);
		feThread.setName("The Frontend");
		feThread.start();

		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	public static void main(String[] args) {
		if (Game.isDebugMode()) {
		printEnvironmentVariables();
		}
		Main g = new Main();
		g.init();

	}

	public static void printEnvironmentVariables() {
		Map<String,String> env = System.getenv();
		StringBuilder sb = new StringBuilder();
		sb.append("================================\n");
		sb.append("    Environmental Variables\n");
		sb.append("================================\n");
		for(String key : env.keySet()) {
			sb.append(key+"="+env.get(key)+'\n');
		}
		AppLogger.info(sb.toString());
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		AppLogger.severe("Thread [" + t.getName() + "] caused to throw an uncaught exception", e);
	}

}
