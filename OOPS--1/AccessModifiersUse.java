package classes_and_objects;

import java.util.Scanner;

public class AccessModifiersUse {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		AccessModifiers s1 = new AccessModifiers() ;
		AccessModifiers s2 = new AccessModifiers() ;
		s1.name = "Niranjan";
		s1.setrollnum(-123);
		s2.name = "priyanshu";
		s2.setrollnum(45);
		System.out.println(s1.name);
		System.out.println(s2.name);
		System.out.println(s1.getrollnumber());
		System.out.println(s2.getrollnumber());
      //  System.out.println(s1);
	}

}
