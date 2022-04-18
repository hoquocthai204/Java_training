import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class demo1 {
	public static void main(String[] args) {
		System.out.println("Hello World");
		Scanner input = new Scanner(System.in);
		Student a = new Student("Thai", 22, "1m7");
		a.setName("Ho Quoc Thai");
//		System.out.println(a.getAge()+1);
//		System.out.println(a.favorite());
//		a.enter(input);
//		a.display();
		
	//interface
		a.run();
		a.sleep();
		a.talk();
		
	//collections
	//LIST_ARRAY_LINKED
		List<Integer> listInt = new ArrayList<Integer>();
		listInt.add(2);
		listInt.add(1);
		listInt.add(3);
		listInt.add(1,4);
				
		List<Integer> listInt2 = new LinkedList<Integer>();
		listInt2.add(10);
		listInt.addAll(listInt2);
		
		listInt2.clear();
		
		Iterator<Integer> iterator = listInt.iterator();
		
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+ "\t");
		}
		
		System.out.print("\n");
		
		for(int i=0;i<listInt.size();i++) {
			System.out.print(listInt.get(i)+"\t");
		}
		

		if(listInt.contains(3)) {
			System.out.print("\nList contains 3\n");
		}
		else System.out.print("\nList doesn't contant 3\n");
		
	//SET
		Set<Integer> setInt = new HashSet<Integer>(listInt);
		setInt.add(15);
		setInt.remove(4);
		System.out.println("output Set: "+setInt);
		
		
	//MAP
		Map<Integer, String> mapPerson = new HashMap<>();
		mapPerson.put(1, "Thai");
		mapPerson.put(2, "dep");
		mapPerson.put(4, "trai");
		
		System.out.println("output map: "+mapPerson);
		System.out.println("map keys: "+mapPerson.keySet());
		System.out.println("map values: "+mapPerson.values());
		
		Set<String> setStringName = new HashSet<>(mapPerson.values());
		System.out.println(setStringName);
		
		Set<Map.Entry<Integer, String>> setPerson = mapPerson.entrySet();
		System.out.println("output set: "+setPerson);
		
		System.out.println("value of key 2: "+mapPerson.get(2));
		mapPerson.replace(2, "xau");
	
	//TRY CATCH
		try {
			int intNum = 15;
			double result = intNum/5;
			if(result%2==0) {
				System.out.println("the result is even number");
			}
			else {
				throw new MyException("the result must be even number");
			}
		}
		catch(ArithmeticException e){
			System.out.println("loi so hoc");
		}
		catch(MyException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println("loi thuc thi");
		}
		finally {
			System.out.println("exit try-catch");
		}
		
		
	}
}
