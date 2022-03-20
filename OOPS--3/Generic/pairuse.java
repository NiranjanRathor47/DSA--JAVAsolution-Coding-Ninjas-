package Generics;

public class pairuse {

	public static void main(String[] args) {
		Pair<String,String> p = new Pair<String,String>("abc ","cd");
    	p.setfirst("lak");
		String s = p.getfirst();
	    System.out.println(s);
		Pair <Integer,String> p1 = new Pair<Integer,String >(1,"temp");
//		System.out.println(p1.getfirst());
//		System.out.println(p1.getsecond());
		Pair <Character,Character> p2 = new Pair<>('a','e');
		System.out.println(p2.getfirst());
		System.out.println(p2.getsecond());
		
		int a=10;
		int b=87;
		int c=32;
		
		Pair<Integer,Integer> InternalPair = new Pair <>(a,b);	
		Pair<Pair<Integer,Integer>,Integer> p3 = new Pair<>(InternalPair,c);
		System.out.println(p3.getsecond());
		System.out.println(p3.getfirst().getfirst());
		System.out.println(p3.getfirst().getsecond());
	}

}