package com.thallgames.catchthemouse.actors;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Target extends GameObject {

	public Target(int x, int y) {
		super(x, y);
		objectType = ObjectType.TARGET;
	}

	public Target() {
		super();
		objectType = ObjectType.TARGET;
	}

	@Override
	protected Image loadImage() {
		try {
			return ImageIO.read(this.getClass().getResource("maus.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
