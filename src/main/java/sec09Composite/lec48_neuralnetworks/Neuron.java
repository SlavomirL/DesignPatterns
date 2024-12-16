package sec09Composite.lec48_neuralnetworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

interface SomeNeurons extends Iterable<Neuron> {

    // 2nd implementation
    default void connectTo(SomeNeurons other) {
        if (this == other) return;
        for (Neuron from : this) {
            for (Neuron to : other) {
                from.out.add(to);
                to.in.add(from);
            }
        }
    }
}


class Neuron implements SomeNeurons {

    public ArrayList<Neuron> in, out;

    @Override
    public Iterator<Neuron> iterator() {
        return Collections.singleton(this).iterator();
    }

    @Override
    public void forEach(Consumer<? super Neuron> action) {
        action.accept(this);
    }

    @Override
    public Spliterator<Neuron> spliterator() {
        return Collections.singleton(this).spliterator();
    }

/* 1st implementation of this method that cannot be used n the code in main()
    public void connectTo(Neuron other) {
        out.add(other);
        other.in.add(this);
    }*/
}


// NeuronLayer already inherits from ArrayList of Neurons, so no need to implement methods coming from SomeNeurons (that are coming from Iterable)
class NeuronLayer extends ArrayList<Neuron> implements SomeNeurons {

}


class Demo {
    public static void main(String[] args) {
        Neuron neuron = new Neuron();
        Neuron neuron2 = new Neuron();

        NeuronLayer layer = new NeuronLayer();
        NeuronLayer layer2 = new NeuronLayer();


/*        // we cannot do this if we used the 1st implementation of connectTo() method, but its possible with the 2nd
        neuron.connectTo(neuron2);
        neuron.connectTo(layer);
        layer.connectTo(neuron);
        layer.connectTo(layer2);
        */

    }
}
