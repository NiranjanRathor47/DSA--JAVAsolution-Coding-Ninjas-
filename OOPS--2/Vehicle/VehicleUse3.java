package Vehicle;

public class VehicleUse3 {

	public static void main(String[] args) {
		Vehicle3 v = new Vehicle3();
		v.color = "Black";
		v.setMaxSpeed(10);
		v.print();
		
		Car3 c = new Car3();
		c.numGears = 44;
		c.color = "Black";
		c.setMaxSpeed(150);
		c.print();
	}

}
