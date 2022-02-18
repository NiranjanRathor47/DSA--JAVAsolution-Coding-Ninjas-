package Vehicle;
// Inheritance and Private Members
public class Vehicle2 {
	String color;
	private int maxSpeed;
	
	public int getmaxspeed() {
		return maxSpeed ;
	}
	public void setmaxspeed(int maxSpeed) {
	    this.maxSpeed = maxSpeed ;
	}
	
	public void print() {
		System.out.println("Vehicle color : " + color);
		System.out.println("Vehicle Speed : " + maxSpeed);
	}
}
