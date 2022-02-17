package classes_and_objects;

public class ComplexNumbers {
	int real ,imaginary ;
	int temp = real ;
	public ComplexNumbers (int real ,int imaginary) {
		this.real = real ;
		this.imaginary = imaginary;
	}
	public void print() {
		System.out.println(real + " + i"+imaginary);
	}
	public void plus (ComplexNumbers c2) {
		real = this.real + c2.real ;
		imaginary = this.imaginary + c2.imaginary ;
	}
	public void multiply(ComplexNumbers c2) {
		int r=real*(c2.real)-imaginary*(c2.imaginary);
        imaginary=real*(c2.imaginary)+imaginary*(c2.real);
        real=r;
	}
}
