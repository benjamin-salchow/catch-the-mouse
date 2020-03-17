package com.thallgames.catchthemouse.cats;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Marie extends Cat {

	public Marie(int x, int y) {
		super(x, y);
	}

	public Marie() {
		super();
	}

	@Override
	protected Image loadImage() {
		try {
			return ImageIO.read(this.getClass().getResource("marie.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
