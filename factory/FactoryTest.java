package il.co.ilrd.factory;

import java.util.function.Function;

import il.co.ilrd.composite.Tree;

interface calc {
	int addition(int x);
}

public class FactoryTest {

	public static void main(String[] args) {
		Factory<String, Integer, Integer> myFactory = new Factory<>();
		Factory<String, Integer, B> myFactory2 = new Factory<>();

		//Lambda
		myFactory.add("Lambda", (x) -> (2 * x));
		System.out.println("Lambda:" + myFactory.create("Lambda", 5));
		
		//class A implements Function...
		myFactory.add("A_implements", new A());
		System.out.println("A_implements:" + myFactory.create("A_implements", 6));
		
		//Anonymous
		myFactory.add("Anonymous", new A(){
			public Integer apply(Integer num) {
	            return (num + 20);
	          }
	      });
		
		System.out.println("Anonymous:" + myFactory.create("Anonymous", 6));
		
		//static method of some class
		myFactory.add("static_method", B::foo);
		System.out.println("static_method:" + myFactory.create("static_method", 61));
		
		//instance method of an existing object
		B myB = new B();
		myFactory.add("instance_method", myB::goo);
		System.out.println("instance_method:" + myFactory.create("instance_method", 61));
		
		//Advanced: instance method of particular type
		myFactory2.add("Advenced",B::good);;
		System.out.println("Advenced:" + myFactory2.create("Advenced", myB));
		
		/*FactoryTree ftree = new FactoryTree("/home/itay/git/ds");
		ftree.printTree();*/
	}
}

class A implements Function<Integer ,Integer>{

	@Override
	public Integer apply(Integer num) {
		return (num + 3);
	}
}

class B{

	static public Integer foo(Integer num) {
		return (num + 500);
	}
	
	Integer goo(Integer num) {
		return (num - num);
	}
	
	Integer good() {
		return (852);
	}
}
