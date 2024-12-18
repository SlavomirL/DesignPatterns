package sec14ChainOfResponsibility.lec70_methodchain;

class Creature {

    public String name;
    public int attack, defense;

    public Creature(String name, int attack, int defense)  {
        this.attack = attack;
        this.defense = defense;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }
}


class CreatureModifier {
    protected Creature creature;
    protected CreatureModifier next;

    public CreatureModifier(Creature creature) {
        this.creature = creature;
    }

    public void add(CreatureModifier cm) {
        if(next != null) {
            next.add(cm);
        } else {
            next = cm;
        }
    }

    public void handle() {
        if(next != null) {
            next.handle();
        }
    }
}


class DoubleAttackModifier extends CreatureModifier {

    public DoubleAttackModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        creature.attack *= 2;
        System.out.println("Doubling " + creature.name + "`s attack");
        super.handle();
    }
}


class IncreaseDefenseModifier extends CreatureModifier {

    public IncreaseDefenseModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        creature.defense += 3;
        System.out.println("Increasing " + creature.name + "`s defense");
        super.handle();
    }
}


class NoBonusesModifier extends CreatureModifier {
    public NoBonusesModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        // we are not calling super.handle() here
        System.out.println("No bonuses for you!~");
    }
}


class Demo {
    public static void main(String[] args) {
        Creature goblin = new Creature("Goblin", 2, 3);
        System.out.println(goblin);

        CreatureModifier root = new CreatureModifier(goblin);

        root.add(new NoBonusesModifier(goblin));

        System.out.println("Lets double goblins attack..");
        root.add(new DoubleAttackModifier(goblin));

        System.out.println("Lets increase goblins defense");
        root.add(new IncreaseDefenseModifier(goblin));

        root.handle();
        System.out.println(goblin);
    }
}