package il.co.ilrd.singleton;

/*1. Classic Java Singleton pattern
 * 
 *   advantage: easy to understand
 *   			it ensures the singleton instances are created only when needed
 *   
 *   disadvantage: is not multiple thread-safe
 */

class Singleton1 {
	int i = 0;

	private static Singleton1 instance;
	private Singleton1 (){}

	public static Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}

		return instance;
	}
}

/*******************************************************/

//First way 

/*2. A thread-safe singleton pattern in java using Synchronization
 * 
 * 	 advantage: multiple thread-safe: only one thread can enter to the getInstance() method
 * 				lazy loading
 * 
 * 	 disadvantage: not efficient. synchronized methods can run up to 100 times slower than unsynchronized methods
 */

class Singleton2 {
	int i = 0;

	private static Singleton2 instance;

	private Singleton2() {}

	public synchronized static Singleton2 getInstance() {
		if(instance == null) {
			instance = new Singleton2();
		}

		return (instance);
	}
}

/*******************************************************/

class Singleton3 {
	int i = 0;

	private static Singleton3 instance;

	private Singleton3() {}

	public static Singleton3 getInstance() {
		if(instance == null) {
			synchronized(Singleton3.class) { 
				instance = new Singleton3();
			}
		}
		
		return instance;
	}
}

/*******************************************************/

class Singleton4 {
	int i = 0;

	private static Singleton4 instance;

	private Singleton4() {}

	public static Singleton4 getInstance() {
		if(instance == null) {
			synchronized(Singleton4.class) {
				if(instance == null) {
					instance = new Singleton4();
				}
			}
		}
		return instance;
	}
}

/*******************************************************/

//Third way 

/*5. Double-checked locking with volatile keyword
 * 
 * 	 advantage: The volatile prevents memory writes from being re-ordered,
 * 				making it impossible for other threads to read uninitialized fields
 * 				of your singleton through the singleton’s pointer.
 * 
 * 	 disadvantage: it is hard to understand and it is easy to make mistakes
 * 				   The compiler cannot optimize the volatile variable
 */

class Singleton5 {
	int i = 0;
	private volatile static Singleton5 instance;
	private Singleton5 (){}

	public static Singleton5 getSingleton() {
		if (instance == null) {
			synchronized (Singleton5.class) {
				if (instance == null) {       
					instance = new Singleton5();
				}
			}
		}
		return (instance);
	}
}

/*******************************************************/

//Second way 

/*6. Thread-safe but not lazy initialized 
 * 
 * 	 advantage: multiple thread-safe: only one thread can enter to the getInstance() method
 * 
 * 	 disadvantage: not lazy: The singleton object is created as soon as the class is loaded. 
 */

class Singleton6{
	int i = 0;

	//the variable will be created when the class is loaded 
	private static final Singleton6 instance = new Singleton6();

	private Singleton6(){}

	public static Singleton6 getInstance(){
		return (instance);
	}
}

/*******************************************************/

//Fourth way 

/*7. The ultimate Thread-safe and efficient singleton pattern in Java 
 * 
 * 	 advantage: lazy initialized, and multiple-thread safe
 * 
 * 	 disadvantage: ?
 */

class Singleton7 {
	int i = 0;

	private Singleton7(){}

	private static class SingletonHolder {
		public static Singleton7 instance = new Singleton7();
	}

	public static Singleton7 getInstance() {
		return (SingletonHolder.instance);
	}
}

/*******************************************************/

//Fifth way 

/*8. Using Enum: The best way to implement a thread safe Singleton Pattern in Java is using Enum 
 *   simple to use
 * */

enum Color {

	RED(1), GREEN(2), YELLOW(3);

	private int nCode;

	Color(int nCode) { 
		this.nCode = nCode;
	}

	@Override 
	public String toString() {
		return String.valueOf(this.nCode);
	}
}

/*******************************************************/

