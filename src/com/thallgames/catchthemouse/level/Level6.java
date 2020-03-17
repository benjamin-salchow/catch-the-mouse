package com.thallgames.catchthemouse.level;

import com.thallgames.catchthemouse.actors.ObjectType;
import com.thallgames.catchthemouse.actors.Target;
import com.thallgames.catchthemouse.actors.Wall;
import com.thallgames.catchthemouse.cats.Cat;

public class Level6 extends Level {

	public Level6(Cat cat) {
		super(cat, new Target(), new Wall(), LevelID.Level6);

		ObjectType[][] level1 = {
				{ ObjectType.CAT, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.WALL, ObjectType.WALL,
						ObjectType.FREE, ObjectType.WALL, ObjectType.FREE },
				{ ObjectType.WALL, ObjectType.WALL, ObjectType.FREE, ObjectType.WALL, ObjectType.WALL, ObjectType.WALL,
						ObjectType.FREE, ObjectType.WALL, ObjectType.FREE },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.WALL, ObjectType.FREE, ObjectType.WALL,
						ObjectType.FREE, ObjectType.WALL, ObjectType.FREE },
				{ ObjectType.WALL, ObjectType.FREE, ObjectType.WALL, ObjectType.WALL, ObjectType.FREE, ObjectType.WALL,
						ObjectType.FREE, ObjectType.WALL, ObjectType.FREE },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.WALL,
						ObjectType.FREE, ObjectType.FREE, ObjectType.FREE },
				{ ObjectType.FREE, ObjectType.WALL, ObjectType.FREE, ObjectType.WALL, ObjectType.FREE, ObjectType.WALL,
						ObjectType.FREE, ObjectType.WALL, ObjectType.FREE },
				{ ObjectType.FREE, ObjectType.WALL, ObjectType.FREE, ObjectType.WALL, ObjectType.FREE, ObjectType.WALL,
						ObjectType.FREE, ObjectType.WALL, ObjectType.FREE },
				{ ObjectType.WALL, ObjectType.WALL, ObjectType.FREE, ObjectType.WALL, ObjectType.FREE, ObjectType.WALL,
						ObjectType.FREE, ObjectType.WALL, ObjectType.FREE },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.WALL, ObjectType.FREE, ObjectType.FREE,
						ObjectType.FREE, ObjectType.WALL, ObjectType.TARGET }, };
		level = level1;
		initalize();

	}

}
