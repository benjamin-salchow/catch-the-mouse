# Catch the Mouse - Mogli and Marie edition

This is a game that is used for education purposes. This allows to learn Java and object oriented programming within a game.

## Import

This game can easily be imported as an Eclipse project.

## How to play

Use the `StartClass` in `src/com/thallgames/catchthemouse/start/StartClass.java` to start the game and define all actions in the game.

To win the game you need to move the cat to the target (mouse). You will win the game if you reach the mouse. If you ran out of the map or with a collision of a wall, the game will be over.

### Select a cat

There are Mogli and Marie who can be played in this game:
```java
// Select a cat:
// Mogli cat = new Mogli();
Marie cat = new Marie();
```
### Select a level

There are currently 6 level available in the game. You just need to increase the number of the `LevelId.Level1` up to `LevelId.Level6`.

```java
// Select a level:
LevelID levelId = LevelID.Level1;
```

### Play the game

Use the following commands to solve the level by moving the cat in a direction.

To avoid collision, it's possible to run a check to test if a movement can be done.


```java
/*
 * Move the cat: cat.moveUp(); cat.moveRight(); cat.moveDown(); cat.moveLeft();
 */

/*
 * Check if the cat can move: cat.canMoveUp(); cat.canMoveRight();
 * cat.canMoveDown(); cat.canMoveLeft();
 */
```


+