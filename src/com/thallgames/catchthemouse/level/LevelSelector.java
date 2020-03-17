package com.thallgames.catchthemouse.level;

import com.thallgames.catchthemouse.cats.Cat;

public class LevelSelector {

	public static Level getLevel(LevelID levelID, Cat cat) {
		switch (levelID) {
		case Level1:
			return new Level1(cat);
		case Level2:
			return new Level2(cat);
		case Level3:
			return new Level3(cat);
		case Level4:
			return new Level4(cat);
		case Level5:
			return new Level5(cat);
		case Level6:
			return new Level6(cat);
		default:
			return null;
		}
	}

}
