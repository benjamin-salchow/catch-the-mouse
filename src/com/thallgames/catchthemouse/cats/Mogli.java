package com.thallgames.catchthemouse.cats;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mogli extends Cat {

	public Mogli(int x, int y) {
		super(x, y);
	}

	public Mogli() {
		super();
	}

	@Override
	protected Image loadImage() {
		try {
			return ImageIO.read(this.getClass().getResource("mogli.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
