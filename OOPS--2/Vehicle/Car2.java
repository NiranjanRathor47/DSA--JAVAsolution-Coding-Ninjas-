package Vehicle;
// Inheritance and Private Members
public class Car2 extends Vehicle2 {
	
	boolean isConvertible;
	int numGears;
	
	public void print() {
		System.out.println("Car color : " + color);
		System.out.println("Car Speed : " + getmaxspeed());
		System.out.println("Car numGears : " + numGears);
		System.out.println("Car isConvertible : " + isConvertible);
	}
	
}
