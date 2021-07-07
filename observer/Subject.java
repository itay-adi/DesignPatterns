package il.co.ilrd.observer;

public class Subject<T> {

	Dispatcher<T> dispatcher;

	//constructor
	public Subject() {
		dispatcher = new Dispatcher<>();
	}

	public void addSub(CallBack<T> cb) {
		dispatcher.registerCallback(cb);
	}

	public void removeSub(CallBack<T> cb) {
		dispatcher.unregister(cb);
	}

	public void notifySub(T message) {
		dispatcher.notifyCallbacks(message);
	}
	
	public void stopService() {
		dispatcher.stopService();
	}
}