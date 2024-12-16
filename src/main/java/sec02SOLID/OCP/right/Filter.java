package sec02SOLID.OCP.right;

import java.util.List;
import java.util.stream.Stream;

public interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}
