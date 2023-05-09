package problems;

class Parent {

	{
		System.out.println("A");
	}
	
	static {
		System.out.println("B");
	}

}


public class Child extends Parent {

	{
		System.out.println("C");
	}
	
	static {
		System.out.println("D");
	}
	public static void main(String[] args) {
		Child child = new Child();
	}
	public static void main(char args) {
		Child child = new Child();
	}

}
