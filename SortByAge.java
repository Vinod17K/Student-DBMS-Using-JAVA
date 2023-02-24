package customsorting;

import java.util.Comparator;

import sdbms.Student;

public class SortByAge implements Comparator<Student>
{

	@Override
	public int compare(Student x, Student y) {
		return x.getAge()-y.getAge();
	}
	

}
