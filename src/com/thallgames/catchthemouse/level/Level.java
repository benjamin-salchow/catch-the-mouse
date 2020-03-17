package com.thallgames.catchthemouse.level;

import com.thallgames.catchthemouse.actors.ObjectType;
import com.thallgames.catchthemouse.actors.Target;
import com.thallgames.catchthemouse.actors.Wall;
import com.thallgames.catchthemouse.cats.Cat;

public abstract class Level {

	protected Cat cat;
	protected Target target;
	protected Wall wall;
	protected LevelID levelId;

	protected ObjectType[][] level;

	public Level(Cat cat, Target target, Wall wall, LevelID levelId) {
		this.levelId = levelId;
		this.cat = cat;
		this.target = target;
		this.wall = wall;
	}

	protected void initalize() {
		for (int y = 0; y < level.length; y++) {
			for (int x = 0; x < level[y].length; x++) {
				switch (level[y][x]) {
				case CAT:
					cat.initPos(x, y);
					break;
				case TARGET:
					target.initPos(x, y);
					break;
				default:
					break;
				}
			}
		}

	}

	public int getHeight() {
		return level.length;
	}

	public int getWidth() {
		return level[0].length;
	}

	public ObjectType[][] getlevel() {
		return level;
	}

	public Cat getCat() {
		return cat;
	}

	public Target getTarget() {
		return target;
	}

	public Wall getWall() {
		return wall;
	}

	public LevelID getLevelId() {
		return levelId;
	}

	public int getLevelNumber() {
		return levelId.ordinal() + 1;
	}

}
