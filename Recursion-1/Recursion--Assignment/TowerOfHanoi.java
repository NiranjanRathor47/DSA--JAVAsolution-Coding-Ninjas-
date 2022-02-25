package Recrusion1Assignment;

import java.util.Scanner;

public class TowerOfHanoi {

	public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
		if(disks==0) {
			System.out.println();
    return;
        }
        if (disks == 1)
		    {
		     System.out.println( source + " " + destination);
		        return;
		    }
		    towerOfHanoi(disks - 1, source,destination , auxiliary);
		    System.out.println(source + " " + destination );
		    towerOfHanoi(disks- 1, auxiliary, source, destination);

	}
	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
		 int disks = s.nextInt();
		towerOfHanoi(disks , 'a','b','c');
	}

}
