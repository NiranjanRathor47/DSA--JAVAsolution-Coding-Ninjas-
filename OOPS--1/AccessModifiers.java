package classes_and_objects;

public class AccessModifiers {
	  String name ;
	 private int rollnumber ;
	 
	 public void setrollnum(int rn) {
		 if(rn<=0) {
			 return ;
		 }
		 rollnumber = rn ;
	 }
	 public int getrollnumber() {
		 return rollnumber;
	 }
}
