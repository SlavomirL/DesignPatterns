package sec02SOLID.OCP.right;

public interface Specification<T> {
    boolean isSatisfied(T item);
}
