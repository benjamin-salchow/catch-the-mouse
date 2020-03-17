package com.thallgames.catchthemouse.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.thallgames.catchthemouse.controller.Controller;
import com.thallgames.catchthemouse.level.Level;

public class JFancyGameDrawPanel extends JPanel {

	/**
	 * serialization
	 */
	private static final long serialVersionUID = -4035063325862174031L;
	private static final Color COLOR_OF_LINES = Color.DARK_GRAY;

	BufferedImage image;

	private int linesX, linesY;
	private Level level;
	private Controller controller;
	private boolean gameOver = false;
	private boolean gameWon = false;
	private boolean doCheck = false;
	private boolean checkUp = false;
	private boolean checkRight = false;
	private boolean checkLeft = false;
	private boolean checkDown = false;
	private boolean checkResult = false;
	private boolean checkResultPending = true;

	private int countdown = 0;

	public void setCountdown(int c) {
		countdown = c;
	}

	public JFancyGameDrawPanel(Level level, Controller controller) {
		super();
		linesX = level.getWidth();
		linesY = level.getHeight();
		this.level = level;
		this.controller = controller;
		controller.setFancyGameDrawPanel(this);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw horizontal lines
		int stepsY = this.getSize().height / linesY;
		for (int i = 0; i < linesY; i++) {
			g.setColor(COLOR_OF_LINES);
			g.drawLine(0, i * stepsY, this.getSize().width, i * stepsY);
		}
		// draw vertical lines
		int stepsX = this.getSize().width / linesX;
		for (int i = 0; i < linesX; i++) {
			g.setColor(COLOR_OF_LINES);
			g.drawLine(i * stepsX, 0, i * stepsX, this.getSize().height);
		}

		// calculate image size:
		int imagesize = Math.min(stepsX, stepsY);

		// draw level
		for (int y = 0; y < level.getHeight(); y++) {
			for (int x = 0; x < level.getWidth(); x++) {
				switch (level.getlevel()[y][x]) {

				case TARGET:
					g.drawImage(level.getTarget().getImage(), x * stepsX, y * stepsY, imagesize, imagesize, null);
					break;
				case WALL:
					g.drawImage(level.getWall().getImage(), x * stepsX, y * stepsY, imagesize, imagesize, null);
					break;
				default:
					break;
				}
			}
		}

		// draw cat

		g.drawImage(level.getCat().getImage(), (int) (level.getCat().getFloatX() * stepsX),
				(int) (level.getCat().getFloatY() * stepsY), imagesize, imagesize, null);

		// draw check
		if (doCheck) {
			// handling color
			if (checkResultPending) {
				g.setColor(Color.GRAY);
			} else if (checkResult) {
				g.setColor(Color.GREEN);
			} else {
				g.setColor(Color.RED);
			}
			// show check direction
			if (checkUp) {
				g.fillRoundRect((int) (level.getCat().getFloatX() * stepsX),
						(int) (level.getCat().getFloatY() * stepsY), imagesize, imagesize / 6, 30, 30);
			} else if (checkDown) {
				g.fillRoundRect((int) (level.getCat().getFloatX() * stepsX),
						(int) (level.getCat().getFloatY() * stepsY + imagesize - imagesize / 6), imagesize,
						imagesize / 6, 30, 30);
			} else if (checkLeft) {
				g.fillRoundRect((int) (level.getCat().getFloatX() * stepsX),
						(int) (level.getCat().getFloatY() * stepsY), imagesize / 6, imagesize, 30, 30);
			} else if (checkRight) {
				g.fillRoundRect((int) (level.getCat().getFloatX() * stepsX + imagesize - imagesize / 6),
						(int) (level.getCat().getFloatY() * stepsY), imagesize / 6, imagesize, 30, 30);
			}
		}

		// draw countdown
		if (countdown > 0) {
			Font helvetica = new Font("Helvetica", Font.BOLD, 200);
			g.setFont(helvetica);
			g.setColor(Color.ORANGE);
			g.drawString("" + countdown, this.getSize().width / 2 - 70, this.getSize().height / 2 + 100);

		}

		// draw GameOver
		if (gameOver) {
			Font helvetica = new Font("Helvetica", Font.BOLD, 200);
			g.setFont(helvetica);
			g.setColor(Color.RED);
			g.drawString("GAME", 50, 250);
			g.drawString("OVER", 60, 500);
			Font helvetica2 = new Font("Helvetica", Font.BOLD, 100);
			g.setFont(helvetica2);
			g.drawString("Steps: " + controller.getSteps(), 60, 620);
		}

		// draw Game Won
		if (gameWon) {
			Font helvetica = new Font("Helvetica", Font.BOLD, 200);
			g.setFont(helvetica);
			g.setColor(Color.BLUE);
			g.drawString("YOU", 50, 250);
			g.drawString("WON", 60, 500);
			Font helvetica2 = new Font("Helvetica", Font.BOLD, 100);
			g.setFont(helvetica2);
			g.drawString("Steps: " + controller.getSteps(), 60, 620);
		}

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(700, 700);
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
		this.repaint();
	}

	public void setGameWon(boolean gameWon) {
		this.gameWon = gameWon;
		this.repaint();
	}

	public void doCheckUp() {
		doCheck = true;
		checkUp = true;
		checkDown = false;
		checkRight = false;
		checkLeft = false;
		checkResultPending = true;
	}

	public void doCheckDown() {
		doCheck = true;
		checkUp = false;
		checkDown = true;
		checkRight = false;
		checkLeft = false;
		checkResultPending = true;
	}

	public void doCheckRight() {
		doCheck = true;
		checkUp = false;
		checkDown = false;
		checkRight = true;
		checkLeft = false;
		checkResultPending = true;
	}

	public void doCheckLeft() {
		doCheck = true;
		checkUp = false;
		checkDown = false;
		checkRight = false;
		checkLeft = true;
		checkResultPending = true;
	}

	public void setCheckResult(boolean result) {
		checkResultPending = false;
		checkResult = result;
	}

	public void endCheck() {
		doCheck = false;
		checkUp = false;
		checkDown = false;
		checkRight = false;
		checkLeft = false;
		checkResultPending = true;
	}

}
