package il.co.ilrd.observer;

import java.util.function.Consumer;

public class CallBack<T> {
    private Dispatcher<T> dispatcher;
    Consumer<T> update;
    Runnable stop;
    
    public CallBack(Consumer<T> update, Runnable stop) {
    	this.update = update;
    	this.stop = stop;
    }
    
    public void stopObs(){
    	stop.run();
    }
    
    public void updateObs(T massege){
    	update.accept(massege);
    }
    
    public void setDispatcher(Dispatcher<T> dis) {
        dispatcher = dis;
    }
    
    public void unregister() {
    	dispatcher.unregister(this);
    	dispatcher = null;
    };
}
