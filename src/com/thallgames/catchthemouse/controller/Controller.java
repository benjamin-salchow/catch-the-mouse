package com.thallgames.catchthemouse.controller;

import javax.swing.JLabel;

import com.thallgames.catchthemouse.actors.Direction;
import com.thallgames.catchthemouse.cats.Cat;
import com.thallgames.catchthemouse.level.Level;
import com.thallgames.catchthemouse.level.LevelID;
import com.thallgames.catchthemouse.level.LevelSelector;
import com.thallgames.catchthemouse.ui.CatchTheMouseUi;
import com.thallgames.catchthemouse.ui.JFancyGameDrawPanel;

public class Controller {

	protected JFancyGameDrawPanel gameDrawPanel;
	protected JLabel stepsLabel;
	protected Level level;
	protected Cat cat;
	private static Controller instance;
	private boolean canMove = false;
	private int steps = 0;
	private int catX = 0;
	private int catY = 0;

	public static void startGame(Cat cat, LevelID levelID) {
		instance = new Controller(cat, levelID);
	}

	/**
	 * Singleton pattern - only the startGame method will create a instance.
	 * 
	 * @param cat
	 * @param levelID
	 */
	private Controller(Cat cat, LevelID levelID) {
		this.cat = cat;
		this.cat.setController(this);
		level = LevelSelector.getLevel(levelID, cat);
		CatchTheMouseUi.startUI(level, this);
		canMove = true;

	}

	public static Controller getInstance() {
		return instance;
	}

	public void repaint() {
		if (gameDrawPanel != null) {
			gameDrawPanel.repaint();
		} else {
			System.err.println("Can't redraw panel - It's null?!");
		}
	}

	public void setFancyGameDrawPanel(JFancyGameDrawPanel gameDrawPanel) {
		this.gameDrawPanel = gameDrawPanel;
	}

	public void doMove(int newX, int newY) {
		steps++;
		stepsLabel.setText("Steps: " + steps);
		catX = newX;
		catY = newY;

	}

	public boolean canMove(int xNew, int yNew, Direction direction) {
		if (canMove) {
			// System.out.println("xNew: " + xNew + " | yNew: " + yNew);
			boolean result;
			switch (direction) {
			case Up:
				gameDrawPanel.doCheckUp();
				break;
			case Down:
				gameDrawPanel.doCheckDown();
				break;
			case Left:
				gameDrawPanel.doCheckLeft();
				break;
			case Right:
				gameDrawPanel.doCheckRight();
				break;
			default:
				System.err.println("UNKNOWN DIRECTION");
			}

			gameDrawPanel.repaint();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (xNew < 0 || yNew < 0) {
				result = false;
			} else if (xNew >= level.getWidth() || yNew >= level.getHeight()) {
				result = false;
			} else {
				// System.out.println("check Walls");
				switch (level.getlevel()[yNew][xNew]) {
				case WALL:
					result = false;
					break;
				default:
					result = true;
				}
			}

			gameDrawPanel.setCheckResult(result);
			gameDrawPanel.repaint();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			gameDrawPanel.endCheck();
			gameDrawPanel.repaint();

			return result;
		}
		return false;
	}

	public boolean isACollision(int xNew, int yNew) {
		if (xNew < 0 || yNew < 0) {
			// Out of Map
			System.err.println("OUT OF MAP");
			gameDrawPanel.setGameOver(true);
			canMove = false;
			return true;
		} else if (xNew >= level.getWidth() || yNew >= level.getHeight()) {
			// Out of Map
			System.err.println("OUT OF MAP");
			gameDrawPanel.setGameOver(true);
			canMove = false;
			return true;
		}
		switch (level.getlevel()[yNew][xNew]) {
		case WALL: // collision with wall
			System.err.println("COLLISION WITH WALL");
			gameDrawPanel.setGameOver(true);
			canMove = false;
			return true;
		case TARGET: // WIN collision with Target
			// do win magic
			System.out.println("YOU WON!");
			gameDrawPanel.setGameWon(true);
			canMove = false;
			return false;
		default:
			return false;

		}

	}

	public boolean canMove() {
		return canMove;
	}

	public int getSteps() {
		return steps;
	}

	public void setStepsLabel(JLabel stepsLabel) {
		this.stepsLabel = stepsLabel;
	}

}
