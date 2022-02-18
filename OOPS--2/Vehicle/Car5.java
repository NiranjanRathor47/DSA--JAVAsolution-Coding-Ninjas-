package Vehicle;

public class Car5 extends Vehicle5 {
	int numGears;
	boolean isConvertible;
	
	public Car5(int numGears, int maxSpeed) {
		super(maxSpeed);
		this.numGears = numGears;
		System.out.println("Car Constructor");
	}
	
	public boolean isConvertible() {
		return isConvertible;
	}
	
	public void print() {
		super.print();
		System.out.println("Car numGears : " + numGears);
		System.out.println("Car isConvertible : " + isConvertible);
	}
}
