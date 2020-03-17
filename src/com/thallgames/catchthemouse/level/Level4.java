package com.thallgames.catchthemouse.level;

import com.thallgames.catchthemouse.actors.ObjectType;
import com.thallgames.catchthemouse.actors.Target;
import com.thallgames.catchthemouse.actors.Wall;
import com.thallgames.catchthemouse.cats.Cat;

public class Level4 extends Level {

	public Level4(Cat cat) {
		super(cat, new Target(), new Wall(), LevelID.Level4);

		ObjectType[][] level1 = {
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.TARGET, ObjectType.WALL, ObjectType.WALL,
						ObjectType.WALL },
				{ ObjectType.FREE, ObjectType.WALL, ObjectType.WALL, ObjectType.WALL, ObjectType.WALL,
						ObjectType.WALL },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE,
						ObjectType.FREE },
				{ ObjectType.WALL, ObjectType.WALL, ObjectType.WALL, ObjectType.WALL, ObjectType.WALL,
						ObjectType.FREE },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.WALL, ObjectType.FREE,
						ObjectType.FREE },
				{ ObjectType.CAT, ObjectType.WALL, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE,
						ObjectType.WALL }, };
		level = level1;
		initalize();

	}

}
