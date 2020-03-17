package com.thallgames.catchthemouse.actors;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall extends GameObject {

	public Wall(int x, int y) {
		super(x, y);
		objectType = ObjectType.WALL;
	}

	public Wall() {
		super();
		objectType = ObjectType.WALL;
	}

	@Override
	protected Image loadImage() {
		try {
			return ImageIO.read(this.getClass().getResource("wall.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
