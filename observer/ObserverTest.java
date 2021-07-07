package il.co.ilrd.observer;

public class ObserverTest {

	public static void main(String[] args) {
		Subject<String> Maariv = new Subject<>();
		Subject<String> Yediot = new Subject<>();
		Observer<String> itay_observer = new Observer<>();
		Observer<String> ori_observer = new Observer<>();

		//Itay subscribes to both newspapers
		itay_observer.subscribe(Maariv,
				(str)->{System.out.println("itay: An update from Maariv: " + str);}
				,()-> System.out.println("itay: Maariv service has been stopped"));
		
		itay_observer.subscribe(Yediot,
				(str)->{System.out.println("itay: An update from Yediot: " + str);}
				,()-> System.out.println("itay: Yediot service has been stopped"));
		
		//Ori subscribes only to Maariv
		ori_observer.subscribe(Maariv,
				(str)->{System.out.println("Ori: an update from Maariv: " + str);}
				,()->System.out.println("Ori: Bye Bye forever :("));

		//Maariv Send message to their customers
		Maariv.notifySub("I'm The Machine");
		System.out.println("");
		
		//Maariv stop their service	
		Maariv.stopService();
		System.out.println("");
		
		//Itay disconnects from Yediot: no notification needed
		itay_observer.unsubscribe(Yediot);
		
		//Both Itay and Ori subscribe to Yediot
		itay_observer.subscribe(Yediot,
				(str)->{System.out.println("itay: An update from Yediot: " + str);}
				,()-> System.out.println("itay: Yediot service has been stopped"));
		ori_observer.subscribe(Yediot,
				(str)->{System.out.println("Ori: an update from Yediot: " + str);}
				,()->System.out.println("Ori: Bye Bye forever :("));
		
		//Yediot Send message to their customers
		Yediot.notifySub("Who's here?");
	}
}