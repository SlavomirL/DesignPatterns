//package sec09Composite.lec48_exercise;
//
//import java.util.*;
//
///*
//*
//Composite Coding Exercise
//Consider the code presented below. The MyList.sum()  method adds up all the values in a list of ValueContainer  elements it gets passed. We can have a single value or a set of values.
//
//Complete the implementation of the interfaces so that sum()  begins to work correctly.
//*
//* */
//
//interface ValueContainer extends Iterable<Integer> {
//}
//
//
//class SingleValue implements ValueContainer {
//    public int value;
//
//    // please leave this constructor as-is
//    public SingleValue(int value) {
//        this.value = value;
//    }
//}
//
//
//class ManyValues extends ArrayList<Integer> implements ValueContainer {
//}
//
//
//class MyList extends ArrayList<ValueContainer> {
//    // please leave this constructor as-is
//    public MyList(Collection<? extends ValueContainer> c) {
//        super(c);
//    }
//
//    public int sum() {
//        // todo
//    }
//}