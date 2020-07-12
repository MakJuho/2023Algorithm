package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person>{
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person p) {
		
		if(this.age> p.age) {
			return 1;
		}else if(this.age < p.age) {
			return -1;
		}else {
			return 0;
		}
		
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}

public class specified_sort {

	public static void main(String[] args) {
		
		List<Person> nameList = new ArrayList<>();
		
		nameList.add(new Person("Heo", 28));
		nameList.add(new Person("Lee", 24));
		nameList.add(new Person("Choi", 26));
		
		System.out.println("- 정렬 전"+ nameList);
	
		Collections.sort(nameList);
		
		System.out.println("- 정렬 후 "+ nameList);
		
	}
	
}
