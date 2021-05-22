package il.co.ilrd.singleton;

public class SingletonTest {
	public static void main(String[] args) {
		Singleton1 sin1_1 = Singleton1.getInstance();
		Singleton1 sin1_2 = Singleton1.getInstance();
		Singleton2 sin2_1 = Singleton2.getInstance();
		Singleton2 sin2_2 = Singleton2.getInstance();
		Singleton3 sin3_1 = Singleton3.getInstance();
		Singleton3 sin3_2 = Singleton3.getInstance();
		Singleton4 sin4_1 = Singleton4.getInstance();
		Singleton4 sin4_2 = Singleton4.getInstance();
		Singleton5 sin5_1 = Singleton5.getSingleton();
		Singleton5 sin5_2 = Singleton5.getSingleton();
		Singleton6 sin6_1 = Singleton6.getInstance();
		Singleton6 sin6_2 = Singleton6.getInstance();
		Singleton7 sin7_1 = Singleton7.getInstance();
		Singleton7 sin7_2 = Singleton7.getInstance();
		Color red = Color.RED;
		Color red2 = Color.RED;

		System.out.println("1: " + (sin1_1 == sin1_2));
		System.out.println("2: " + (sin2_1 == sin2_2));
		System.out.println("3: " + (sin3_1 == sin3_2));
		System.out.println("4: " + (sin4_1 == sin4_2));
		System.out.println("5: " + (sin5_1 == sin5_2));
		System.out.println("6: " + (sin6_1 == sin6_2));
		System.out.println("7: " + (sin7_1 == sin7_2));
		System.out.println("8: " + (red == red2));

		sin1_1.i = 3;
		sin2_1.i = 3;
		sin3_1.i = 3;
		sin4_1.i = 3;
		sin5_1.i = 3;
		sin6_1.i = 3;
		sin7_1.i = 3;

		System.out.println("\n" +sin1_2.i);
		System.out.println(sin2_2.i);
		System.out.println(sin3_2.i);
		System.out.println(sin4_2.i);
		System.out.println(sin5_2.i);
		System.out.println(sin6_2.i);
		System.out.println(sin7_2.i);
	}	
}
