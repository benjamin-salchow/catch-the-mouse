package com.thallgames.catchthemouse.level;

import com.thallgames.catchthemouse.actors.ObjectType;
import com.thallgames.catchthemouse.actors.Target;
import com.thallgames.catchthemouse.actors.Wall;
import com.thallgames.catchthemouse.cats.Cat;

public class Level1 extends Level {

	public Level1(Cat cat) {
		super(cat, new Target(), new Wall(), LevelID.Level1);

		ObjectType[][] level1 = { { ObjectType.FREE, ObjectType.FREE, ObjectType.TARGET },
				{ ObjectType.FREE, ObjectType.FREE, ObjectType.FREE },
				{ ObjectType.CAT, ObjectType.FREE, ObjectType.FREE }, };
		level = level1;
		initalize();

	}

}
