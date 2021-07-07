package il.co.ilrd.observer;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher<T> {
	private List<CallBack<T>> listCallBacks;

	public Dispatcher(){
		listCallBacks = new ArrayList<>();
	}

	public void registerCallback(CallBack<T> callback) {
		if(callback != null) {
			callback.setDispatcher(this);
			listCallBacks.add(callback);
		} else {
			throw new NullPointerException();
		}
	}

	public void unregister(CallBack<T> callback) {
		if(callback != null) {
			listCallBacks.remove(callback);
			callback.setDispatcher(null);
		} else {
			throw new NullPointerException();
		}
	}

	public void notifyCallbacks(T message) {
		for(CallBack<T> cb : listCallBacks) {
			cb.updateObs(message);
		}
	}

	public void stopService() {
		for(CallBack<T> cb : listCallBacks) {
			cb.stopObs();
			cb.setDispatcher(null);
		}

		listCallBacks.clear();
	}
}
