package Vehicle_ProtectedorSuper;

import Vehicle.Vehicle3;

public class Truck extends Vehicle3 {
	int maxLoadingCapacity;
	public void print() {
		System.out.println("Truck Capacity : " + maxLoadingCapacity);
		System.out.println("Truck color :  " + color);
		System.out.println("Truck Speed : " + getMaxSpeed());
	}
}
