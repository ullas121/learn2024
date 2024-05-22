package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;

import com.example.demo.model.Employee;

@Controller
public class LearnController {
	
	
	public static void test() {
	  ArrayList<Employee> employees = new ArrayList<Employee>();

	  
		  employees.add(new Employee(1, "John" , 1000));
		  employees.add(new Employee(2,"Peter" , 2000)); 
		  employees.add(new Employee(3, "Ben" , 3000));
		  employees.add(new Employee(4, "Steve" , 2000)); 
		  employees.add(new Employee(5,"Parker" , 1000));
		 
Map<Integer, Set<String>> map3 =  employees.stream()
              .collect(Collectors.groupingBy
                      (Employee::getSalary, Collectors.mapping
                              (Employee::getName, Collectors.toSet())));

System.out.println("map value "+map3.toString());
map3.forEach((k,v) -> {
    
        System.out.println("salary :: "+ k + " is same for " + v);
    
});
}
	
	public static void test1() {
		 ArrayList<Employee> employees = new ArrayList<Employee>();
		  
		  employees.add(new Employee(1, "John" , 1000));
		  employees.add(new Employee(2,"Peter" , 2000)); 
		  employees.add(new Employee(3, "Ben" , 3000));
		  employees.add(new Employee(4, "Steve" , 2000)); 
		  employees.add(new Employee(5,"Parker" , 1000));
		 
		  List<Employee> emp = employees.stream().filter(empl -> empl.getSalary() > 1000).collect(Collectors.toList());
		  System.out.println(emp.toString());
		  List<Employee> emp1 = employees.stream().sorted((e1,e2) -> e1.getSalary().compareTo(e2.getSalary())).collect(Collectors.toList());
		  List<Employee> emp2 = employees.stream().sorted(Comparator.comparing(Employee:: getName)).collect(Collectors.toList());
		  Map<Boolean,List<Employee>> emp3 = employees.stream().collect(Collectors.partitioningBy(e->e.getSalary()>1000));
		  Map<Integer,List<Employee>> emp4 = employees.stream().collect(Collectors.groupingBy(Employee:: getSalary));
		  System.out.println(emp1.toString());
		  System.out.println(emp2.toString());
		  List<Employee> emp5 = employees.stream().sorted(Comparator.comparing(Employee:: getSalary).thenComparing(Employee:: getName)).collect(Collectors.toList());
		  System.out.println("------------------------------------------------------------");
		  //List<Employee> l =
				  emp3.get(true).forEach(System.out::println);
				  System.out.println(emp3);
				  System.out.println(emp4);
				  System.out.println(emp5);
				  System.out.println("------------------------------------------------------------");
		  Employee  e =  employees.stream().min((e1,e2) -> e1.getSalary().compareTo(e2.getSalary())).get();
		 System.out.println(e.toString());
		// Employee  e =  employees.stream().min().get();
		 List<Integer> al = Arrays.asList(1,2,3,5,77,23,324);
		 Integer i = al.stream().max(Integer::compare).get();
		 System.out.println(i);
		 
		 Integer i1 = al.stream().min(Integer::compare).get();
		 System.out.println(i1);
		 
		 List<String> al1 = Arrays.asList("def","abd","King","faf","max","yash");
		 al1.stream().forEach(S-> System.out.print(S+" "));
		 al1.stream().forEach(System.out::print);
		 
		 ArrayList<String> al2 = new ArrayList<String>();
		 al2.add("asd");al2.add("def");al2.add("hij");al2.add("kml");al2.add("opq");al2.add("rst");
		 al2.stream().forEach(S-> System.out.print(S+" "));
		 al2.stream().forEach(System.out::println);
		 
		 Employee e3 = employees.stream().filter(empl -> empl.getSalary() > 1000).findAny().get();
		 Employee e4 = employees.stream().filter(empl -> empl.getSalary() > 1000).findFirst().get();
		 System.out.println(e3.toString());
		 System.out.println(e4.toString());
		 //forEach(System.out::println);
		 
		 List<Integer> list = Arrays.asList(10, 19, 20, 1, 2); 
	       
		    list.parallelStream().forEachOrdered(System.out::println);
		    
		    System.out.println("========================");
		    
		    Map<Integer, String> map = new HashMap<>(); 
		    
	        // Add entries to the Map 
	        map.put(1, "Geeks"); 
	        map.put(2, "forGeeks"); 
	        map.put(3, "A computer Portal"); 
	  
	        // Print the Map 
	        System.out.println("Map: " + map); 
		    
	        //List<String> maptoList =
	        map.values().stream().map(s->s.toUpperCase()).forEach(System.out::println);
	        map.entrySet().stream().forEach(System.out::println);
	        List<String> findDuplicates = Arrays.asList("a","b","c","d","e","a","b","x","d","y");
	        HashSet<String> h = new HashSet<String>();
	        		findDuplicates.stream().filter(hm -> !h.add(hm)).
	        		forEach(System.out::println);
	        		findDuplicates.stream().distinct().forEach(System.out::println);
	        		System.out.println("after distinct ======================== " ); 
	        		// = new HashMap<Integer , String >(); 
	        		
	        	//	System.out.println(hm.toString());
	        		HashMap<String , Integer> hm = new HashMap<String , Integer>();
	        		for(int j = 0 ; j < findDuplicates.size(); j++)
	        		{
	        			Integer k = hm.get(findDuplicates.get(j));
	        			Integer l = (k == null) ? hm.put(findDuplicates.get(j),1) : hm.put(findDuplicates.get(j),k+1);
	        			/*if(k == null)
	        				hm.put(findDuplicates.get(j),1);
	        			else
	        				hm.put(findDuplicates.get(j), k+1); */
	        		}
	        		System.out.println("= "+hm.toString());
	        		
	        		hm.forEach((k,v)->{
	        			if(v > 1)
	        				System.out.println(k+" "+v);
	        		});
	        		
	        		ArrayList<String> al3 = new ArrayList<String>();
	        		al3.add("abc");al3.add("def");al3.add("ghi");al3.add("hij");al3.add("klm");
	        		List<String> al4 = al3.stream().skip(3).collect(Collectors.toList());
	        		al4.forEach(System.out::println);
	        		String [] s	=  al3.stream().toArray(String[] :: new);
	        		System.out.println(s[0]+" "+s[1]);
	}
}
