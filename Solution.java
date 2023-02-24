package sdbms;

import java.util.Scanner;
import com.Customexception.InvalidChoiceException;


public class Solution {
	public static void main(String[] args) {
		System.out.println("Welcome to Student Data Basw Project System");
		System.out.println("--------------------------------------------------");
		Scanner ip=new Scanner(System.in);
		StudentManagementSystem sms=new StudentManagementSystemimp();
		while(true) {
			System.out.println("1.AddStudent\n2.displayStudent\n3.displayAllStudents\n4.removeStudent");
			System.out.println("5.removeAllStudents\n6.updateStudent\n7.countStudents\n8.sortStudent");
			System.out.println("9.getStudentWithHighestMarks\n10.getStudentWithLowestMarks");
			System.out.println("11.Exit\nEnter Choice");
			int choice=ip.nextInt();

			switch(choice) {

			case 1 :
				sms.addStudent();
				break;
			case 2 :
				sms.displayStudent();
				break;
			case 3 :
				sms.displayAllStudents();
				break;
			case 4 :
				sms.removeStudent();
				break;
			case 5 :
				sms.removeAllStudents();
				break;
			case 6 :
				sms.updateStudent();
				break;
			case 7 :
				sms.countStudents();
				break;
			case 8 :
				sms.sortStudent();
				break;
			case 9 :
				sms.getStudentWithHighestMarks();
				break;
			case 10:
				sms.getStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("Thank you Visit Again!!");
				System.exit(0);
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


	}

}
