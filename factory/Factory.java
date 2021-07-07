package il.co.ilrd.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class Factory<K, T, D> {
	private Map<K, Function<D,? extends T>> ctorMapings = new HashMap<>();

	public void add(K key, Function<D,? extends T> constructor) {
		ctorMapings.put(key, constructor);
	}

	public T create(K key) {
		return create(key, null);
	}

	public T create(K key, D data) {
		return ctorMapings.get(key).apply(data);
	}
}
