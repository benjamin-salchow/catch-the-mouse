package com.thallgames.catchthemouse.cats;

import com.thallgames.catchthemouse.actors.Direction;
import com.thallgames.catchthemouse.actors.GameObject;
import com.thallgames.catchthemouse.actors.ObjectType;
import com.thallgames.catchthemouse.controller.Controller;

public abstract class Cat extends GameObject {

	final private static int STEPS_PER_ANIMATION = 500;
	final private static int SLEEP_TIME_PER_ANIMATION = 1;

	float floatX, floatY;

	private Controller controller;

	/**
	 * Initialisiere Katze
	 * 
	 * @param x
	 * @param y
	 */
	public Cat(int x, int y) {
		super(x, y);
		objectType = ObjectType.CAT;
	}

	/**
	 * Initialisiere Katze
	 */
	public Cat() {
		super();
		objectType = ObjectType.CAT;
	}

	/**
	 * Bewegt die Katze ein Feld nach oben.
	 */
	public void moveUp() {
		doMove(posX, posX, posY, posY - 1);
	}

	/**
	 * Bewegt die Katze ein Feld nach unten.
	 */
	public void moveDown() {
		doMove(posX, posX, posY, posY + 1);
	}

	/**
	 * Bewegt die Katze ein Feld nach links.
	 */
	public void moveLeft() {
		doMove(posX, posX - 1, posY, posY);

	}

	/**
	 * Bewegt die Katze ein Feld nach rechts.
	 */
	public void moveRight() {
		doMove(posX, posX + 1, posY, posY);
	}

	/**
	 * Prüft, ob die Katze ein Feld nach oben gehen kann.
	 * 
	 * @return true, wenn es möglich ist.
	 */
	public boolean canMoveUp() {
		return controller.canMove(posX, posY - 1, Direction.Up);
	}

	/**
	 * Prüft, ob die Katze ein Feld nach unten gehen kann.
	 * 
	 * @return true, wenn es möglich ist.
	 */
	public boolean canMoveDown() {
		return controller.canMove(posX, posY + 1, Direction.Down);
	}

	/**
	 * Prüft, ob die Katze ein Feld nach links gehen kann.
	 * 
	 * @return true, wenn es möglich ist.
	 */
	public boolean canMoveLeft() {
		return controller.canMove(posX - 1, posY, Direction.Left);
	}

	/**
	 * Prüft, ob die Katze ein Feld nach rechts gehen kann.
	 * 
	 * @return true, wenn es möglich ist.
	 */
	public boolean canMoveRight() {
		return controller.canMove(posX + 1, posY, Direction.Right);
	}

	/**
	 * Only internal game use! Returns position as float.
	 * 
	 * @return float position of X
	 */
	public float getFloatX() {
		return floatX;
	}

	/**
	 * Only internal game use! Returns position as float.
	 * 
	 * @return float position of Y
	 */
	public float getFloatY() {
		return floatY;

	}

	/**
	 * Internal do move function
	 * 
	 * @param oldX old position of X
	 * @param newX new position of X
	 * @param oldY old position of Y
	 * @param newY old position of Y
	 */
	private void doMove(int oldX, int newX, int oldY, int newY) {

		if (controller.canMove()) {
			controller.doMove(newX, newY);
			floatX = oldX;
			floatY = oldY;

			System.out.println("move");

			// Collision checks!
			if (controller.isACollision(newX, newY)) {
				// There is a collision
				return;
			}

			// if okay, then move
			for (int i = 0; i < STEPS_PER_ANIMATION; i++) {
				// System.out.println("draw");
				if (newX < oldX) {
					// move left
					floatX = oldX - (1.0f / STEPS_PER_ANIMATION) * i;
				} else if (newX > oldX) {
					// move right
					floatX = oldX + (1.0f / STEPS_PER_ANIMATION) * i;
				} else if (newY < oldY) {
					// move down
					floatY = oldY - (1.0f / STEPS_PER_ANIMATION) * i;
				} else if (newY > oldY) {
					// move up
					floatY = oldY + (1.0f / STEPS_PER_ANIMATION) * i;
					// System.out.println(floatY);
				}
				if (controller != null) {
					controller.repaint();
				} else {
					System.err.println("Controller is null in Cat?!");
				}
				try {
					Thread.sleep(SLEEP_TIME_PER_ANIMATION);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			posX = newX;
			posY = newY;
		} else {
			// can't move
			System.out.println("Can't move!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Internal game use! Initalize the position for different levels.
	 */
	@Override
	public void initPos(int x, int y) {
		posX = x;
		posY = y;
		floatX = x;
		floatY = y;
	}

	/**
	 * Internal game use! Set the game controller for internal functions.
	 * 
	 * @param controller
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

}
