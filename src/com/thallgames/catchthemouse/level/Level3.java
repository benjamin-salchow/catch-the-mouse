package com.thallgames.catchthemouse.level;

import com.thallgames.catchthemouse.actors.ObjectType;
import com.thallgames.catchthemouse.actors.Target;
import com.thallgames.catchthemouse.actors.Wall;
import com.thallgames.catchthemouse.cats.Cat;

public class Level3 extends Level {

	public Level3(Cat cat) {
		super(cat, new Target(), new Wall(), LevelID.Level3);

		ObjectType[][] level1 = {
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE,
						ObjectType.TARGET },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.WALL, ObjectType.WALL, ObjectType.WALL,
						ObjectType.WALL },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE,
						ObjectType.FREE },
				{ ObjectType.WALL, ObjectType.WALL, ObjectType.WALL, ObjectType.WALL, ObjectType.FREE,
						ObjectType.FREE },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE,
						ObjectType.FREE },
				{ ObjectType.CAT, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE,
						ObjectType.FREE }, };
		level = level1;
		initalize();

	}

}
