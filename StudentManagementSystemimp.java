package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.Customexception.InvalidChoiceException;
import com.Customexception.StudentIdNotFound;

import customsorting.SortByAge;
import customsorting.SortByMarks;
import customsorting.SortByName;
import customsorting.SortStudentById;

public class StudentManagementSystemimp implements StudentManagementSystem 
{
	Scanner ip=new Scanner(System.in);
	///key, value
	Map<String,Student> db=new LinkedHashMap<String,Student>();

	@Override
	public void addStudent() 
	{
		System.out.println("Enter Student age");
		int age=ip.nextInt();
		System.out.println("Enter Student Name");
		String name=ip.next();
		System.out.println("Enter Student Marks");
		int marks=ip.nextInt();
		Student std=new Student(age,name,marks);
		db.put(std.getId(), std);
		System.out.println("Student recored added Successfully!!");
		System.out.println("Student Id is:"+std.getId());
		System.out.println("-------------------------------------");




	}

	@Override
	public void displayStudent() 
	{
		System.out.println("========================================");
		System.out.println("Enter Student ID");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id))
		{
			Student std=db.get(id); //getting the student obj std will holds key
			System.out.println("ID: "+std.getId());
			System.out.println("Age: "+std.getAge());
			System.out.println("Name:"+std.getName());
			System.out.println("Marks:"+std.getMarks());
			///System.out.println(std);
		}
		else{
			try {
				throw 	new StudentIdNotFound("Student Id Not Found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}
		System.out.println("===============================================");
	}

	@Override
	public void displayAllStudents() {
		System.out.println("=======================================");
		if(db.size()!=0) {
			System.out.println("Students Details are as Follows");

			Set<String> keys=db.keySet();//jsp101
			for(String key:keys) {
				Student std= db.get(key);
				System.out.println(std);
			}

		}
		else {
			try {
				throw new StudentIdNotFound("Student Id Not Nothing To Display");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}



		}

		System.out.println("===============================================");
	}

	@Override
	public void removeStudent() {
		System.out.println("=================================");
		System.out.println("Enter Student ID");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Studnet record Found!! ");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Successfuly Removed Student:"+id);
			System.out.println("====================================");
		}
		else {
			try {
				throw new StudentIdNotFound("Student Id not Found Please Enter Valid Id!!!");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}


		}
	}

	@Override
	public void removeAllStudents() {

		if(db.size()!=0) {
			System.out.println("Student Records Avalible: "+db.size());
			db.clear();
			System.out.println("All Student records Deleted Succussfully:");
			System.out.println("Avalible Student records :"+db.size());
		}
		else {
			try {
				throw new StudentIdNotFound("Student data Base is Empty,Nothing to Delete");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


	@Override
	public void updateStudent() {

		String id=ip.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std = db.get(id);
			System.out.println("1.update Age\n2.Update Name\n3.Upadate Marks");
			System.out.println("Enter the choice:");
			int choice=ip.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter age:");
				int age=ip.nextInt();
				std.setAge(age);
				break;
			case 2:
				System.out.println("Enter Name:");
				String name=ip.next();
				std.setName(name);
				break;
			case 3:
				System.out.println("Enter Marks:");
				int marks=ip.nextInt();
				std.setMarks(marks);
				break;
			default:
				try {
					new InvalidChoiceException("InvalidChoiceException");

				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}

			}

		}
		else {
			try {
				throw new StudentIdNotFound("Student data Base is Empty,Nothing to Delete");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void countStudents() {

		System.out.println("No of Student Record:"+db.size());
	}

	@Override
	public void sortStudent() {

		Set<String> keys =db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key :keys) {
			list.add(db.get(key));
		}
		System.out.println("1:Sort by Id\n2.Sort by Age");
		System.out.println("3:Sort by Name\n2.Sort by Marks");
		System.out.println("Enter The choice:");
		int choice=ip.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(list,new SortStudentById());
			display(list);
			break;
		case 2:
			Collections.sort(list,new SortByAge());
			display(list);
			break;
		case 3:
			Collections.sort(list,new SortByName());
			display(list);

			break;
		case 4:
			Collections.sort(list,new SortByMarks());
			display(list);
			break;
		default:
			try {
				new InvalidChoiceException("InvalidChoiceException");

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}
	private static void display(List<Student> list) {
		for(Student s:list) {
			System.out.println(s);
		}
	}

	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>=2) {
			Set<String> keys =db.keySet();
			List<Student> list=new ArrayList<Student>();
			for(String key :keys) {
				list.add(db.get(key));
			}
			Collections.sort(list,new SortByMarks());

			System.out.println(list.get(list.size()-1));
		}
		else {
			try {
				String message="no sufficent records to sort";
				 throw new StudentIdNotFound(message);
				
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				
			}
		}

		
	}

	@Override
	public void getStudentWithLowestMarks() {

		Set<String> keys =db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key :keys) {
			list.add(db.get(key));
		}
		Collections.sort(list,new SortByMarks());
		System.out.println(list.get(0));
	}

}
