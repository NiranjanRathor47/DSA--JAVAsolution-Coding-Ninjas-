package Vehicle;

public class Car4 extends Vehicle4 {
	int numGears;
	boolean isConvertible;
	
	public Car4(int numGears, int maxSpeed) {
		super(maxSpeed);
		this.numGears = numGears;
		System.out.println("Car Constructor");
	}
	
	public void print() {
		super.print();
		System.out.println("Car numGears : " + numGears);
		System.out.println("Car isConvertible : " + isConvertible);
	}
}

