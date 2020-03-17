package com.thallgames.catchthemouse.ui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.thallgames.catchthemouse.controller.Controller;
import com.thallgames.catchthemouse.level.Level;

public class CatchTheMouseUi {

	final public static int MAX_COUNTDOWN = 3;

	private static Controller controller;

	public static void startUI(Level level, Controller controller) {
		CatchTheMouseUi.controller = controller;
		// TODO Auto-generated method stub
		JFrame meinFrame = new JFrame("Catch the mouse - Mogli & Marie Edition - Level " + level.getLevelNumber());
		/*
		 * Wir setzen die Breite und die Höhe unseres Fensters auf 200 Pixel
		 */
		meinFrame.setSize(800, 800);

		// Jpanel mit borderlayout anlegen
		JPanel panel = new JPanel(new BorderLayout());
		meinFrame.add(panel);

		panel.add(new JLabel("Catch The Mouse Mogli & Marie Edition - Level " + level.getLevelNumber()),
				BorderLayout.NORTH);

		JFancyGameDrawPanel fancyGameDrawPanel = new JFancyGameDrawPanel(level, controller);
		// fancyGameDrawPanel.setMinimumSize(new Dimension(600, 600));
		// fancyGameDrawPanel.setBorder(new LineBorder(Color.black));
		// panel.add(new JButton("Center"), BorderLayout.CENTER);
		panel.add(fancyGameDrawPanel, BorderLayout.CENTER);

		JLabel stepsLabel = new JLabel("Steps: " + controller.getSteps());
		panel.add(stepsLabel, BorderLayout.SOUTH);
		controller.setStepsLabel(stepsLabel);

		// Wir lassen unseren Frame anzeigen
		// meinFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		meinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		meinFrame.pack();
		meinFrame.setVisible(true);

		// Start Countdown
		for (int i = MAX_COUNTDOWN; i > 0; i--) {

			fancyGameDrawPanel.setCountdown(i);
			fancyGameDrawPanel.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		fancyGameDrawPanel.setCountdown(0);
		fancyGameDrawPanel.repaint();

	}

}
