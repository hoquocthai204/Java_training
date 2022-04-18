import java.util.Scanner;

public class Student extends Person{
	private int grade;
	private String classroom;
	private double math, physics, chemistry, average;
	
	public Student(String name, int age, String height) {
		super(name, age, height);
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		super.display();
		System.out.println("Lop: " + this.grade);
		System.out.println("Phong: " + this.classroom);
		System.out.println("Diem toan: "+this.math);
		System.out.println("Diem ly: "+this.physics);
		System.out.println("Diem hoa: " + this.chemistry);
		System.out.println("Diem TB: " + this.average);
	}
	
	public void enter(Scanner input) {
		System.out.println("Nhap lop: ");
		grade = input.nextInt();
		System.out.println("Nhap so phong: ");
		input.nextLine();
		classroom = input.nextLine();
		System.out.println("Nhap diem toan: ");
		math = input.nextDouble();
		System.out.println("Nhap diem ly: ");
		physics = input.nextDouble();
		System.out.println("Nhap diem hoa: ");
		chemistry = input.nextDouble();
		average = (math + physics + chemistry)/3;
	}

	@Override
	String favorite() {
		// TODO Auto-generated method stub
		return super.favorite();
	}
	
	
	
}
