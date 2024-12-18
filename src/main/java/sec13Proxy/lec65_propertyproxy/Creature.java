package sec13Proxy.lec65_propertyproxy;

// idea of property proxy is to replace the normal fields with special construct which allows you more control on those

import java.util.Objects;

class Property<T> {
    private T value;

    public Property(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        // you can perform logging
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Property<?> property = (Property<?>) o;
        return Objects.equals(value, property.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}


class Creature {
/*    private int agility;

    public Creature() {

    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }*/

    private Property<Integer> agility = new Property<>(10);

    public void setAgility(int value) {
        agility.setValue(value);
    }

    public int getAgility() {
        return agility.getValue();
    }
}


class Demo {
    public static void main(String[] args) {
        Creature creature = new Creature();
        creature.setAgility(12);
    }
}