package com.mj;

class Main {

	public static void main(String[] args) {
		
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person("Jack",10));
		persons.add(new Person("Bob",12));
		persons.add(null);
		persons.add(new Person("mark",20));
		System.out.println(persons);
		
		System.out.println(persons.indexOf(null));
		// 提醒JVM进行垃圾回收 - 不是实时收回
		System.gc();
		System.runFinalization();
	}
	
	void test() {
//		int array[] = new int [] {111,222,333};
				
		ArrayList<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Jack",10));
		persons.add(new Person("Bob",12));
		persons.add(new Person("mark",20));
		persons.add(new Person("peter",45));
		System.out.println(persons);
		
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.add(10);
		ints.add(20);
		ints.add(30);
		System.out.println(ints);
		
		//ArrayList<Integer> arrayList = new ArrayList<>();
		
		//ArrayList<Integer> arrayList = new ArrayList<>();
//		arrayList.add(0);
//		arrayList.add(1);
//		arrayList.add(2);
//		arrayList.add(3);
//		arrayList.add(4);
//		arrayList.add(5);
		
		
//		System.out.println(arrayList);
//		
//		arrayList.add(arrayList.size(), -1);
//		
//		System.out.println(arrayList);
//		
//		Assert.test(arrayList.get(arrayList.size()-1) == -1);
		
//		DynamicAttay array = new DynamicAttay();
//		array.add(11);
	}

}
