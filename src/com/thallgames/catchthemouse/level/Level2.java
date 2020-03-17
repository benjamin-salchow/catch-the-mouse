package com.thallgames.catchthemouse.level;

import com.thallgames.catchthemouse.actors.ObjectType;
import com.thallgames.catchthemouse.actors.Target;
import com.thallgames.catchthemouse.actors.Wall;
import com.thallgames.catchthemouse.cats.Cat;

public class Level2 extends Level {

	public Level2(Cat cat) {
		super(cat, new Target(), new Wall(), LevelID.Level2);

		ObjectType[][] level1 = {
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE,
						ObjectType.TARGET },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE,
						ObjectType.FREE },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE,
						ObjectType.FREE },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE,
						ObjectType.FREE },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE,
						ObjectType.FREE },
				{ ObjectType.CAT, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE, ObjectType.FREE,
						ObjectType.FREE }, };
		level = level1;
		initalize();

	}

}
