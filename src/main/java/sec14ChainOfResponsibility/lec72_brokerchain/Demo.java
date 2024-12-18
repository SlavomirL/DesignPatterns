package sec14ChainOfResponsibility.lec72_brokerchain;

// in here we will be using chain of responsibility dp + observer dp + mediator dp + partially also memento dp

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class Event<Args> {
    private int index = 0;
    private Map<Integer, Consumer<Args>> handlers = new HashMap<>();

    public int subscribe(Consumer<Args> handler) {
        int i = index;
        handlers.put(index++, handler);
        return i;
    }

    public void unsubscribe(int key) {
        handlers.remove(key);
    }

    public void fire(Args args) {
        for (Consumer<Args> handler : handlers.values()) {
            handler.accept(args);
        }
    }
}


class Query {
    public String creatureName;
    enum Argument {
        ATTACK, DEFENSE
    }
    public Argument argument;
    public int result;

    public Query(String creatureName, Argument argument, int result) {
        this.argument = argument;
        this.creatureName = creatureName;
        this.result = result;
    }
}


class Game {
    public Event<Query> queries = new Event<>();
}


class Creature {
    private Game game;
    public String name;
    public int baseAttack, baseDefense;

    public Creature(Game game, String name, int baseAttack, int baseDefense) {
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.game = game;
        this.name = name;
    }

    int getAttack() {
        Query q = new Query(name, Query.Argument.ATTACK, baseAttack);
        game.queries.fire(q);
        return q.result;
    }

    int getDefense() {
        Query q = new Query(name, Query.Argument.DEFENSE, baseDefense);
        game.queries.fire(q);
        return q.result;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                "attack=" + getAttack() +
                ", defense=" + getDefense() +
                '}';
    }
}


class CreatureModifier {
    protected Game game;
    protected Creature creature;

    public CreatureModifier(Game game, Creature creature) {
        this.creature = creature;
        this.game = game;
    }
}


class IncreaseDefenseModifier extends CreatureModifier {
    public IncreaseDefenseModifier(Game game, Creature creature) {
        super(game, creature);

        game.queries.subscribe(q -> {
            if(q.creatureName.equals(creature.name) && q.argument == Query.Argument.DEFENSE) {
                q.result += 3;
            }
        });
    }
}


class DoubleAttackModifier extends CreatureModifier implements AutoCloseable {
    private final int token;

    public DoubleAttackModifier(Game game, Creature creature) {
        super(game, creature);
        token = game.queries.subscribe(q -> {
            if(q.creatureName.equals(creature.name) && q.argument == Query.Argument.ATTACK) {
                q.result *= 2;
            }
        });
    }

    @Override
    public void close() {
        game.queries.unsubscribe(token);
    }
}


class Demo {
    public static void main(String[] args) {
        Game game = new Game();
        Creature strongGoblin = new Creature(game, "Strong Goblin", 5, 5);
        System.out.println(strongGoblin);

        IncreaseDefenseModifier incDef = new IncreaseDefenseModifier(game, strongGoblin);
        DoubleAttackModifier doubleAtt = new DoubleAttackModifier(game, strongGoblin);
        try(doubleAtt) {
            System.out.println(strongGoblin);
            System.out.println("try with resources executed");
        }

        System.out.println(strongGoblin);

    }
}
