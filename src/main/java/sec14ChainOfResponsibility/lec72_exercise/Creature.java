package sec14ChainOfResponsibility.lec72_exercise;

import java.util.ArrayList;
import java.util.List;


/*
* You are given a game scenario with classes Goblin  and GoblinKing . Please implement the following rules:

A goblin has base 1 attack/1 defense (1/1), a goblin king is 3/3.
When the Goblin King is in play, every other goblin gets +1 Attack.
Goblins get +1 to Defense for every other Goblin in play (a GoblinKing is a Goblin!).
Example:

Suppose you have 3 ordinary goblins in play. Each one is a 1/3 (1/1 + 0/2 defense bonus).
A goblin king comes into play. Now every goblin is a 2/4 (1/1 + 0/3 defense bonus from each other + 1/0 from goblin king)
The state of all the goblins has to be consistent as goblins are added and removed from the game.

Here is an example of the kind of test that will be run on the system:

@Test
public void Test()
{
  Game game = new Game();
  Game goblin = new Goblin(game);
  game.creatures.add(goblin);
  assertEquals(1, goblin.getAttack());
  assertEquals(1, goblin.getDefense);
}
*
*
* */

abstract class Creature
{
    public abstract int getAttack();
    public abstract int getDefense();
}

class Goblin extends Creature
{
    public Goblin(Game game)
    {
        // todo
    }

    @Override
    public int getAttack()
    {
        // todo
    }

    @Override
    public int getDefense()
    {
        // todo
    }
}

class GoblinKing extends Goblin
{
    public GoblinKing(Game game)
    {
        // todo
    }
}

enum Statistic
{
    ATTACK, DEFENSE
}

class Game
{
    public List<Creature> creatures = new ArrayList<>();
}