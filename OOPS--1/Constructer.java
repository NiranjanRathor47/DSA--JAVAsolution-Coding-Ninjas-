package classes_and_objects;

public class Constructer {
	 String name ;
	 private int rollnumber ;
	 
	 public Constructer(String n , int rn) {
		   name = n;
		   rollnumber = rn ;
	 }
	 public void print () {
		 System.out.println(name + " : " + rollnumber);
	 }
}
