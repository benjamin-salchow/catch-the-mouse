package com.thallgames.catchthemouse.actors;

import java.awt.Image;

public abstract class GameObject {

	protected int posX, posY;
	protected Image image;
	public ObjectType objectType;

	public GameObject(int x, int y) {
		posX = x;
		posY = y;
		image = loadImage();
	}

	public GameObject() {
		posX = -1;
		posY = -1;
		image = loadImage();
	}

	public int getX() {
		return posX;
	}

	public int getY() {
		return posY;
	}

	public void initPos(int x, int y) {
		// System.out.println("StartPos: X="+x+" Y="+y + "
		// TYPE="+objectType.toString());
		posX = x;
		posY = y;
	}

	protected abstract Image loadImage();

	public Image getImage() {
		return image;
	}
}
