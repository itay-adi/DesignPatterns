package il.co.ilrd.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class Observer<T>{

	Map<Subject<T>, CallBack<T>> myMap = new HashMap<>();

	public void subscribe(Subject<T> subject, Consumer<T> update, Runnable stop) {
		CallBack<T> cb = new CallBack<>(update, stop);
		myMap.put(subject, cb);
		subject.addSub(myMap.get(subject));
	}

	public void unsubscribe(Subject<T> subject) {
		myMap.get(subject).unregister();
	}
}