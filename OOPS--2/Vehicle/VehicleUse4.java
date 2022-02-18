package Vehicle;

public class VehicleUse4 {
	public static void main(String[] args) {
		Vehicle4 v = new Vehicle4(55);
		v.color = "Black";
		v.setMaxSpeed(10);
		v.print();
		
		Car4 c = new Car4(10, 20);
		c.numGears = 10;
		c.color = "Black";
		c.setMaxSpeed(100);
	    c.print();
	}
}
