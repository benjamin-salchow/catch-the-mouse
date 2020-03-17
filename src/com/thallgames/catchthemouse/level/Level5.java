package com.thallgames.catchthemouse.level;

import com.thallgames.catchthemouse.actors.ObjectType;
import com.thallgames.catchthemouse.actors.Target;
import com.thallgames.catchthemouse.actors.Wall;
import com.thallgames.catchthemouse.cats.Cat;

public class Level5 extends Level {

	public Level5(Cat cat) {
		super(cat, new Target(), new Wall(), LevelID.Level5);

		ObjectType[][] level1 = {
				{ ObjectType.TARGET, ObjectType.FREE, ObjectType.FREE, ObjectType.WALL, ObjectType.FREE,
						ObjectType.WALL, ObjectType.WALL },
				{ ObjectType.WALL, ObjectType.WALL, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE,
						ObjectType.WALL },
				{ ObjectType.WALL, ObjectType.WALL, ObjectType.WALL, ObjectType.WALL, ObjectType.WALL, ObjectType.FREE,
						ObjectType.WALL },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.CAT, ObjectType.WALL, ObjectType.FREE,
						ObjectType.FREE },
				{ ObjectType.FREE, ObjectType.WALL, ObjectType.WALL, ObjectType.WALL, ObjectType.WALL, ObjectType.WALL,
						ObjectType.FREE },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.WALL, ObjectType.FREE, ObjectType.FREE,
						ObjectType.FREE },
				{ ObjectType.WALL, ObjectType.WALL, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.WALL,
						ObjectType.WALL }, };
		level = level1;
		initalize();

	}

}
