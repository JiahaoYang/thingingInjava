package fifteen;

@FunctionalInterface
public interface Generator<T> {
	T next();
}
