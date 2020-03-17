package com.thallgames.catchthemouse.start;

import com.thallgames.catchthemouse.cats.Marie;
import com.thallgames.catchthemouse.cats.Mogli;
import com.thallgames.catchthemouse.controller.Controller;
import com.thallgames.catchthemouse.level.LevelID;

public class StartClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Select cat:
		//Mogli cat = new Mogli();
		Marie cat = new Marie();

		// Select level:
		LevelID levelId = LevelID.Level1;

		Controller.startGame(cat, levelId);

		/*
		 * Bewegung: cat.moveUp(); cat.moveRight(); cat.moveDown(); cat.moveLeft();
		 */

		/*
		 * Prüfen: cat.canMoveUp(); cat.canMoveRight(); cat.canMoveDown();
		 * cat.canMoveLeft();
		 */


	}

}
