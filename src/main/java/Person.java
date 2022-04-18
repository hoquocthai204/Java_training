
public class Person extends abstractClass implements interfaceDemo {
	protected String name;
	private int age;
	private String height;
	
	public Person(String name, int age, String height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	public void display() {
		System.out.println(this.name);
		System.out.println(this.age);
		System.out.println(this.height);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@Override
	int walk() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	String favorite() {
		// TODO Auto-generated method stub
		return "listen to music";
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run 10km/h");
	}

	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("I'm just kidding");
	}

	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("sleep 16h/day");
		
	}
}

